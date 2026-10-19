import java.util.*;

class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        return map.get(key);
    }

    public void put(int key, int value) {

        map.put(key, value);

        if (map.size() > capacity) {
            int lru = map.keySet().iterator().next();
            map.remove(lru);
        }
    }
}
