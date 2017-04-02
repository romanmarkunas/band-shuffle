package com.romanmarkunas.bandshuffle;


public class BandMember {

    private int id;     // this parameter is necessary for deleting and updating, but not for creating
                        // consider builder pattern here
    private String name;
    private String surname;
    private Talent talent;
//    private ArrayList<Talent> instrumentList;
//    private Talent selectedInstrument;

//
//    private Load maxLoad;
//    private ArrayList<LocalDate> unavailable;
//    private boolean canLead;


    BandMember(String name, String surname, Talent talent) {

        this.name = name;
        this.surname = surname;
        this.talent = talent;
//        this.instrumentList = new ArrayList<>();
//        this.selectedInstrument = null;
    }

/*
    void addInstrument(Talent i) {

        if (!instrumentList.contains(i)) {

            instrumentList.add(i);
        }
    }

    void selectInstrument(Talent i) {

        if (instrumentList.contains(i)) {

            selectedInstrument = i;
        }
    }
*/
    String getFullName() { return (name + " " + surname); }

    Talent getTalent() { return talent; }

    //    List<Talent> getInstruments() { return instrumentList; }
//    Talent getSelectedInstrument() { return selectedInstrument; }


    @Override
    public String toString() {

        return this.getFullName();
    }
}
