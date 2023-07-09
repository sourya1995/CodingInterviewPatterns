package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NQueens {
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        List<Integer> solution = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> solStack = new Stack<>();
        int row = 0;
        int col = 0;
        while (row < n) {
            while (col < n) {
                if (isValidMove(row, col, solution)) {
                    solStack.push(col);
                    solution.set(row, col);
                    row++;
                    col = 0;
                    break;
                }
                col++;
            }
            if (col == n) {
                if (!solStack.empty()) {
                    col = solStack.peek() + 1;
                    solStack.pop();
                    row--;
                } else {
                    break;
                }
            }
            if (row == n) {
                results.add(generateBoard(solution));
                row--;
                col = solStack.peek() + 1;
                solStack.pop();
            }
        }
        return results;
    }

    static boolean isValidMove(int proposedRow, int proposedCol, List<Integer> solution) {
        for (int i = 0; i < proposedRow; ++i) {
            int oldRow = i;
            int oldCol = solution.get(i);
            int diagonalOffset = proposedRow - oldRow;
            if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset
                    || oldCol == proposedCol + diagonalOffset) {
                return false;
            }
        }
        return true;
    }

    static List<String> generateBoard(List<Integer> solution) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < solution.size(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < solution.size(); j++) {
                if (j == solution.get(i)) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            board.add(row.toString());
        }
        return board;
    }
}
