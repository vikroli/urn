package com.emnify.ipurn.comperator;

import java.math.BigInteger;
import java.net.InetAddress;
import java.util.Comparator;

public class InetAddressComparator implements Comparator<InetAddress> {
    public int compare(InetAddress a, InetAddress b) {
        BigInteger ai = new BigInteger(1, a.getAddress());
        BigInteger bi = new BigInteger(1, b.getAddress());
        return ai.compareTo(bi);
    }
}
