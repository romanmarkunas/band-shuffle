package com.romanmarkunas.bandshuffle;

import java.time.LocalDate;
import java.util.ArrayList;


public class BandMember {

    private String name;
    private String surname;
    private ArrayList<Instrument> instrumentList;
    private Load maxLoad;
    private ArrayList<LocalDate> unavailable;
    private boolean canLead;


    public String getName() { return this.name; }
    public String getSurname() { return surname; }
    public String getFullName() { return (name + " " + surname); }
}
