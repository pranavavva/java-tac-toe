package io.github.pranavavva.javatactoe;

public class Board {
    private final Square[][] board;

    public Board() {
        this.board = new Square[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Square();
            }
        }
    }

    public void changeCellOwner(int row, int col, Player newOwner) {
        this.board[row][col].setOwner(newOwner);
    }

    public Player getCellOwner(int row, int col) {
        return this.board[row][col].getOwner();
    }

    public Player getWinner() {
        boolean topRow = board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]);
        boolean middleRow = board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]);
        boolean bottomRow = board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]);

        boolean leftCol = board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]);
        boolean middleCol = board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]);
        boolean rightCol = board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]);

        boolean topLeftBottomRightDiagonal = board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]);
        boolean bottomLeftTopRightDiagonal = board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]);

        if (middleRow || middleCol || bottomLeftTopRightDiagonal || topLeftBottomRightDiagonal){
            return board[1][1].getOwner();
        } else if (topRow || leftCol) {
            return board[0][0].getOwner();
        } else if (bottomRow || rightCol) {
            return board[2][2].getOwner();
        } else {
            return Player.UNKNOWN;
        }
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Square();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Square[] row : this.board) {
            for (Square cell : row) {
                output.append(cell);
            }
            output.append("\n");
        }
        return output.toString();
    }
}
