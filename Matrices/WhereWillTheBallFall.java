package Matrices;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];

        for(int i=0; i < result.length; i++){
            result[i] = -1;

        }

        for(int col=0; col < grid[0].length; col++){
            int currentColumn = col;

            for(int row = 0; row < grid.length; row++){
                int nextColumn = currentColumn + grid[row][currentColumn];

                if(nextColumn < 0 || nextColumn > grid[0].length - 1 || grid[row][currentColumn] != grid[row][nextColumn]){
                    break;
                }

                if(row == grid.length - 1){
                    result[col] = nextColumn;
                }

                currentColumn = nextColumn;
            }
        }

        return result;
    }
}
