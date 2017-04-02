package com.romanmarkunas.bandshuffle;

import java.util.*;

class Band {

    private final Map<Talent, Integer> composition;
    private Map<Talent, Integer> talentsToFill;
    private Map<BandMember, List<Talent>> members;


    Band(Map<Talent, Integer> composition) {

        this.members = new HashMap<>();
        this.composition = new HashMap<>(composition);
        this.talentsToFill = new HashMap<>(composition);
    }


    boolean add(BandMember member, Talent talent) {

        if (talentsToFill.containsKey(talent)) {

            int moreNeeded = talentsToFill.get(talent);

            if (moreNeeded > 0) {

                if (!members.containsKey(member)) {

                    members.put(member, new ArrayList<>(2));
                }

                List<Talent> musicianTalents = members.get(member);

                if (!musicianTalents.contains(talent)) {

                    members.get(member).add(talent);

                    talentsToFill.put(talent, moreNeeded - 1);

                    return true;
                }
            }
        }

        return false;
    }

    boolean remove(BandMember member) {

        if (members.containsKey(member)) {

            List<Talent> musicianTalents = members.get(member);

            for (Talent i : musicianTalents) {

                talentsToFill.put(i, talentsToFill.get(i) + 1);
            }

            members.remove(member);
            return true;
        }

        return false;
    }

    boolean full() {

        for (Integer moreNeeded : talentsToFill.values()) {

            if (moreNeeded > 0) {

                return false;
            }
        }

        return true;
    }

    Band getBandWithSameComposition() {

        return new Band(composition);
    }

    Map<Talent, Integer> getComposition() {

        return new HashMap<>(composition);
    }

    Map<BandMember, List<Talent>> getMembers() {

        return new HashMap<>(members);
    }

    @Override
    public String toString() {

        return members.toString();
    }
}
