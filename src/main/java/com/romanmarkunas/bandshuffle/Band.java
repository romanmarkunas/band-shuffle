package com.romanmarkunas.bandshuffle;

import java.util.*;

class Band {

    private final Map<Instrument, Integer> instrumentComposition;
    private Map<Instrument, Integer> instrumentsToFill;
    private Map<BandMember, List<Instrument>> members;


    Band(Map<Instrument, Integer> instrumentComposition) {

        this.members = new HashMap<>();
        this.instrumentComposition = new HashMap<>(instrumentComposition);
        this.instrumentsToFill = new HashMap<>(instrumentComposition);
    }


    boolean add(BandMember member, Instrument instrument) {

        if (instrumentsToFill.containsKey(instrument)) {

            int moreNeeded = instrumentsToFill.get(instrument);

            if (moreNeeded > 0) {

                if (!members.containsKey(member)) {

                    members.put(member, new ArrayList<>(2));
                }

                List<Instrument> musicianInstruments = members.get(member);

                if (!musicianInstruments.contains(instrument)) {

                    members.get(member).add(instrument);

                    instrumentsToFill.put(instrument, moreNeeded - 1);

                    return true;
                }
            }
        }

        return false;
    }

    boolean remove(BandMember member) {

        if (members.containsKey(member)) {

            List<Instrument> musicianInstruments = members.get(member);

            for (Instrument i : musicianInstruments) {

                instrumentsToFill.put(i, instrumentsToFill.get(i) + 1);
            }

            members.remove(member);
            return true;
        }

        return false;
    }

    boolean full() {

        for (Integer moreNeeded : instrumentsToFill.values()) {

            if (moreNeeded > 0) {

                return false;
            }
        }

        return true;
    }

    Band getBandWithSameComposition() {

        return new Band(instrumentComposition);
    }

    Map<Instrument, Integer> getInstrumentComposition() {

        return new HashMap<>(instrumentComposition);
    }

    Map<BandMember, List<Instrument>> getMembers() {

        return new HashMap<>(members);
    }

    @Override
    public String toString() {

        return members.toString();
    }
}
