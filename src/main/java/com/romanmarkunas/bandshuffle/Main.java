package com.romanmarkunas.bandshuffle;


import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // TODO - builder for BandMember with 2 methods, buildFromDatabase and buildNew (from database has id to supply)
        // when building from database

        // TODO - strategy patter for shuffle class to choose different sorters: spread evenly, random - these will
        // automatically spread different people in the list of performance dates

        // TODO - algorithm must copy all members from database, sort them according to criterias based on chosen sorter
        // During shuffling you take first member and if it fits you remove it from list, update it and put its sorting
        // criteria in special variables. it is then inserted back in list during further parsing when it is appropriate
        // this can remove overhead of resorting list every time if done properly. OR maybe it is more efficient to resort
        // every time, but use binary tree. There is option to use hash list for that matter also and then on hash collision
        // use provided sorting strategy

        // TODO - IDEA - each members capacity can be evaluated mathematically as LoadFactor x TalentSet for each
        // Talent set he has => you get n mathematical representations where n is 8 possible member talent sets
        // then you can combine these via some smart algo or at least with brute force and see which combinations are
        // not providing sufficient required capacity. Then use combinations which provide required capacity to
        // form rota. Add members to band not via member + Talent, but with member + talent set to utilize full
        // member capacity easily. Exact combination can be selected with mentioned strategies. This also helps for
        // different choosing strategies like exploit members on full to allow for longer breaks or load as less as
        // possible

        // create comparator objects for band members for dynamic sorting
/*
        BandMemberDAO dao = new BandMemberDAO();
        BandMemberDisplayFormatter formatter = new BandMemberDisplayFormatter();

        BandMember ash = new BandMember("Ash", "Richards");
        ash.addInstrument(Talent.BASE);
        ash.addInstrument(Talent.KEYBOARD);
        BandMember phil = new BandMember("Phil", "Wooley");
        phil.addInstrument(Talent.KEYBOARD);
        phil.addInstrument(Talent.VOICE);
        BandMember eli = new BandMember("Eli", "Hawkins");
        eli.addInstrument(Talent.DRUMS);

        dao.save(ash);
        dao.save(phil);
        dao.save(eli);

        for (BandMember bandMember : dao.getAllMembers()) {

            selectRandomInstrument(bandMember);
            System.out.println(formatter.formatForConsole(bandMember));
        }

        dao.delete(ash);
        dao.delete(phil);
        dao.delete(eli);*/
    }

/*
    private static void selectRandomInstrument(BandMember bm) {

        List<Talent> instruments = bm.getInstruments();
        Random randomizer = new Random();
        int selected = randomizer.nextInt(instruments.size());
        bm.selectInstrument(instruments.get(selected));
    }*/
}
