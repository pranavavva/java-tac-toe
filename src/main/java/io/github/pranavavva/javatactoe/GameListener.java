package io.github.pranavavva.javatactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameListener implements ActionListener {

    private GameBoard gameBoard;
    public GameListener(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    private int turnsCompleted = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        GameSquare square = (GameSquare) e.getSource();
        square.setOwner(this.gameBoard.getPlayer());

        switch (this.gameBoard.getPlayer()) {
            case X:
                this.gameBoard.setPlayer(Player.O);
                break;
            case O:
                this.gameBoard.setPlayer(Player.X);
                break;
        }

        this.gameBoard.printButtons();
        turnsCompleted++;
        if (turnsCompleted >= 5) {
            if (this.gameBoard.getWinner() != Player.UNKNOWN) {
                System.out.println("Winner: " + this.gameBoard.getWinner());
                System.exit(0);
            }
        }
    }
}
