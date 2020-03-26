package io.github.pranavavva.javatactoe.gui;

import io.github.pranavavva.javatactoe.Board;
import io.github.pranavavva.javatactoe.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private Board board;
    private GamePanel panel;
    private JTextField status;
    private GameListener gameListener;
    private Player currentPlayer;
    private Player winner = Player.UNKNOWN;

    public GameFrame(Board board) {
        this.board = board;
        this.gameListener = new GameListener();
        this.panel = new GamePanel(this.gameListener, this.board);
        this.status = new JTextField("Status: Turns Completed: 0 | Winner: Game in progress");
        this.currentPlayer = Player.X;

        this.setTitle("Tic Tac Toe");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.status.setEditable(false);

        this.add(panel, BorderLayout.CENTER);
        this.add(status, BorderLayout.SOUTH);

        this.setBounds(400, 400, 400, 400);
        this.setResizable(false);
        this.setVisible(true);
    }

    private class GameListener implements ActionListener {
        private int turnsCompleted = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!winner.equals(Player.UNKNOWN)) return;


            JButton button = (JButton) e.getSource();
            if (!button.getText().equals("-")) return;

            board.changeCellOwner((int) button.getClientProperty("row"), (int) button.getClientProperty("col"), currentPlayer);
            button.setText(currentPlayer.getName());

            turnsCompleted++;
            switch (currentPlayer) {
                case X:
                    currentPlayer = Player.O;
                    break;
                case O:
                    currentPlayer = Player.X;
                    break;
            }


            if (turnsCompleted >= 5) {
                winner = board.getWinner();
                switch (winner) {
                    case X:
                        status.setText("Status: Turns Completed: " + turnsCompleted + " | Winner: X");
                        break;
                    case O:
                        status.setText("Status: Turns Completed: " + turnsCompleted + " | Winner: O");
                        break;
                    case UNKNOWN:
                        status.setText("Status: Turns Completed: " + turnsCompleted + " | Winner: Game in progress");
                        break;
                }
            } else {
                status.setText("Status: Turns Completed: " + turnsCompleted + " | Winner: Game in progress");
            }
        }
    }
}
