package com.romanmarkunas.bandshuffle;

import java.util.ArrayList;
import java.util.List;

class Band {

    private int size;
    private List<BandMember> memberList;


    Band(int size) {

        this.size = size;
        this.memberList = new ArrayList<>();
    }


    boolean add(BandMember newMember) {

        if (this.full() || memberList.contains(newMember)) {
            return false;
        }
        else {
            memberList.add(newMember);
            return true;
        }
    }

    boolean full() {

        return (memberList.size() >= size);
    }

    Band getComposition() {

        return new Band(size);
    }

    int getSize() {

        return size;
    }

    @Override
    public String toString() {

        return "Band{" +
                    memberList +
                '}';
    }
}
