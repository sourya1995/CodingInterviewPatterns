package Matrices;

import java.util.*;

public class PacificAtlanticWaterFlow {

    class Solution {
        private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> result = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return result;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            boolean[][] pacificReachable = new boolean[m][n];
            boolean[][] atlanticReachable = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                dfs(matrix, pacificReachable, i, 0);
                dfs(matrix, atlanticReachable, i, n - 1);
            }

            for (int j = 0; j < n; j++) {
                dfs(matrix, pacificReachable, 0, j);
                dfs(matrix, atlanticReachable, m - 1, j);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }

            return result;
        }

        private void dfs(int[][] matrix, boolean[][] reachable, int row, int col) {
            int m = matrix.length;
            int n = matrix[0].length;

            reachable[row][col] = true;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && !reachable[newRow][newCol] && matrix[newRow][newCol] >= matrix[row][col]) {
                    dfs(matrix, reachable, newRow, newCol);
                }
            }
        }
    }

}
