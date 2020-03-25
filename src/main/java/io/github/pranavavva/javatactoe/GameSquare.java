package io.github.pranavavva.javatactoe;

import javax.swing.*;
import java.util.Objects;

public class GameSquare extends JButton {
    private Player owner;

    public GameSquare(Player owner) {
        super(owner.getName());
        this.owner = owner;
    }

    public GameSquare() {
        this(Player.UNKNOWN);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
        this.setText(owner.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSquare that = (GameSquare) o;
        return owner == that.owner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }
}
