package com.romanmarkunas.bandshuffle;


import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // TODO - strategy patter for shuffle class to choose different sorters: spread evenly, random - these will
        // automatically spread different people in the list of performance dates

        // TODO - algorithm must copy all members from database, sort them according to criterias based on chosen sorter
        // During shuffling you take first member and if it fits you remove it from list, update it and put its sorting
        // criteria in special variables. it is then inserted back in list during further parsing when it is appropriate
        // this can remove overhead of resorting list every time if done properly. OR maybe it is more efficient to resort
        // every time, but use binary tree. There is option to use hash list for that matter also and then on hash collision
        // use provided sorting strategy

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

        List<Instrument> instruments = bm.getInstruments();
        Random randomizer = new Random();
        int selected = randomizer.nextInt(instruments.size());
        bm.selectInstrument(instruments.get(selected));
    }
}
