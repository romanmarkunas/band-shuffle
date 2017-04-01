package com.romanmarkunas.bandshuffle;

import org.junit.Test;

import static org.junit.Assert.*;

public class BandMemberTest {

    private BandMember testBM;


    @Test
    public void getFullName() throws Exception {

        testBM = new BandMember("John", "Doe");

        assertEquals("John Doe", testBM.getFullName());
    }

    @Test
    public void testToString() {

        testBM = new BandMember("John", "Doe");
        System.out.println(testBM);
    }
}