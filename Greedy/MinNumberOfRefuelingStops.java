package Greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel > target) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;

        while (maxDistance < target) {
            if (i < n && stations[i][0] <= maxDistance) {
                maxHeap.add(stations[i][1]);
                i++;
            }

            else if (maxHeap.isEmpty()) {
                return -1;
            }

            else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }

        return stops;
    }
}
