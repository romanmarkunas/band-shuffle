package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BandMemberTest {

    private BandMember john;
    private BandMember linn;


    @Before
    public void setUp() {

        john = new BandMember("John", "Doe", Instrument.ACOUSTIC_GUITAR);
        linn = new BandMember("Linn", "Vue", Instrument.VOICE);
    }


    @Test
    public void getFullName() throws Exception {

        assertEquals("John Doe", john.getFullName());
        assertEquals("Linn Vue", linn.getFullName());
    }

    @Test
    public void testToString() {

        assertEquals("John Doe", john.toString());
        assertEquals("Linn Vue", linn.toString());
    }

    @Test
    public void getInstrument() {

        assertEquals(Instrument.ACOUSTIC_GUITAR, john.getInstrument());
        assertEquals(Instrument.VOICE, linn.getInstrument());
    }
}