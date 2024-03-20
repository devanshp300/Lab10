package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

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



