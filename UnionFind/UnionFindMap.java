import java.util.HashMap;
import java.util.Map;

public class UnionFindMap {
    private Map<Integer, Integer> parents;
    private Map<Integer, Integer> ranks;

    public UnionFindMap() {
        parents = new HashMap<>();
        ranks = new HashMap<>();
    }

    // Function to find which group a particular element belongs to.
    public int find(int coordinate) {
        if (coordinate != parents.get(coordinate)) {
            parents.put(coordinate, find(parents.get(coordinate)));
        }
        return parents.get(coordinate);
    }

    // Function to join two coordinates into a single one.
    public void union(int x, int y) {
        // Set the parent of each coordinate to itself
        // if not already present in the map
        parents.putIfAbsent(x, x);
        parents.putIfAbsent(y, y);

        // Set the ranks of each coordinate to 0
        // if not already present in the map
        ranks.putIfAbsent(x, 0);
        ranks.putIfAbsent(y, 0);

        // Compare the ranks of the two coordinates
        // to decide which should be the parent
        if (ranks.get(x) > ranks.get(y)) {
            parents.put(find(y), find(x));
        } else if (ranks.get(y) > ranks.get(x)) {
            parents.put(find(x), find(y));
        } else {
            // If the ranks are equal, choose one coordinate
            // as the parent and increment its rank
            parents.put(find(x), find(y));
            ranks.put(y, ranks.get(y) + 1);
        }
    }

    // Getter function to access the parents member
    public Map<Integer, Integer> getParents() {
        return parents;
    }
}
