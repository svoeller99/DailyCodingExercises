package problem173;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Write a function to flatten a nested dictionary. Namespace the keys with a period.
 *
 * For example, given the following dictionary:
 *
 * {
 *     "key": 3,
 *     "foo": {
 *         "a": 5,
 *         "bar": {
 *             "baz": 8
 *         }
 *     }
 * }
 * it should become:
 *
 * {
 *     "key": 3,
 *     "foo.a": 5,
 *     "foo.bar.baz": 8
 * }
 * You can assume keys do not contain dots in them, i.e. no clobbering will occur.
 */
class MapFlattenerTest {
    @Test
    public void testFlattenMap() {
        Map<String, Object> input = new HashMap<>();
        input.put("key", 3);
        HashMap<Object, Object> fooMap = new HashMap<>();
        input.put("foo", fooMap);
        fooMap.put("a", 5);
        HashMap<Object, Object> barMap = new HashMap<>();
        fooMap.put("bar", barMap);
        barMap.put("baz", 8);

        Map<String, Object> expected = new HashMap<>();
        expected.put("key", 3);
        expected.put("foo.a", 5);
        expected.put("foo.bar.baz", 8);

        Map<String, Object> result = new MapFlattener().flattenMap(input);

        Assertions.assertEquals(expected, result);
    }
}