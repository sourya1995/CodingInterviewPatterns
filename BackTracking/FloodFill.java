package BackTracking;

public class FloodFill {
     public static void dfs(int[][] grid, int row, int col, int oldTarget, int newTarget){
        int[][] adjacentCells = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
        int gridLength = grid.length;
        int totalCells = grid[0].length;

        for(int[] cellValue: adjacentCells){
            int i = row + cellValue[0];
            int j = col + cellValue[1];

            if(i < gridLength && i >= 0 && j < totalCells && j >= 0 && grid[i][j] == oldTarget){
                grid[i][j] = newTarget;
                dfs(grid, i, j, oldTarget, newTarget);
            }

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        else{
            int oldTarget = image[sr][sc];
            image[sr][sc] = color;
            dfs(image, sr, sc, oldTarget, color);
            return image;
        }
    }
}
