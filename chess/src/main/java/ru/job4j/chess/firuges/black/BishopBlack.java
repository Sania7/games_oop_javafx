package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        this.position = ps;
    }

    @Override
    public Cell position() {
        return this.position;
    }


    @Override
    public Cell[] way(Cell source, Cell dest) {
        isDiagonal(source, dest);
        int size = Math.abs(source.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - source.getX()) / size;
        int deltaY = (dest.getY() - source.getY()) / size;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.getX() + deltaX * index + 1, source.getY() + deltaY * index + 1);
        }
        return steps;
    }


    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        if ((source.getX() + source.getY()) == (dest.getX() + dest.getY()) || (dest.getY() - dest.getX()) == (source.getY()) - source.getX()) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
