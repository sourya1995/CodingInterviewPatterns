package TreeDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges){
        if(n <= 1) return n;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited.add(i)){
                dfs(i, map, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited){
        for(int j : map.get(i)){
            if(visited.add(j)){
                dfs(j, map, visited);
            }
        }
    }
}
