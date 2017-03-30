package com.romanmarkunas.bandshuffle;

import org.junit.Test;

import static org.junit.Assert.*;

public class BandMemberTest {

    @Test
    public void getFullName() throws Exception {

        BandMember testBM = new BandMember("John", "Doe");

        assertEquals("John Doe", testBM.getFullName());
    }

}