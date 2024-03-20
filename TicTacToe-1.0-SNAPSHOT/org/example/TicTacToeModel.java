package org.example;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeModel {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;
    private List<TicTacToeListener> TTTListeners;

    public TicTacToeModel() {
        TTTListeners = new ArrayList<>();
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;


    }

    public void addTTTListener(TicTacToeListener listener){
        TTTListeners.add(listener);
    }


    private void changeTurn() {

        turn = !turn;
    }

    public Status getStatus() {
        return status;
    }

    private void updateStatus() {

        for (int i = 0; i < SIZE; i++) {

            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ') {
                status = (grid[i][0] == 'X') ? Status.X_WON : Status.O_WON;
                return;
            }

            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' ') {
                status = (grid[0][i] == 'X') ? Status.X_WON : Status.O_WON;
                return;
            }
        }

        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') {
            status = (grid[0][0] == 'X') ? Status.X_WON : Status.O_WON;
            return;
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ') {
            status = (grid[0][2] == 'X') ? Status.X_WON : Status.O_WON;
            return;
        }

        boolean full = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    full = false;
                    break;
                }
            }
            if (!full) break;
        }
        if (full) {
            status = Status.TIE;
            return;
        }

        status = Status.UNDECIDED;
    }

    public boolean getTurn() {

        return turn;
    }

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();
        for(TicTacToeListener tttl: TTTListeners){
            TicTacToeEvent ttte = new TicTacToeEvent(this, x, y, status);
            tttl.onStatusUpdate(ttte);
        }
        changeTurn();
    }

    @Test
    public void testXWins() {
        TicTacToeModel model = new TicTacToeModel();
        model.play(0, 0);
        model.play(1, 1);
        model.play(0, 1);
        model.play(1, 2);
        model.play(0, 2);
        assertEquals(TicTacToeModel.Status.X_WON, model.getStatus());
    }

    @Test
    public void testOWins() {
        TicTacToeModel model = new TicTacToeModel();
        model.play(0, 0);
        model.play(1, 1);
        model.play(0, 1);
        model.play(1, 2);
        model.play(2, 2);
        model.play(1, 0);
        assertEquals(TicTacToeModel.Status.O_WON, model.getStatus());
    }

    @Test
    public void testTie() {
        TicTacToeModel model = new TicTacToeModel();
        model.play(0, 0);
        model.play(0, 1);
        model.play(0, 2);
        model.play(1, 0);
        model.play(1, 2);
        model.play(1, 1);
        model.play(2, 0);
        model.play(2, 2);
        model.play(2, 1);
        assertEquals(TicTacToeModel.Status.TIE, model.getStatus());
    }

    @Test
    public void testUndecided() {
        TicTacToeModel model = new TicTacToeModel();
        model.play(0, 0);
        model.play(0, 1);
        model.play(0, 2);
        model.play(1, 0);
        model.play(1, 2);
        model.play(1, 1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, model.getStatus());
    }
}

