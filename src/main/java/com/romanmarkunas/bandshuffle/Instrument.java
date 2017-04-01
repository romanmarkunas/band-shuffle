package com.romanmarkunas.bandshuffle;


public enum Instrument {

    VOICE("Vocals"),
    KEYBOARD("Keys"),
    ACOUSTIC_GUITAR("Acoustic guitar"),
    ELECTRIC_GUITAR("Electric guitar"),
    BASE("Base"),
    DRUMS("Drums");


    private String printableName;


    Instrument(String printableName) {

        this.printableName = printableName;
    }

    @Override
    public String toString() {
        return this.printableName;
    }
}
