package fact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactPairs {
    private Map<String, Object> keyToValue = new HashMap<>();

    public FactPairs(List<FactPair> pairs) {
        for (FactPair kv : pairs) {
            keyToValue.put(kv.getKey(), kv.getValue());
        }
    }

    public FactPairs add(String key, Object value) {
        keyToValue.put(key, value);
        return this;
    }

    public Object value(String key) {
        return keyToValue.get(key);
    }
}
