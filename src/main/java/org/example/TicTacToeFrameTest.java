package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class TicTacToeFrameTest {

    @Test
    public void testTicTacToeFrameInstantiation() {

        TicTacToeModel stubModel = mock(TicTacToeModel.class);

        TicTacToeFrame frame = new TicTacToeFrame(stubModel);

        assertEquals("Tic Tac Toe!", frame.getTitle());
    }
}
