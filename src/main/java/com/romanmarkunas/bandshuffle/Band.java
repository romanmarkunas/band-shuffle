package com.romanmarkunas.bandshuffle;

import com.romanmarkunas.bandshuffle.domain.BandMember;
import com.romanmarkunas.bandshuffle.domain.Talent;

import java.util.*;

public class Band {

    private final Map<Talent, Integer> composition;
    private Map<Talent, Integer> talentsToFill;
    private Map<BandMember, Set<Talent>> members;


    public Band(Map<Talent, Integer> composition) {

        this.members = new HashMap<>();
        this.composition = new HashMap<>(composition);
        this.talentsToFill = new HashMap<>(composition);
    }


    public boolean add(BandMember member, Set<Talent> talentSet) {

        boolean addSuccessful = false;

        if (member == null || members.containsKey(member) || talentSet == null) {

            return false;
        }

        for (Talent talent : talentSet) {

            if (talentsToFill.containsKey(talent)) {

                int moreNeeded = talentsToFill.get(talent);

                if (moreNeeded > 0) {

                    if (!members.containsKey(member)) {

                        members.put(member, new HashSet<>());
                    }

                    if (members.get(member).add(talent)) {

                        talentsToFill.put(talent, moreNeeded - 1);
                        addSuccessful = true;
                    }
                }
            }
        }

        return addSuccessful;
    }

    public boolean remove(BandMember member) {

        if (members.containsKey(member)) {

            Set<Talent> musicianTalents = members.get(member);

            for (Talent i : musicianTalents) {

                talentsToFill.put(i, talentsToFill.get(i) + 1);
            }

            members.remove(member);
            return true;
        }

        return false;
    }

    public boolean full() {

        for (Integer moreNeeded : talentsToFill.values()) {

            if (moreNeeded > 0) { return false; }
        }

        return true;
    }

    public Band getBandWithSameComposition() {

        return new Band(composition);
    }

    public Map<Talent, Integer> getComposition() {

        return new HashMap<>(composition);
    }

    public Map<BandMember, Set<Talent>> getMembers() {

        return Collections.unmodifiableMap(members);
    }

    @Override
    public String toString() {

        return members.toString();
    }
}
