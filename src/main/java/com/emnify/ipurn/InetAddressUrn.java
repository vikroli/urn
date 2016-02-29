package com.emnify.ipurn;

import com.emnify.ipurn.comperator.InetAddressComparator;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class InetAddressUrn<T extends InetAddress> extends Urn<T> {
    public InetAddressUrn(ArrayList<T> elements, T min, T max) {
        super(new InetAddressComparator(), elements, min, max);
    }

    @Override
    protected int diff(T a, T b) {
        BigInteger ai = new BigInteger(1, a.getAddress());
        BigInteger bi = new BigInteger(1, b.getAddress());
        return ai.subtract(bi).abs().intValue();
    }

    @Override
    protected T create(T inet4Address, int offset) {
        BigInteger i = new BigInteger(1, inet4Address.getAddress()).add(BigInteger.valueOf(offset));
        try {
            return (T) InetAddress.getByAddress(i.toByteArray());
        } catch (UnknownHostException e) {
            return null;
        }
    }
}
