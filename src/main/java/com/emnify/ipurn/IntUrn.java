package com.emnify.ipurn;

import com.emnify.ipurn.comperator.ComparableComparator;

import java.util.ArrayList;

public class IntUrn extends Urn<Integer> {
    public IntUrn(ArrayList<Integer> elements, Integer min, Integer max) {
        super(new ComparableComparator<Integer>(), elements, min, max);
    }

    @Override
    protected int diff(Integer a, Integer b) {
        return a - b;
    }

    @Override
    protected Integer create(Integer i, int offset) {
        return i + offset;
    }
}
