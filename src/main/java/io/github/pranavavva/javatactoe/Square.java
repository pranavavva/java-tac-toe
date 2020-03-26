package io.github.pranavavva.javatactoe;

import java.util.Objects;

public class Square {
    private Player owner;

    public Square() {
        this.owner = Player.UNKNOWN;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return getOwner() == square.getOwner();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner());
    }

    @Override
    public String toString() {
        return this.owner.getName();
    }
}
