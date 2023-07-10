import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjacency = new HashMap<>(); //construct adjacency dictionary
        for(int[] time : times){
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            adjacency.computeIfAbsent(source, key -> new ArrayList<>()).add(new int[]{destination, travelTime});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int delays = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            if(visited.contains(node))
                continue;

            visited.add(node);
            delays = Math.max(delays, time);
            List<int[]> neighbors = adjacency.getOrDefault(node, new ArrayList<>());

            for(int[] neighbor: neighbors){
                int neighborNode = neighbor[0];
                int neighborTime = neighbor[1];
                if(!visited.contains(neighborNode)) {
                    int newTime = time + neighborTime;
                    pq.offer(new int[]{newTime, neighborNode});
                }
            }
        }

        if(visited.size() == n)
            return delays;

        return -1;
    }
}