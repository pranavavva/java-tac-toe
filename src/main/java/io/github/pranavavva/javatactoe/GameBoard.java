package io.github.pranavavva.javatactoe;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    private GameSquare[][] buttons;
    private GameListener gameListener;
    private Player player;

    public GameBoard() {
        super(new GridLayout(3, 3));
        gameListener = new GameListener(this);
        player = Player.X;

        buttons = new GameSquare[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new GameSquare();
                buttons[i][j].addActionListener(gameListener);
                add(buttons[i][j]);
            }
        }
    }

    public void printButtons() {
        System.out.println("=====");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(buttons[i][j].getOwner().getName());
            }
            System.out.println("|");
        }
        System.out.println("=====\n");
    }

    public Player getWinner() {

        boolean topRow = buttons[0][0].equals(buttons[0][1]) && buttons[0][1].equals(buttons[0][2]);
        boolean middleRow = buttons[1][0].equals(buttons[1][1]) && buttons[1][1].equals(buttons[1][2]);
        boolean bottomRow = buttons[2][0].equals(buttons[2][1]) && buttons[2][1].equals(buttons[2][2]);

        boolean leftCol = buttons[0][0].equals(buttons[1][0]) && buttons[1][0].equals(buttons[2][0]);
        boolean middleCol = buttons[0][1].equals(buttons[1][1]) && buttons[1][1].equals(buttons[2][1]);
        boolean rightCol = buttons[0][2].equals(buttons[1][2]) && buttons[1][2].equals(buttons[2][2]);

        boolean topLeftBottomRightDiagonal = buttons[0][0].equals(buttons[1][1]) && buttons[1][1].equals(buttons[2][2]);
        boolean bottomLeftTopRightDiagonal = buttons[0][2].equals(buttons[1][1]) && buttons[1][1].equals(buttons[2][0]);

        if (middleRow || middleCol || bottomLeftTopRightDiagonal || topLeftBottomRightDiagonal){
            return buttons[1][1].getOwner();
        } else if (topRow || leftCol) {
            return buttons[0][0].getOwner();
        } else if (bottomRow || rightCol) {
            return buttons[2][2].getOwner();
        } else {
            return Player.UNKNOWN;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}