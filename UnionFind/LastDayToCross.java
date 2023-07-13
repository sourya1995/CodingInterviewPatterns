public class LastDayToCross {

    public class UnionFind {
        private int[] reps;

        public UnionFind(int n) {
            reps = new int[n];

            for (int i = 0; i < n; i++) {
                reps[i] = i;
            }
        }

        public int find(int x) {
            if (reps[x] != x) {
                reps[x] = find(reps[x]);
            }
            return reps[x];
        }

        public void union(int v1, int v2) {
            reps[find(v1)] = find(v2);
        }
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int day = 0;
        int[][] matrix = new int[row][col];
        int leftNode = 0;
        int rightNode = row * col + 1;
        int[][] waterDirections = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
                { -1, -1 } };
        int[][] convertedWaterCells = new int[cells.length][2];
        for (int i = 0; i < cells.length; i++) {
            convertedWaterCells[i] = new int[] { cells[i][0] - 1, cells[i][1] - 1 };
        }
        UnionFind uf = new UnionFind(row * col + 2);
        for (int[] cell : convertedWaterCells) {
            int rows = cell[0];
            int column = cell[1];
            matrix[rows][column] = 1;
            for (int[] direction : waterDirections) {
                int newRow = rows + direction[0];
                int newCol = column + direction[1];
                if (withinBounds(newRow, newCol, row, col) && matrix[newRow][newCol] == 1) {
                    uf.union(findIndex(rows, column, col), findIndex(newRow, newCol, col));
                }
            }

            if (column == 0) {
                uf.union(findIndex(rows, column, col), leftNode);
            }

            if (column == col - 1) {
                uf.union(findIndex(rows, column, col), rightNode);
            }

            if (uf.find(leftNode) == uf.find(rightNode)) {
                break;
            }
            day++;
        }

        return day;
    }

    public static int findIndex(int currentRow, int currentCol, int cols) {
        return currentRow * cols + (currentCol + 1);
    }

    public static boolean withinBounds(int row, int col, int rows, int cols) {
        return col >= 0 && col < cols && row >= 0 && row < rows;
    }
}
