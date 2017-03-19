package com.romanmarkunas.bandshuffle;


import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        BandMemberDAO dao = new BandMemberDAO();
        BandMemberDisplayFormatter formatter = new BandMemberDisplayFormatter();

        BandMember ash = new BandMember("Ash", "Richards");
        ash.addInstrument(Instrument.BASE);
        ash.addInstrument(Instrument.KEYBOARD);
        BandMember phil = new BandMember("Phil", "Wooley");
        phil.addInstrument(Instrument.KEYBOARD);
        phil.addInstrument(Instrument.VOICE);
        BandMember eli = new BandMember("Eli", "Hawkins");
        eli.addInstrument(Instrument.DRUMS);

        dao.save(ash);
        dao.save(phil);
        dao.save(eli);

        for (BandMember bandMember : dao.getAllMembers()) {

            selectRandomInstrument(bandMember);
            System.out.println(formatter.formatForConsole(bandMember));
        }

        dao.delete(ash);
        dao.delete(phil);
        dao.delete(eli);
    }


    private static void selectRandomInstrument(BandMember bm) {

        List instruments = bm.getInstruments();
        Random randomizer = new Random();
        int selected = randomizer.nextInt(instruments.size());
        bm.selectInstrument(Instrument.values()[selected]);
    }
}
