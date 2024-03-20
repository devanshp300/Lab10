package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

import java.awt.*;

import static org.example.TicTacToeModel.SIZE;

@Component
public class TicTacToeFrame extends JFrame implements TicTacToeListener {

    private JButton[][] buttonGrid;

    public TicTacToeFrame(TicTacToeModel tttm) {
        super("Tic Tac Toe!");

       // TicTacToeModel tttm = new TicTacToeModel();

        tttm.addTTTListener(this);

        buttonGrid = new JButton[SIZE][SIZE];
        this.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton jb = new JButton("");
                buttonGrid[i][j] = jb;
                this.add(jb);
                jb.addActionListener(new TicTacToeButtonController(tttm, i, j));
            }
        }
        this.setSize(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void onStatusUpdate(TicTacToeEvent ttte) {
        int x = ttte.getX();
        int y = ttte.getY();

        //buttonGrid[x][y].setText(String.valueOf(ttte.getModel().getTurn()));

        Object o = ttte.getSource();
        String label = " ";

        if (o instanceof TicTacToeModel) {
            TicTacToeModel m = ttte.getModel();
            label = m.getTurn() ? "X" : "O";

            buttonGrid[x][y].setText(label);

            TicTacToeModel.Status status = m.getStatus();
            if (status == TicTacToeModel.Status.X_WON || status == TicTacToeModel.Status.O_WON || status == TicTacToeModel.Status.TIE) {
                JOptionPane.showMessageDialog(this, "Game Over! " + status, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
