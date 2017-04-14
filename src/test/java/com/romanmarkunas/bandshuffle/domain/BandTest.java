package com.romanmarkunas.bandshuffle.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.*;

public class BandTest {

    private Map<Talent, Integer> testBandComposition;
    private Band testBand;

    private BandMember john;
    private BandMember lola;
    private BandMember mike;
    private BandMember linn;
    private BandMember bill;

    private Set<Talent> typicalLeader;
    private Set<Talent> singer;
    private Set<Talent> guitarist;
    private Set<Talent> keys;


    @Before
    public void setUp() {

        testBandComposition = new HashMap<>();

        // talent sets
        typicalLeader = new HashSet<>();
        typicalLeader.add(Talent.LEAD);
        typicalLeader.add(Talent.VOICE);
        typicalLeader.add(Talent.ACOUSTIC_GUITAR);

        singer = new HashSet<>();
        singer.add(Talent.VOICE);

        guitarist = new HashSet<>();
        guitarist.add(Talent.ACOUSTIC_GUITAR);

        keys = new HashSet<>();
        keys.add(Talent.KEYBOARD);

        // band members
        john = mock(BandMember.class);
        when(john.toString()).thenReturn("John Doe");
        lola = mock(BandMember.class);
        when(lola.toString()).thenReturn("Lola Mei");
        mike = mock(BandMember.class);
        when(mike.toString()).thenReturn("Mike Cho");
        linn = mock(BandMember.class);
        when(linn.toString()).thenReturn("Linn Vue");
        bill = mock(BandMember.class);
        when(bill.toString()).thenReturn("Bill Elk");
    }

    @Test
    public void add() {

        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 1);
        testBandComposition.put(Talent.VOICE, 2);

        testBand = new Band(testBandComposition);

        assertFalse(testBand.add(john, keys));                  // shouldn't add since no instrument of that kind needed
        assertTrue(testBand.add(john, singer));                 // should add
        assertFalse(testBand.add(john, guitarist));             // do not add since it's the same musician
        assertFalse(testBand.full());
        assertTrue(testBand.add(lola, guitarist));              // should add
        assertFalse(testBand.add(linn, guitarist));             // do not add since guitarist slots are full
        assertFalse(testBand.add(bill, null));         // check reaction on null
        assertFalse(testBand.add(null, singer));        // check reaction on null
        assertTrue(testBand.add(mike, typicalLeader));          // should add, but not use all of his talents

        Set<Talent> mikeExpectedUsed = new HashSet<>();
        mikeExpectedUsed.add(Talent.VOICE);
        assertEquals(mikeExpectedUsed, testBand.getMembers().get(mike));

        assertTrue(testBand.full());

        String[] expected = {"John Doe=[Vocals]", "Mike Cho=[Vocals]", "Lola Mei=[Acoustic guitar]"};
        Arrays.sort(expected);

        String testBandRepresentation = testBand.toString();
        System.out.println(testBand);
        String[] output = testBandRepresentation.substring(1, testBandRepresentation.length() - 1).split(", ");
        Arrays.sort(output);

        assertArrayEquals(expected, output);
    }

    @Test
    public void addWithMaxEfficiency() {

        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 1);
        testBandComposition.put(Talent.VOICE, 1);
        testBandComposition.put(Talent.LEAD, 1);

        testBand = new Band(testBandComposition);

        assertFalse(testBand.full());
        assertTrue(testBand.add(john, typicalLeader));
        assertTrue(testBand.full());
    }

    @Test
    public void remove() {

        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 2);

        testBand = new Band(testBandComposition);

        assertTrue(testBand.add(john, guitarist));              // should add
        assertTrue(testBand.add(lola, guitarist));              // should add
        assertTrue(testBand.full());                            // should be full
        assertFalse(testBand.remove(mike));                     // not remove since wasn't there
        assertFalse(testBand.remove(null));                     // reaction on null
        assertTrue(testBand.remove(john));                      // should remove
        assertFalse(testBand.full());                           // shouldn't be full
        assertTrue(testBand.add(john, guitarist));              // should add if previous made correct maintenance
        assertTrue(testBand.full());                            // should be full again

        Map<BandMember, Set<Talent>> expected = new HashMap<>();
        Set<Talent> listWithAcoustic = new HashSet<>();
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
