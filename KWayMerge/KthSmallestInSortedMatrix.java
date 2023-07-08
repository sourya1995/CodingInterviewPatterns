package KWayMerge;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rowCount = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < rowCount; i++){
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        int numbersChecked = 0;
        int smallestElement = 0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            smallestElement = curr[0];
            int rowIndex = curr[1];
            int colIndex = curr[2];
            numbersChecked++;
            if(numbersChecked == k){
                break;
            }

            if(colIndex + 1 < matrix[rowIndex].length){
                minHeap.offer(new int[]{matrix[rowIndex][colIndex + 1], rowIndex, colIndex + 1});
            }
        }

        return smallestElement;
    }
}
