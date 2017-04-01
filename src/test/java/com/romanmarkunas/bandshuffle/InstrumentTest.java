package com.romanmarkunas.bandshuffle;

import org.junit.Test;
import static org.junit.Assert.*;

public class InstrumentTest {

    @Test
    public void testToString() {

        assertEquals("Vocals", Instrument.VOICE.toString());
        assertEquals("Keys", Instrument.KEYBOARD.toString());
        assertEquals("Acoustic guitar", Instrument.ACOUSTIC_GUITAR.toString());
        assertEquals("Electric guitar", Instrument.ELECTRIC_GUITAR.toString());
        assertEquals("Base", Instrument.BASE.toString());
        assertEquals("Drums", Instrument.DRUMS.toString());
    }
}
