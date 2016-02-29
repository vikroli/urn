package com.emnify.ipurn;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Examples {
  public static void mainInt(String[] args) throws UrnExhaustedException {
    System.err.println(
        new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 8, 9, 10)), 1, 5).nextFree());
    System.err
        .println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 6)), 1, 5).nextFree());
    System.err
        .println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 6)), 1, 5).nextFree());
    System.err
        .println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5)), 1, 5).nextFree());
    System.err
        .println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5)), 1, 5).nextFree());
    System.err
        .println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5)), 1, 5).nextFree());
    System.err.println(new IntUrn(new ArrayList<Integer>(Arrays.asList(2, 4, 5)), 1, 5).nextFree());
    System.err
        .println(new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 1, 6).nextFree());
    try {
      System.err.println(
          new IntUrn(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 1, 5).nextFree());
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

  public static void main(String[] args) throws UrnExhaustedException {

    try {
      Inet4Address ia1 = (Inet4Address) (InetAddress.getByName("10.11.0.1"));
    Inet4Address ia2 = (Inet4Address)(InetAddress.getByName("10.11.0.2"));
    Inet4Address ia3 = (Inet4Address)(InetAddress.getByName("10.11.0.3"));
    Inet4Address ia4 = (Inet4Address)(InetAddress.getByName("10.11.0.4"));
    Inet4Address ia5 = (Inet4Address)(InetAddress.getByName("10.11.0.5"));
    Inet4Address ia6 = (Inet4Address)(InetAddress.getByName("10.11.0.6"));
    Inet4Address ia7 = (Inet4Address)(InetAddress.getByName("10.11.0.7"));
    Inet4Address ia8 = (Inet4Address)(InetAddress.getByName("10.11.0.8"));
    Inet4Address ia9 = (Inet4Address)(InetAddress.getByName("10.11.0.9"));
    Inet4Address ia10 = (Inet4Address)(InetAddress.getByName("10.11.0.10"));
    
    System.err.println(new InetAddressUrn<Inet4Address>(
          new ArrayList<Inet4Address>(Arrays.asList(ia1, ia2, ia3, ia8, ia9, ia10)), ia1, ia10)
            .nextFree());
    System.err.println(new InetAddressUrn<Inet4Address>(
          new ArrayList<Inet4Address>(Arrays.asList(ia1, ia2, ia3, ia5, ia6)), ia1, ia6)
              .nextFree());
    System.err.println(new InetAddressUrn<Inet4Address>(
          new ArrayList<Inet4Address>(Arrays.asList(ia1, ia2, ia4, ia5, ia6)), ia1, ia10)
              .nextFree());
    System.err.println(new InetAddressUrn<Inet4Address>(
          new ArrayList<Inet4Address>(Arrays.asList(ia1, ia2, ia3, ia5)), ia1, ia5).nextFree());
    System.err.println(new InetAddressUrn<Inet4Address>(
          new ArrayList<Inet4Address>(Arrays.asList(ia1, ia2, ia4, ia5)), ia1, ia5).nextFree());
    System.err.println(new InetAddressUrn<Inet4Address>(
          new ArrayList<Inet4Address>(Arrays.asList(ia1, ia3, ia4, ia5)), ia1, ia5).nextFree());
    
    try {
        System.err.println(new InetAddressUrn<Inet4Address>(
            new ArrayList<Inet4Address>(Arrays.asList(ia1, ia2, ia3, ia4, ia5)), ia1, ia5)
                .nextFree());
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

    } catch (UnknownHostException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }



  }
}
