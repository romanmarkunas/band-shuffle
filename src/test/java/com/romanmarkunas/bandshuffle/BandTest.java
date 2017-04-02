package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BandTest {

    private Map<Talent, Integer> testBandComposition;
    private Band testBand;

    private BandMember john;
    private BandMember lola;
    private BandMember mike;
    private BandMember igor;
    private BandMember linn;
    private BandMember bill;


    @Before
    public void setUp() {

        testBandComposition = new HashMap<>();

        john = new BandMember("John", "Doe", Talent.ACOUSTIC_GUITAR);
        lola = new BandMember("Lola", "Mei", Talent.ACOUSTIC_GUITAR);
        mike = new BandMember("Mike", "Foo", Talent.KEYBOARD);
        igor = new BandMember("Igor", "Pro", Talent.VOICE);
        linn = new BandMember("Linn", "Vue", Talent.VOICE);
        bill = new BandMember("Bill", "Doe", Talent.BASE);
    }

    @Test
    public void add() {

        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 2);
        testBandComposition.put(Talent.KEYBOARD, 1);
        testBandComposition.put(Talent.VOICE, 1);

        testBand = new Band(testBandComposition);

        assertFalse(testBand.add(bill, bill.getTalent()));      // shouldn't add since no instrument of that kind needed

        assertTrue(testBand.add(john, john.getTalent()));       // should add
        assertFalse(testBand.add(john, john.getTalent()));      // do not add since it's the same musician and instrument
        assertFalse(testBand.full());

        assertTrue(testBand.add(igor, igor.getTalent()));       // should add
        assertFalse(testBand.full());

        assertFalse(testBand.add(linn, linn.getTalent()));      // do not add since we've got enough of this instrument

        assertTrue(testBand.add(mike, mike.getTalent()));       // should add
        assertFalse(testBand.full());

        assertTrue(testBand.add(lola, lola.getTalent()));       // should add
        assertTrue(testBand.full());                            // should be full

        String[] expected = {"Igor Pro=[Vocals]", "John Doe=[Acoustic guitar]", "Mike Foo=[Keys]", "Lola Mei=[Acoustic guitar]"};
        Arrays.sort(expected);

        String testBandRepresentation = testBand.toString();
        String[] output = testBandRepresentation.substring(1, testBandRepresentation.length() - 1).split(", ");
        Arrays.sort(output);

        assertArrayEquals(expected, output);
        assertEquals("{", testBandRepresentation.substring(0, 1));
        assertEquals("}", testBandRepresentation.substring(testBandRepresentation.length() - 1, testBandRepresentation.length()));
    }

    @Test
    public void remove() {

        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 2);

        testBand = new Band(testBandComposition);

        assertTrue(testBand.add(john, john.getTalent()));       // should add
        assertTrue(testBand.add(lola, lola.getTalent()));       // should add
        assertTrue(testBand.full());                            // should be full

        assertFalse(testBand.remove(mike));                     // not remove since wasn't there
        assertTrue(testBand.remove(john));                      // should remove
        assertFalse(testBand.full());                           // shouldn't be full

        assertTrue(testBand.add(john, john.getTalent()));       // should add if previous made correct maintenance
        assertTrue(testBand.full());                            // should be full again

        Map<BandMember, List<Talent>> expected = new HashMap<>();
        List<Talent> listWithAcoustic = new LinkedList<>();
        listWithAcoustic.add(Talent.ACOUSTIC_GUITAR);
        expected.put(john, listWithAcoustic);
        expected.put(lola, listWithAcoustic);

        assertEquals(expected, testBand.getMembers());
    }

    @Test
    public void getBandWithSameComposition() {

        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 5);

        testBand = new Band(testBandComposition);
        Band bandByReferenceComposition = testBand.getBandWithSameComposition();

        assertEquals(testBand.getComposition(), bandByReferenceComposition.getComposition());
    }
}
