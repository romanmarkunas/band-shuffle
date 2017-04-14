package com.romanmarkunas.bandshuffle;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BandMemberTest {

    private BandMember john;
    private BandMember linn;


    @Before
    public void setUp() {

        john = new BandMember(1,"John", "Doe", "vinniepooh1995@hotmail.com");
        linn = new BandMember(8,"Linn", "Vue", "linn.vue@gmail.com");
    }


    @Test
    public void getId() throws Exception {

        assertEquals(1, john.getId());
        assertEquals(8, linn.getId());
    }
    @Test
    public void getFullName() throws Exception {

        assertEquals("John Doe", john.getFullName());
        assertEquals("Linn Vue", linn.getFullName());
    }
    @Test
    public void getEmail() throws Exception {

        assertEquals("vinniepooh1995@hotmail.com", john.getEmail());
        assertEquals("linn.vue@gmail.com", linn.getEmail());
    }

    @Test
    public void testToString() {

        assertEquals("John Doe", john.toString());
        assertEquals("Linn Vue", linn.toString());
    }

    @Test
    public void testTalentAdditionsAndRemovals() {

        Set<Talent> typicalLeader = new HashSet<>();
        typicalLeader.add(Talent.LEAD);
        typicalLeader.add(Talent.VOICE);
        typicalLeader.add(Talent.ACOUSTIC_GUITAR);

        Set<Talent> pianoSinger = new HashSet<>();
        pianoSinger.add(Talent.KEYBOARD);
        pianoSinger.add(Talent.VOICE);

        Set<Talent> pureDrummer = new HashSet<>();
        pureDrummer.add(Talent.DRUMS);

        Set<Set<Talent>> johnTalents = new HashSet<>();
        johnTalents.add(typicalLeader);

        Set<Set<Talent>> linnTalents = new HashSet<>();
        linnTalents.add(pianoSinger);
        linnTalents.add(pureDrummer);

        john.addSimultaneouslyUsable(typicalLeader);
        john.addSimultaneouslyUsable(null);    // do not add null
        john.addSimultaneouslyUsable(new HashSet<>());  // do not add empty set
        linn.addSimultaneouslyUsable(pianoSinger);
        linn.addSimultaneouslyUsable(pureDrummer);

        assertEquals(johnTalents, john.getTalentCombos());
        assertEquals(linnTalents, linn.getTalentCombos());

        linn.removeTalent(Talent.VOICE);
        linnTalents.remove(pianoSinger);
        linnTalents.remove(typicalLeader);              // not existent
        linnTalents.remove(null);

        assertEquals(johnTalents, john.getTalentCombos());
        assertEquals(linnTalents, linn.getTalentCombos());
    }
}