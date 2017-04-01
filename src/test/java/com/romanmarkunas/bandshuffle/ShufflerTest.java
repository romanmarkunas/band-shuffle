package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ShufflerTest {

    private List<BandMember> bandMembers;


    @Before
    public void setUp() {

        bandMembers = new ArrayList<>();
        bandMembers.add(new BandMember("John", "Doe", Instrument.ACOUSTIC_GUITAR));
        bandMembers.add(new BandMember("Mike", "Foo", Instrument.KEYBOARD));
        bandMembers.add(new BandMember("Igor", "Pro", Instrument.VOICE));
        bandMembers.add(new BandMember("Linn", "Vue", Instrument.VOICE));
    }

    @Test
    public void shuffle() {

        Shuffler testShuffler = new Shuffler();

        Map<Instrument, Integer> testBandComposition = new HashMap<>();
        testBandComposition.put(Instrument.ACOUSTIC_GUITAR, 1);
        testBandComposition.put(Instrument.KEYBOARD, 1);
        testBandComposition.put(Instrument.VOICE, 1);

        System.out.println(testShuffler.shuffle(4, new Band(testBandComposition), bandMembers));
    }
}