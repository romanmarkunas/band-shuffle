package com.romanmarkunas.bandshuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Shuffler {

    List<Band> shuffle(int weeks, Band referenceComposition, List<BandMember> musicians) {

        List<Band> rota = new ArrayList<>(weeks);
        Random rn = new Random();


        for (int i = 1; i <= weeks; i++) {

            Band band = referenceComposition.getComposition();

            while (!band.full()) {

                band.add(musicians.get(rn.nextInt(musicians.size())));
            }

            rota.add(band);
        }

        return rota;
    }
}
