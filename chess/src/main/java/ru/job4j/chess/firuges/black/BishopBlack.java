package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {

    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int startX = position.getX();
        int startY = position.getY();
        int deltaX = dest.getX() - position.getX() > 0 ? 1 : -1;
        int deltaY = dest.getY() - position.getY() > 0 ? 1 : -1;
        for (int index = 0; index < size; index++) {
            startX = startX + deltaX;
            startY = startY + deltaY;
            steps[index] = Cell.findBy(startX, startY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean res = true;
        if (Math.abs(dest.getX() - source.getX()) != Math.abs(dest.getY() - source.getY())) {
            res = false;
        }
        return res;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
