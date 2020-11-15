package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rsl = false;
        try {
            int index1 = this.findBy(source);
            if (index1 != -1) {
                Cell[] steps = this.figures[index1].way(source, dest);
                free(steps);
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rsl = true;
                    this.figures[index1] = this.figures[index1].copy(dest);
                }
            }
        } catch (IllegalStateException e) {
            System.out.println(String.format("Way is not free, try again."));
        }
        return rsl;
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        boolean rst = true;
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < index; j++) {
                if (steps[i].equals(figures[j].position())) {
                    throw new IllegalStateException();
                }
            }
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
