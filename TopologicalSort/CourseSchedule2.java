package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (numCourses <= 0)
            return new int[0];

        // hashmap for incoming prerequisites
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        // initialise the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1], child = prerequisites[i][0];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // find all sources - only outgoing edges
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // For each source, add it to the sortedOrder and subtract one from all of its
        // children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue

        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        if (sortedOrder.size() != numCourses)
            return new int[0];

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = sortedOrder.get(i);
        }

        return result;
    }
}
