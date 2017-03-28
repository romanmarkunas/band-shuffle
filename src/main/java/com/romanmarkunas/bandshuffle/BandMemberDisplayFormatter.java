package com.romanmarkunas.bandshuffle;


public class BandMemberDisplayFormatter {

    public String formatForConsole(BandMember bm) {

        return (bm.getFullName() + "::" + bm.getSelectedInstrument().name());
    }
}
