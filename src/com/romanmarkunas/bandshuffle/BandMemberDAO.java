package com.romanmarkunas.bandshuffle;

import java.util.ArrayList;
import java.util.List;


public class BandMemberDAO {

    private ArrayList<BandMember> database;


    BandMemberDAO() {

        database = new ArrayList<>();
    }


    public void save(BandMember bm) {

        database.add(bm);
        System.out.println("Saving band member " + bm.getFullName());
    }

    public void delete(BandMember bm) {

        if (database.contains(bm)) {

            database.remove(bm);
            System.out.println("Deleting " + bm.getFullName() + " from database");
        }
    }

    public List<BandMember> getAllMembers() {

        return database;
    }
}
