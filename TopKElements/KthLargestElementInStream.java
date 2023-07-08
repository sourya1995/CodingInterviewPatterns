import java.util.PriorityQueue;

public class KthLargestElementInStream{
    public int k;
    public PriorityQueue<Integer> heap;

    public KthLargestElementInStream(int k, int[] nums){
        this.k = k;
        heap = new PriorityQueue<Integer>();
        for(int num : nums){
            heap.offer(num);
        }

        while(heap.size() > k){
            heap.poll();
        }
    }

    public int add(int val){
        heap.offer(val);
        if(heap.size() > k){
            heap.poll();
        }

        return this.heap.peek();
    }

    public int returnKthLargest(){
        return this.heap.peek();
    }
}