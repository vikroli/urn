package com.emnify.ipurn.comperator;

import java.util.Comparator;

public class ComparableComparator<T extends Comparable<T>> implements Comparator<T> {
    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}
