package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BandTest {

    private Map<Instrument, Integer> testBandComposition;
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

        john = new BandMember("John", "Doe", Instrument.ACOUSTIC_GUITAR);
        lola = new BandMember("Lola", "Mei", Instrument.ACOUSTIC_GUITAR);
        mike = new BandMember("Mike", "Foo", Instrument.KEYBOARD);
        igor = new BandMember("Igor", "Pro", Instrument.VOICE);
        linn = new BandMember("Linn", "Vue", Instrument.VOICE);
        bill = new BandMember("Bill", "Doe", Instrument.BASE);
    }

    @Test
    public void add() {

        testBandComposition.put(Instrument.ACOUSTIC_GUITAR, 2);
        testBandComposition.put(Instrument.KEYBOARD, 1);
        testBandComposition.put(Instrument.VOICE, 1);

        testBand = new Band(testBandComposition);

        assertFalse(testBand.add(bill, bill.getInstrument()));  // shouldn't add since no instrument of that kind needed

        assertTrue(testBand.add(john, john.getInstrument()));   // should add
        assertFalse(testBand.add(john, john.getInstrument()));  // do not add since it's the same musician and instrument
        assertFalse(testBand.full());

        assertTrue(testBand.add(igor, igor.getInstrument()));   // should add
        assertFalse(testBand.full());

        assertFalse(testBand.add(linn, linn.getInstrument()));  // do not add since we've got enough of this instrument

        assertTrue(testBand.add(mike, mike.getInstrument()));   // should add
        assertFalse(testBand.full());

        assertTrue(testBand.add(lola, lola.getInstrument()));   // should add
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

        testBandComposition.put(Instrument.ACOUSTIC_GUITAR, 2);

        testBand = new Band(testBandComposition);

        assertTrue(testBand.add(john, john.getInstrument()));   // should add
        assertTrue(testBand.add(lola, lola.getInstrument()));   // should add
        assertTrue(testBand.full());                            // should be full

        assertFalse(testBand.remove(mike));                     // not remove since wasn't there
        assertTrue(testBand.remove(john));                      // should remove
        assertFalse(testBand.full());                           // shouldn't be full

        assertTrue(testBand.add(john, john.getInstrument()));   // should add if previous made correct maintenance
        assertTrue(testBand.full());                            // should be full again

        Map<BandMember, List<Instrument>> expected = new HashMap<>();
        List<Instrument> listWithAcoustic = new LinkedList<>();
        listWithAcoustic.add(Instrument.ACOUSTIC_GUITAR);
        expected.put(john, listWithAcoustic);
        expected.put(lola, listWithAcoustic);

        assertEquals(expected, testBand.getMembers());
    }

    @Test
    public void getBandWithSameComposition() {

        testBandComposition.put(Instrument.ACOUSTIC_GUITAR, 5);

        testBand = new Band(testBandComposition);
        Band bandByReferenceComposition = testBand.getBandWithSameComposition();

        assertEquals(testBand.getInstrumentComposition(), bandByReferenceComposition.getInstrumentComposition());
    }
}
