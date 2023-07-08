package TwoHeaps;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinMachinesForTasks {
    public static int tasks(List<List<Integer>> tasksList) {
        int optimalMachines = 0;
        PriorityQueue<int[]> machinesAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> tasksQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (List<Integer> task : tasksList) {
            tasksQueue.offer(new int[] { task.get(0), task.get(1) });
        }

        while (!tasksQueue.isEmpty()) {
            int[] task = tasksQueue.poll();
            int[] machineInUse;
            if (!machinesAvailable.isEmpty() && task[0] >= machinesAvailable.peek()[0]) {
                machineInUse = machinesAvailable.poll();
                machineInUse = new int[] {
                        task[1], machineInUse[1]
                };
            } else {
                optimalMachines += 1;
                machineInUse = new int[] {
                        task[1], optimalMachines
                };
            }
            machinesAvailable.offer(machineInUse);
        }
        return optimalMachines;
    }
}
