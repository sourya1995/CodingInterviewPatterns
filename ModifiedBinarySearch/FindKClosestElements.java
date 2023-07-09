package ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
     public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if(diffA == diffB){
                return b-a;
            }
            return diffB - diffA;
        });

        for (int num: arr){
            maxHeap.offer(num);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(maxHeap);
        Collections.sort(result);

        return result;
    }
}
