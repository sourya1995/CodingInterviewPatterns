package DynamicProgramming;

public class ZeroOneMatrix {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] > 0) {
                        int up = (i > 0) ? mat[i - 1][j] : Integer.MAX_VALUE - 10000;
                        int left = (j > 0) ? mat[i][j - 1] : Integer.MAX_VALUE - 10000;
                        mat[i][j] = Math.min(up, left) + 1;
                    }
                }
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[i][j] > 0) {
                        int down = (i < m - 1) ? mat[i + 1][j] : Integer.MAX_VALUE - 10000;
                        int right = (j < n - 1) ? mat[i][j + 1] : Integer.MAX_VALUE - 10000;

                        mat[i][j] = Math.min(mat[i][j], Math.min(down + 1, right + 1));
                    }
                }
            }
            return mat;
        }
    }

}
