package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                if (!adjacencyList.containsKey(station)) {
                    adjacencyList.put(station, new ArrayList<>());
                }
                adjacencyList.get(station).add(i);
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { source, 0 });
        Set<Integer> visitedBuses = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] current = queue.peek();
            int station = current[0];
            int busesTaken = current[1];
            queue.poll();

            if (station == target) {
                return busesTaken;
            }

            if (adjacencyList.containsKey(station)) {
                for (int bus : adjacencyList.get(station)) {
                    if (!visitedBuses.contains(bus)) {
                        for (int s : routes[bus]) {
                            queue.add(new int[] {
                                    s, busesTaken + 1
                            });
                        }
                        visitedBuses.add(bus);
                    }

                }
            }
        }

        return -1;
    }
}
