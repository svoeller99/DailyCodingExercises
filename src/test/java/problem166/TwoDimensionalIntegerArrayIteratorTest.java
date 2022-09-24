package problem166;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Implement a 2D iterator class. It will be initialized with an array of arrays, and should implement the following methods:
 *
 * next(): returns the next element in the array of arrays. If there are no more elements, raise an exception.
 * has_next(): returns whether or not the iterator still has elements left.
 * For example, given the input [[1, 2], [3], [], [4, 5, 6]], calling next() repeatedly should output 1, 2, 3, 4, 5, 6.
 *
 * Do not use flatten or otherwise clone the arrays. Some of the arrays can be empty.
 */
class TwoDimensionalIntegerArrayIteratorTest {
    @Test
    public void testTwoDimIterator() {
        int[][] input = new int[][]{
                {1, 2},
                {3},
                {},
                {4, 5, 6}
        };

        Iterator<Integer> iterator = new TwoDimensionalIntegerArrayIterator(input);

        List<Integer> iterationResult = new ArrayList<>();
        while(iterator.hasNext()) {
            iterationResult.add(iterator.next());
        }

        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertEquals(expectedResult, iterationResult);
    }

    @Test
    public void testTwoDimIteratorThrowsIfNextIsCalledWithNoRemainingElems() {
        Assertions.assertThrows(
            NoSuchElementException.class,
            () -> {
                Iterator<Integer> iterator = new TwoDimensionalIntegerArrayIterator(new int[][]{});
                iterator.next();
            }
        );
    }
}