package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompilationOrder {
    public static String repeat(String str, int pValue) {
        String out = "";
        for (int i = 0; i < pValue; i++) {
            out += str;
        }
        return out;
    }

    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> sortedOrder = new ArrayList<>();
        HashMap<String, List<Character>> graph = new HashMap<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        for (int x = 0; x < dependencies.size(); x++) {
            char parent = dependencies.get(x).get(0);
            char child = dependencies.get(x).get(1);
            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());
            inDegree.put(parent, 0);
            inDegree.put(child, 0);
        }

        if (graph.size() <= 0) {
            return sortedOrder;
        }

        for (int dependency = 0; dependency < dependencies.size(); dependency++) {
            char parent = dependencies.get(dependency).get(1);
            char child = dependencies.get(dependency).get(0);
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Character> sources = new LinkedList<>();
        for (char key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                sources.add(key);
            }
        }

        while (!sources.isEmpty()) {
            char vertex = sources.poll();
            sortedOrder.add(vertex);
            for (int child = 0; child < graph.get(vertex).size(); child++) {
                inDegree.put(graph.get(vertex).get(child), inDegree.get(graph.get(vertex).get(child)) - 1);
                if (inDegree.get(graph.get(vertex).get(child)) == 0) {
                    sources.add(graph.get(vertex).get(child));
                }
            }
        }

        if (sortedOrder.size() != graph.size()) {
            return new ArrayList<>();
        }
        return sortedOrder;
    }
}
