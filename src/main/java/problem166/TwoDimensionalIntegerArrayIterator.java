package problem166;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDimensionalIntegerArrayIterator implements Iterator<Integer> {
    private final int[][] outerArray;
    private int x = 0;
    private int y = 0;
    private Integer next = null;

    public TwoDimensionalIntegerArrayIterator(int[][] input) {
        this.outerArray = input;
    }

    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }
        next = findNext();
        return next != null;
    }

    @Override
    public Integer next() {
        if (next != null) {
            int tmp = next;
            next = null;
            return tmp;
        }
        Integer theNext = findNext();
        if (theNext == null) {
            throw new NoSuchElementException("No next element");
        }
        return theNext;
    }

    private Integer findNext() {
        int[] innerArray;

        do {
            if (x >= outerArray.length) {
                return null;
            }
            innerArray = outerArray[x];
            if (y >= innerArray.length) {
                y = 0;
                x++;
            } else {
                break;
            }
        } while (true);

        return innerArray[y++];
    }
}
