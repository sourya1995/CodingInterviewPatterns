package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyHashMap {

    class Bucket{
        List<List<Integer>> bucket;

        public Bucket() {
            bucket = new ArrayList<>();
        }

        public void update(int key, int value){
            boolean found = false;
            for(int i = 0; i < bucket.size(); i++){
                if(key == bucket.get(i).get(0)){
                    this.bucket.get(i).set(1, value);
                    found = true;
                    break;
                }
            }

            if(!found){
                this.bucket.add(Arrays.asList(key, value));
            }
        }

        public int get(int key){
            for(int i=0; i < bucket.size(); i++){
                if(bucket.get(i).get(0) == key){
                    return bucket.get(i).get(1);
                }
            }
            return -1;
        }

        public void remove(int key){
            for(int i = 0; i < bucket.size(); i++){
                if(bucket.get(i).get(0) == key){
                    bucket.remove(i);
                    break;
                }
            }
        }
    }

    public int keySpace;
    public List<Bucket> hashMap;

    public MyHashMap() {
        this.keySpace = 2069;
        this.hashMap = new ArrayList<Bucket>(Collections.nCopies(keySpace, new Bucket()));
    }
    
    public void put(int key, int value) {
        int hashKey = key % this.keySpace;
        this.hashMap.get(hashKey).update(key, value);
    }
    
    public int get(int key) {
        int hashKey = key % this.keySpace;
        return this.hashMap.get(hashKey).get(key);
    }
    
    public void remove(int key) {
        int hashKey = key % this.keySpace;
        this.hashMap.get(hashKey).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
