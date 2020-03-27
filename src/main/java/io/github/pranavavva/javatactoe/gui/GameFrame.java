package io.github.pranavavva.javatactoe.gui;

import io.github.pranavavva.javatactoe.Board;
import io.github.pranavavva.javatactoe.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GameFrame extends JFrame {
    private Board board;
    private GamePanel panel;
    private JTextField status;
    private Player currentPlayer;
    private Player winner = Player.UNKNOWN;

    public GameFrame(Board board) {
        this.board = board;
        GameListener gameListener = new GameListener();
        this.panel = new GamePanel(gameListener);
        this.status = new JTextField("Status: Turns Completed: 0 | Winner: Game in progress");
        this.currentPlayer = Player.X;

        this.setTitle("Tic Tac Toe");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.status.setEditable(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem quitItem = new JMenuItem("Quit");
        JMenuItem resetItem = new JMenuItem("Reset");

        quitItem.addActionListener((actionEvent) -> System.exit(0));

        gameMenu.add(quitItem);
        gameMenu.add(resetItem);
        menuBar.add(gameMenu);

        this.add(menuBar, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(status, BorderLayout.SOUTH);

        this.setBounds(400, 400, 400, 400);
        this.setResizable(false);
        this.setVisible(true);
    }

    private class GameListener implements ActionListener {
        private int turnsCompleted = 0;
        private ImageIcon xIcon;
        private ImageIcon oIcon;

        private GameListener() {
            xIcon = createImageIcon("x-icon.png", "Icon for Player X");
            oIcon = createImageIcon("o-icon.png", "Icon for Player O");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!winner.equals(Player.UNKNOWN) && turnsCompleted < 9) return;


            JButton button = (JButton) e.getSource();
            if (!(button.getIcon() == null)) return;

            board.changeCellOwner((int) button.getClientProperty("row"), (int) button.getClientProperty("col"), currentPlayer);
            button.setIcon((currentPlayer.equals(Player.X) ? xIcon : oIcon));

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
                        if (turnsCompleted == 9) {
                            status.setText("Status: Turns Completed: " + turnsCompleted + " | It's a tie!");
                        } else {
                            status.setText("Status: Turns Completed: " + turnsCompleted + " | Winner: Game in progress");
                        }
                        break;
                }
            } else {
                status.setText("Status: Turns Completed: " + turnsCompleted + " | Winner: Game in progress");
            }
        }
    }

    private ImageIcon createImageIcon(String path, String description) {
        return new ImageIcon(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(path)), description);
    }
}
