package com.romanmarkunas.bandshuffle;

import com.romanmarkunas.bandshuffle.domain.Band;
import com.romanmarkunas.bandshuffle.domain.BandMember;
import com.romanmarkunas.bandshuffle.domain.Talent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

class Shuffler {

    List<Band> shuffle(int weeks, Band referenceComposition, List<BandMember> musicians) {

        List<Band> rota = new ArrayList<>(weeks);
        Random rn = new Random();


        for (int i = 1; i <= weeks; i++) {

            Band band = referenceComposition.getBandWithSameComposition();

            while (!band.full()) {

                BandMember randomMusiscian = musicians.get(rn.nextInt(musicians.size()));
                List<Set<Talent>> randomMusicianTalents = new ArrayList<>(randomMusiscian.getTalentCombos());
                Set<Talent> randomTalentSet = randomMusicianTalents.get(rn.nextInt(randomMusicianTalents.size()));
                band.add(randomMusiscian, randomTalentSet);
            }

            rota.add(band);
        }

        return rota;
    }
}
