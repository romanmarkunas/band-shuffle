package com.romanmarkunas.bandshuffle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BandMember {

    private String name;
    private String surname;
    private ArrayList<Instrument> instrumentList;
    private Load maxLoad;
    private ArrayList<LocalDate> unavailable;
    private boolean canLead;
    private Instrument selectedInstrument;


    BandMember(String name, String surname) {

        this.name = name;
        this.surname = surname;
        this.instrumentList = new ArrayList<>();
        this.selectedInstrument = null;
    }


    public void addInstrument(Instrument i) {

        if (!instrumentList.contains(i)) {

            instrumentList.add(i);
        }
    }

    public void selectInstrument(Instrument i) {

        if (instrumentList.contains(i)) {

            selectedInstrument = i;
        }
    }

    public String getFullName() { return (name + " " + surname); }
    public List<Instrument> getInstruments() { return instrumentList; }
    public Instrument getSelectedInstrument() { return selectedInstrument; }
}
