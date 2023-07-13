

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedList;

class Pair {
	public int first;
	public int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

class KeyValuePairLL extends LinkedList<Pair>{}

public class LRUCache {
    int cacheCapacity;

    HashMap<Integer, LinkedListNode<Pair>> cacheMap = new HashMap<Integer, LinkedListNode<Pair>>();
    KeyValuePairLL cacheList = new KeyValuePairLL(); //

    public LRUCache(int size){
        this.cacheCapacity = size;
    }

    int get(int key){
        LinkedListNode<Pair> foundIter;
        if(cacheMap.containsKey(key))
            foundIter = cacheMap.get(key);

        else
            return -1;

        LinkedListNode<Pair> listIterator = foundIter;
        cacheList.remove(foundIter);
        cacheList.addFirst(listIterator);

        return listIterator.data.second;
    }

    void set(int key, int value) {
        if(cacheMap.containsKey(key)){
            LinkedListNode<Pair> foundIter = cacheMap.get(key);
            LinkedListNode<Pair> listIterator = foundIter;

            cacheList.remove(foundIter);
            cacheList.addFirst(listIterator);

            listIterator.data.second = value;
            return;


        }

        if(cacheMap.size() == cacheCapacity){
            int keyTmp = cacheList.getLast().data.first;
            cacheList.removeLast();
            cacheMap.remove(keyTmp);
        }

        cacheList.insertAtHead(new Pair(key, value));
        if(cacheMap.containsKey(key)){
            cacheMap.replace(key, cacheList.getFirst());
        } else {
            cacheMap.put(key, cacheList.getFirst());
        }
    }
}
