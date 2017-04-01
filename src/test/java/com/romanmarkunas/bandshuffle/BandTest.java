package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BandTest {

    private Band testBand;

    private BandMember john;
    private BandMember mike;
    private BandMember igor;
    private BandMember linn;


    @Before
    public void setUp() {

        john = new BandMember("John", "Doe");
        mike = new BandMember("Mike", "Foo");
        igor = new BandMember("Igor", "Pro");
        linn = new BandMember("Linn", "Vue");
    }

    @Test
    public void addAndFull() {

        testBand = new Band(3);

        assertTrue(testBand.add(john));
        assertFalse(testBand.add(john));
        assertFalse(testBand.full());

        assertTrue(testBand.add(mike));
        assertFalse(testBand.full());

        assertTrue(testBand.add(igor));
        assertTrue(testBand.full());

        assertFalse(testBand.add(linn));

        System.out.println(testBand);
    }

    @Test
    public void getComposition() {

        for (int i = 0; i < 10; i++) {

            testBand = new Band(i * 2);
            Band bandByReferenceComposition = testBand.getComposition();
            assertEquals(testBand.getSize(), bandByReferenceComposition.getSize());
        }
    }
}
