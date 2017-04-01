package com.romanmarkunas.bandshuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Shuffler {

    List<Band> shuffle(int weeks, Band referenceComposition, List<BandMember> musicians) {

        List<Band> rota = new ArrayList<>(weeks);
        Random rn = new Random();


        for (int i = 1; i <= weeks; i++) {

            Band band = referenceComposition.getBandWithSameComposition();

            while (!band.full()) {

                BandMember randomMusiscian = musicians.get(rn.nextInt(musicians.size()));

                band.add(randomMusiscian, randomMusiscian.getInstrument());
            }

            rota.add(band);
        }

        return rota;
    }
}
