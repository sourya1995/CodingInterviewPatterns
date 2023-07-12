public class RedundantConnections {

    public static int[] redundantConnection(int[][] edges) {

        UnionFind connections = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (!connections.union(v1, v2)) {
                return edge;
            }
        }
        return new int[] {};
    }
}
