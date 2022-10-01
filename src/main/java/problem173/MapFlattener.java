package problem173;

import java.util.HashMap;
import java.util.Map;

public class MapFlattener {
    public Map<String, Object> flattenMap(Map<String, Object> mapToFlatten) {
        Map<String, Object> result = new HashMap<>();
        flattenMap("", mapToFlatten, result);
        return result;
    }

    private void flattenMap(String keyPrefix, Map<String, Object> input, Map<String, Object> output) {
        input.entrySet().forEach(entry -> {
            String key = buildCompositeKey(keyPrefix, entry.getKey());
            Object value = entry.getValue();
            if (value instanceof Map) {
                flattenMap(key, (Map<String, Object>) value, output);
            } else {
                output.put(key, value);
            }
        });
    }

    private String buildCompositeKey(String keyOne, String keyTwo) {
        if (keyOne.isEmpty()) {
            return keyTwo;
        }
        return String.format("%s.%s", keyOne, keyTwo);
    }
}
