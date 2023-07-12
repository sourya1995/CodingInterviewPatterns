package WhatToTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicTacToe {
    List<Integer> rows;
    List<Integer> columns;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n){
        this.rows = new ArrayList<Integer>(Collections.nCopies(n, 0));
        this.columns = new ArrayList<Integer>(Collections.nCopies(n,0));
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int column, int player){
        int currentPlayer = -1;
        if(player == 1){
            currentPlayer = 1;
        }

        int n = rows.size();
        rows.set(row, rows.get(row) + currentPlayer);
        columns.set(column, columns.get(column) + currentPlayer);

        if(row == column){
            diagonal += currentPlayer;
        }

        if(column == (n - row - 1)){
            antiDiagonal += currentPlayer;
        }

        if(Math.abs(rows.get(row)) == n || Math.abs(columns.get(column)) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n){
            return player;
        }

        return 0;


    }
}
