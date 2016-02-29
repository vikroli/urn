package com.emnify.ipurn;

import java.util.*;

public abstract class Urn<T> {
    private T min, max;
    private ArrayList<T> elements;

    public Urn(Comparator<? super T> comparator, ArrayList<T> elements, T min, T max) {
        this.elements = elements;
        this.min = min;
        this.max = max;
        Collections.sort(elements, comparator);
    }

    protected abstract int diff(T a, T b);

    protected abstract T create(T t, int offset);

    private boolean exhausted(int start, int end) {
        return diff(elements.get(end), elements.get(start)) <= (end - start);
    }

    public T nextFree() throws UrnExhaustedException {
        int start = 0;
        int end = elements.size() - 1;

        if (diff(min, elements.get(0)) != 0) {
            return create(min, 0);
        } else {
            while (!exhausted(start, end)) {
                int center = start + (end - start) / 2;
                if (end - start == 1) {
                    return create(elements.get(start), 1);
                } else if (exhausted(start, center)) {
                    start = center;
                } else {
                    end = center;
                }
            }
            if (elements.get(elements.size() - 1).equals(max)) {
                throw new UrnExhaustedException();
            } else {
                return create(elements.get(elements.size() - 1), 1);
            }
        }
    }
}
