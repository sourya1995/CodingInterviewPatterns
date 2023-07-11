package Graphs;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

public class CloneGraph {
    /*
     * // Definition for a Node.
     * class Node {
     * public int val;
     * public List<Node> neighbors;
     * public Node() {
     * val = 0;
     * neighbors = new ArrayList<Node>();
     * }
     * public Node(int _val) {
     * val = _val;
     * neighbors = new ArrayList<Node>();
     * }
     * public Node(int _val, ArrayList<Node> _neighbors) {
     * val = _val;
     * neighbors = _neighbors;
     * }
     * }
     */

    class Solution {
        private Map<Node, Node> visited;

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            visited = new HashMap<>();
            return cloneNode(node);
        }

        private Node cloneNode(Node node) {
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            Node clonedNode = new Node(node.val);
            visited.put(node, clonedNode);

            for (Node neighbor : node.neighbors) {
                clonedNode.neighbors.add(cloneNode(neighbor));
            }

            return clonedNode;
        }
    }
}
