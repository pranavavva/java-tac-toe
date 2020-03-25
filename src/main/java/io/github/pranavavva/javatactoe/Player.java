package io.github.pranavavva.javatactoe;

public enum Player {
    X("X"),
    O("O"),
    UNKNOWN("-");

    private String name;

    private Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
