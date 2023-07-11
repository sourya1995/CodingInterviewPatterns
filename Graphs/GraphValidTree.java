package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges){
        if(edges.length != (n-1)){
            return false;
        }

        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjacency.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            adjacency.get(x).add(y);
            adjacency.get(y).add(x);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        visited.add(0);
        stack.push(0);

        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbor : adjacency.get(node)){
                if(visited.contains(neighbor)){
                    continue;
                }
                visited.add(neighbor);
                stack.push(neighbor);
            }
        }
        return visited.size() == n;
    }
}
