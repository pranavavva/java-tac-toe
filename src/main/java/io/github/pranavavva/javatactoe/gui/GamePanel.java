package io.github.pranavavva.javatactoe.gui;

import io.github.pranavavva.javatactoe.Board;
import io.github.pranavavva.javatactoe.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private JButton[][] buttons;

    public GamePanel(ActionListener gameListener, Board board) {
        this.buttons = new JButton[3][3];
        this.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.buttons[i][j] = new JButton();
                this.buttons[i][j].setText(board.getCellOwner(i, j).getName());
                this.buttons[i][j].putClientProperty("row", i);
                this.buttons[i][j].putClientProperty("col", j);
                this.buttons[i][j].addActionListener(gameListener);
                this.add(buttons[i][j]);
            }
        }
    }
}
