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
        // our current X position is outside the bounds of the outer array, return null indicating that there is no next
        // element
        if (x >= outerArray.length) {
            return null;
        }

        // fetch inner array at current X position and advance X position by one.
        int[] innerArray = outerArray[x];

        // advance to the next inner array if the current one is empty
        while (y >= innerArray.length) {
            if (++x >= outerArray.length) {
                return null;
            }
            innerArray = outerArray[x];
            y = 0;
        }

        return innerArray[y++];
    }
}
