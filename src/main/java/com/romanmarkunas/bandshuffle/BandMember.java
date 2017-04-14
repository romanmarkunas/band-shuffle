package com.romanmarkunas.bandshuffle;


import java.util.*;

public class BandMember {

    private int id;     // this parameter is necessary for deleting and updating, but not for creating
                        // consider builder pattern here
    private String name;
    private String surname;
    private Set<Set<Talent>> talentCombos;
    private String email;

//    private Load maxLoad;
//    private ArrayList<LocalDate> unavailable;
//    private ArrayList<LocalData> lastYearPerformances;

    BandMember(int id, String name, String surname, String email) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.talentCombos = new HashSet<>();
    }


    public int getId() { return id; }

    public String getFullName() { return (name + " " + surname); }

    public String getEmail() { return email; }

    public void addSimultaneouslyUsable(Set<Talent> talentSet) {

        if (talentSet != null && !talentSet.isEmpty()) {

            talentCombos.add(talentSet);
        }
    }

    public void removeTalent(Talent talent) {

        talentCombos.removeIf(talents -> talents.contains(talent));
    }

    // TODO - create immutable sets here for safety
    public Set<Set<Talent>> getTalentCombos() { return Collections.unmodifiableSet(talentCombos); }

    @Override
    public String toString() {

        return this.getFullName();
    }
}
