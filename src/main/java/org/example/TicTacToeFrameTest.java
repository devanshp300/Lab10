package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TicTacToeFrameTest {

    @Test
    public void testTicTacToeFrameInstantiation() {

        TicTacToeModel stubModel = mock(TicTacToeModel.class);

        when(stubModel.getTurn()).thenReturn(true);

        TicTacToeFrame frame = new TicTacToeFrame(stubModel);

        assertEquals("Tic Tac Toe!", frame.getTitle());

    }
}
