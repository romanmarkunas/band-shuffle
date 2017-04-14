package com.romanmarkunas.bandshuffle;

import com.romanmarkunas.bandshuffle.domain.Band;
import com.romanmarkunas.bandshuffle.domain.BandMember;
import com.romanmarkunas.bandshuffle.domain.Talent;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShufflerTest {

    private List<BandMember> bandMembers;

    private BandMember john;
    private BandMember lola;
    private BandMember mike;
    private BandMember linn;
    private BandMember bill;


    @Before
    public void setUp() {

        // John
        Set<Talent> typicalLeader = new HashSet<>();
        typicalLeader.add(Talent.LEAD);
        typicalLeader.add(Talent.VOICE);
        typicalLeader.add(Talent.ACOUSTIC_GUITAR);
        Set<Set<Talent>> johnTalents = new HashSet<>();
        johnTalents.add(typicalLeader);

        john = mock(BandMember.class);
        when(john.getTalentCombos()).thenReturn(johnTalents);
        when(john.toString()).thenReturn("John Doe");

        // Lola
        Set<Talent> singer = new HashSet<>();
        singer.add(Talent.VOICE);
        Set<Set<Talent>> lolaTalents = new HashSet<>();
        lolaTalents.add(singer);

        lola = mock(BandMember.class);
        when(lola.getTalentCombos()).thenReturn(lolaTalents);
        when(lola.toString()).thenReturn("Lola Mei");

        // Mike
        Set<Set<Talent>> mikeTalents = new HashSet<>();
        mikeTalents.add(singer);

        mike = mock(BandMember.class);
        when(mike.getTalentCombos()).thenReturn(mikeTalents);
        when(mike.toString()).thenReturn("Mike Cho");

        // Linn
        Set<Talent> guitarist = new HashSet<>();
        guitarist.add(Talent.ACOUSTIC_GUITAR);
        Set<Set<Talent>> linnTalents = new HashSet<>();
        linnTalents.add(guitarist);

        linn = mock(BandMember.class);
        when(linn.getTalentCombos()).thenReturn(linnTalents);
        when(linn.toString()).thenReturn("Linn Vue");

        // Bill
        Set<Talent> singingGuitarist = new HashSet<>();
        singingGuitarist.add(Talent.ACOUSTIC_GUITAR);
        singingGuitarist.add(Talent.VOICE);
        Set<Set<Talent>> billTalents = new HashSet<>();
        billTalents.add(singingGuitarist);

        bill = mock(BandMember.class);
        when(bill.getTalentCombos()).thenReturn(billTalents);
        when(bill.toString()).thenReturn("Bill Elk");

        // band member list
        bandMembers = new ArrayList<>();
        bandMembers.add(john);
        bandMembers.add(lola);
        bandMembers.add(mike);
        bandMembers.add(linn);
        bandMembers.add(bill);
    }

    @Test
    public void shuffle() {

        Shuffler testShuffler = new Shuffler();

        Map<Talent, Integer> testBandComposition = new HashMap<>();
        testBandComposition.put(Talent.ACOUSTIC_GUITAR, 1);
        testBandComposition.put(Talent.LEAD, 1);
        testBandComposition.put(Talent.VOICE, 2);

        System.out.println(testShuffler.shuffle(10, new Band(testBandComposition), bandMembers));
    }
}
