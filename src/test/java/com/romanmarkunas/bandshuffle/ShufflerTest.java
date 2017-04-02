package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShufflerTest {

    private List<BandMember> bandMembers;


    @Before
    public void setUp() {

        bandMembers = new ArrayList<>();
        bandMembers.add(new BandMember("John", "Doe", Talent.ACOUSTIC_GUITAR));
        bandMembers.add(new BandMember("Mike", "Foo", Talent.KEYBOARD));
        bandMembers.add(new BandMember("Igor", "Pro", Talent.VOICE));
        bandMembers.add(new BandMember("Linn", "Vue", Talent.VOICE));
    }

    @Test
    public void shuffle() {

        Shuffler testShuffler = new Shuffler();

        Map<Talent, Integer> testBandComposition = new HashMap<>();
        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 1);
        testBandComposition.put(Talent.KEYBOARD, 1);
        testBandComposition.put(Talent.VOICE, 1);

        System.out.println(testShuffler.shuffle(4, new Band(testBandComposition), bandMembers));
    }
}