package KWayMerge;

import java.util.List;
import java.util.PriorityQueue;

public class KSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        int listLength = lists.size();
        PriorityQueue<int[]> kthSmallest = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int index = 0; index < listLength; index++) {
            if(lists.get(index).size() == 0){
                continue;
            }else {
                kthSmallest.offer(new int[]{lists.get(index).get(0), index, 0});
            }
        }
        int numbersChecked = 0, smallestNumber = 0;
        while(!kthSmallest.isEmpty()){
            int[] smallest = kthSmallest.poll();
            smallestNumber = smallest[0];
            int listIndex = smallest[1];
            int numIndex = smallest[2];
            numbersChecked++;

            if(numbersChecked == k){
                break;
            }

            if(numIndex + 1 < lists.get(smallest[1]).size()){
                kthSmallest.offer(new int[]{lists.get(listIndex).get(numIndex + 1), listIndex, numIndex + 1});
            }
        }
        return smallestNumber;
    }
}
