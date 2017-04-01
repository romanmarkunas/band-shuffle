package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShufflerTest {

    private List<BandMember> bandMembers;


    @Before
    public void setUp() {

        bandMembers = new ArrayList<>();
        bandMembers.add(new BandMember("John", "Doe"));
        bandMembers.add(new BandMember("Mike", "Foo"));
        bandMembers.add(new BandMember("Igor", "Pro"));
        bandMembers.add(new BandMember("Linn", "Vue"));
    }

    @Test
    public void shuffle() {

        Shuffler testShuffler = new Shuffler();

        System.out.println(testShuffler.shuffle(4, new Band(3), bandMembers));
    }
}