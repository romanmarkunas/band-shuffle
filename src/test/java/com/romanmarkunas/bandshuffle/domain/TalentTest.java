package com.romanmarkunas.bandshuffle.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class TalentTest {

    @Test
    public void testToString() {

        assertEquals("Vocals", Talent.VOICE.toString());
        assertEquals("Keys", Talent.KEYBOARD.toString());
        assertEquals("Acoustic guitar", Talent.ACOUSTIC_GUITAR.toString());
        assertEquals("Electric guitar", Talent.ELECTRIC_GUITAR.toString());
        assertEquals("Base", Talent.BASE.toString());
        assertEquals("Drums", Talent.DRUMS.toString());
        assertEquals("Lead", Talent.LEAD.toString());
    }
}
