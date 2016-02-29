package com.emnify.ipurn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Examples {
    public static void main(String[] args) throws UrnExhaustedException {
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 8, 9, 10)), 1, 5).nextFree());
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 6)), 1, 5).nextFree());
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 6)), 1, 5).nextFree());
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5)), 1, 5).nextFree());
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5)), 1, 5).nextFree());
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5)), 1, 5).nextFree());
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(2, 4, 5)), 1, 5).nextFree());
        System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 1, 6).nextFree());
        try {
            System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 1, 5).nextFree());
            throw new RuntimeException();
        } catch (UrnExhaustedException e) {
            System.err.println("UrnExhaustedException");
        }

        int elements = 100000000;
        System.err.println("Creating " + elements + " elements...");
        long start = System.currentTimeMillis();
        ArrayList<Integer> l = new ArrayList<Integer>(elements);
        for (int i = 0; i < elements; i++)
            l.add(i);
        int random = new Random().nextInt(elements - 1);
        System.err.println(random);
        l.remove(random);
        System.err.println("List creation took " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        IntUrn urn = new IntUrn(l, 0, elements);
        System.err.println("Urn creation took " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.err.println(urn.nextFree());
        System.err.println("urn.nextFree() took " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) - l.get(i - 1) > 1) {
                System.err.println(l.get(i - 1) + 1);
                break;
            }
        }
        System.err.println("sequential search took " + (System.currentTimeMillis() - start) + "ms");
    }
}
