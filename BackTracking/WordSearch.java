package BackTracking;

public class WordSearch {
     public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(depthFirstSearch(row, col, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean depthFirstSearch(int row, int col, String word, char[][] board){
        if(word.length() == 0)
            return true;

        if(row < 0 || row == board.length || col < 0 || col == board[0].length || (board[row][col] != word.charAt(0))){
            return false;
        }

        boolean result = false;
        board[row][col] = '*';
        int[][] offsets = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] offset: offsets){
            int rowOffset = offset[0];
            int colOffset = offset[1];
            result = depthFirstSearch(row + rowOffset, col + colOffset, word.substring(1), board);

            if(result){
                break;
            }
        }

        board[row][col] = word.charAt(0);
        return result;
    }
}
