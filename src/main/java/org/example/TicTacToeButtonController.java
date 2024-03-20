package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeButtonController implements ActionListener {

    private int row;
    private int col;
    private TicTacToeModel tttm;

    public TicTacToeButtonController(TicTacToeModel tttm,int i, int j) {
        this.tttm=tttm;
        row = i;
        col = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tttm.play(row,col);

    }
}
