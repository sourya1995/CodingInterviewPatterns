

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

class KeyValuePair {
    public int key;
    public int value;
    public int frequency;

    public KeyValuePair(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}

class KeyValuePairLL extends LinkedList<KeyValuePair> {}

public class LFUCache {
    int cacheCapacity;
    int minFrequency;
    HashMap<Integer, LinkedListNode<KeyValuePair>> cacheMap = new HashMap<>();
    KeyValuePairLL cacheList = new KeyValuePairLL();
    Map<Integer, LinkedHashSet<Integer>> frequencyToKeys = new HashMap<>();

    public LFUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.minFrequency = 0;
    }

    public int get(int key) {
        LinkedListNode<KeyValuePair> foundIter;
        if (cacheMap.containsKey(key)) {
            foundIter = cacheMap.get(key);

            KeyValuePair entry = foundIter.data;
            int value = entry.value;
            int frequency = entry.frequency;

            entry.frequency = frequency + 1;

            frequencyToKeys.get(frequency).remove(key);
            if (frequency == minFrequency && frequencyToKeys.get(frequency).isEmpty()) {
                minFrequency++;
            }

            frequencyToKeys.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);

            return value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (cacheMap.containsKey(key)) {
            LinkedListNode<KeyValuePair> foundIter = cacheMap.get(key);
            KeyValuePair entry = foundIter.data;

            entry.value = value;

            get(key);
        } else {
            if (cacheMap.size() == cacheCapacity) {
                int evictKey = frequencyToKeys.get(minFrequency).iterator().next();
                frequencyToKeys.get(minFrequency).remove(evictKey);
                cacheMap.remove(evictKey);
            }

            KeyValuePair entry = new KeyValuePair(key, value, 1);
            cacheList.insertAtHead(entry);
            cacheMap.put(key, cacheList.getFirst());

            frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFrequency = 1;
        }
    }
}

