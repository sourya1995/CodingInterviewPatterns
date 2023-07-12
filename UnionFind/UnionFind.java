import java.util.*;

public class UnionFind {
    private List<Integer> parent;
    private List<Integer> rank;
    private int count;

    public UnionFind(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        this.parent = new ArrayList<>();
        this.rank = new ArrayList<>();
        this.count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    parent.add(r * cols + c);
                    this.count++;
                } else {
                    this.parent.add(-1);
                }
                this.rank.add(1);
            }
        }
    }

    public List<Integer> getParent() {
        return this.parent;
    }

    public int getCount() {
        return this.count;
    }

    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 != p2) {
            if (this.rank.get(p1) > this.rank.get(p2)) {
                this.parent.set(p2, p1);
            } else if (this.rank.get(p1) < this.rank.get(p2)) {
                this.parent.set(p1, p2);
            } else {
                this.parent.set(p2, p1);
                this.rank.set(p1, this.rank.get(p1) + 1);
            }
            count--;
        }
    }

    public int find(int v) {
        if (this.parent.get(v) != v) {
            this.parent.set(v, this.find(this.parent.get(v)));
        }
        return this.parent.get(v);
    }
}
