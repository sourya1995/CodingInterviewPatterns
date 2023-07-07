package MergeIntervals;

import java.util.List;
import java.util.Map;

public class TaskScheduler {

    public static int leastTime(char[] tasks, int n){
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char task : tasks) {
            frequencies.put(task, frequencies.getOrDefault(task, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(frequencies.entrySet());
        Collections.sort(sortedFrequencies, (lhs, rhs) -> lhs.getValue().compareTo(rhs.getValue()));

        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
        sortedFrequencies.remove(sortedFrequencies.size() - 1);

        int idleTime = (maxFreq - 1) * n

        while(!sortedFrequencies.isEmpty() && idleTime > 0) {
            idleTime -= Math.min(maxFreq - 1, sortedFrequencies.get(sortedFrequencies.size() - 1).getValue());
            sortedFrequencies.remove(sortedFrequencies.size() - 1);
        }

        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }


}
