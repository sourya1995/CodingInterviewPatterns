package TopKElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            topKElements.add(entry);
            if (topKElements.size() > k) {
                topKElements.poll();
            }
        }

        int[] topNumbers = new int[k];
        int index = 0;
        while (!topKElements.isEmpty()) {
            topNumbers[index++] = topKElements.poll().getKey();

        }
        Arrays.sort(topNumbers);
        return topNumbers;

    }
}
