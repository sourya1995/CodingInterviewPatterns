public class NumberIslands {
    if(grid.length == 0)
            return 0;

        int cols = grid[0].length;
        int rows = grid.length;

        UnionFind unionFind = new UnionFind(grid);

        for(int r =0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    grid[r][c] = '0';

                    if(r - 1 >= 0 && grid[r-1][c] == '1')
                        unionFind.union(r*cols + c, (r-1) * cols + c);
                    if(r + 1 < rows && grid[r+1][c] == '1')
                        unionFind.union(r* cols + c, (r+1)*cols + c);
                    if(c - 1 >= 0 && grid[r][c-1] == '1')
                        unionFind.union(r * cols + c, r * cols + c - 1);
                    if(c + 1 < cols && grid[r][c+1] == '1')
                        unionFind.union(r * cols + c, r * cols + c + 1);
                }
            }
        }

        int count = unionFind.getCount();
        return count;

}
