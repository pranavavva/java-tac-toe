package io.github.pranavavva.javatactoe.gui;

import io.github.pranavavva.javatactoe.Board;
import io.github.pranavavva.javatactoe.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private JButton[][] buttons;
    private ActionListener gameListener;

    public GamePanel(ActionListener gameListener) {
        this.buttons = new JButton[3][3];
        this.gameListener = gameListener;
        this.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.buttons[i][j] = new JButton();
                this.buttons[i][j].setIcon(null);
                this.buttons[i][j].putClientProperty("row", i);
                this.buttons[i][j].putClientProperty("col", j);
                this.buttons[i][j].addActionListener(gameListener);
                this.add(buttons[i][j]);
            }
        }
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.buttons[i][j] = new JButton();
                this.buttons[i][j].setIcon(null);
                this.buttons[i][j].putClientProperty("row", i);
                this.buttons[i][j].putClientProperty("col", j);
                this.buttons[i][j].addActionListener(gameListener);
                this.add(buttons[i][j]);
            }
        }
    }
}
