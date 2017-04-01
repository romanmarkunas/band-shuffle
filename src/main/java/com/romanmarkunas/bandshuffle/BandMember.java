package com.romanmarkunas.bandshuffle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BandMember {

    private int id;     // this parameter is necessary for deleting and updating, but not for creating
                        // consider builder pattern here
    private String name;
    private String surname;
    private Instrument instrument;
//    private ArrayList<Instrument> instrumentList;
//    private Instrument selectedInstrument;

//
//    private Load maxLoad;
//    private ArrayList<LocalDate> unavailable;
//    private boolean canLead;


    BandMember(String name, String surname, Instrument instrument) {

        this.name = name;
        this.surname = surname;
        this.instrument = instrument;
//        this.instrumentList = new ArrayList<>();
//        this.selectedInstrument = null;
    }

/*
    void addInstrument(Instrument i) {

        if (!instrumentList.contains(i)) {

            instrumentList.add(i);
        }
    }

    void selectInstrument(Instrument i) {

        if (instrumentList.contains(i)) {

            selectedInstrument = i;
        }
    }
*/
    String getFullName() { return (name + " " + surname); }

    Instrument getInstrument() { return instrument; }

    //    List<Instrument> getInstruments() { return instrumentList; }
//    Instrument getSelectedInstrument() { return selectedInstrument; }


    @Override
    public String toString() {

        return this.getFullName();
    }
}
