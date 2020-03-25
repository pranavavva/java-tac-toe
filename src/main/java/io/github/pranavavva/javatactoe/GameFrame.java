package io.github.pranavavva.javatactoe;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        super("Tic Tac Toe");
        setLayout(new BorderLayout());

        GameBoard gameBoard = new GameBoard();
        add(gameBoard, BorderLayout.CENTER);

        JTextField statusBar = new JTextField(Player.X.getName() + "'s Turn");
        statusBar.setEditable(false);
        add(statusBar, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400, 400, 400, 400);
        setVisible(true);
    }
}
