package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void positionTest() {
        Figure blackBisop = new BishopBlack(Cell.F8);
        assertThat(blackBisop.position(), is(Cell.F8));
    }

    @Test
    public void copyTest() {
        Figure blackBisop = new BishopBlack(Cell.F8);
        blackBisop = blackBisop.copy(Cell.H3);
        assertThat(blackBisop.position(), is(Cell.H3));
    }

    @Test
    public void wayTest() {
        Figure blackBisop = new BishopBlack(Cell.C8);
        Cell[] cells = blackBisop.way(Cell.A6);
        assertThat(cells, is(new Cell[] {Cell.B7, Cell.A6}));
    }

    @Test
    public void noDiagonalTest() throws ImpossibleMoveException {
        Figure blackBisop = new BishopBlack(Cell.C8);
        try {
            blackBisop.way(Cell.G3);
        } catch (ImpossibleMoveException e) {
            assertEquals("Could not way by diagonal from C8 to G3", e.getMessage());
        }
    }

    @Test
    public void noFreeTest() throws ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new PawnBlack(Cell.B7));
        logic.add(new PawnBlack(Cell.C7));
        logic.add(new PawnBlack(Cell.D7));
        logic.add(new PawnBlack(Cell.E7));
        logic.add(new PawnBlack(Cell.F7));
        logic.add(new PawnBlack(Cell.G7));
        logic.add(new PawnBlack(Cell.H7));
        logic.add(new RookBlack(Cell.A8));
        logic.add(new KnightBlack(Cell.B8));
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new QueenBlack(Cell.D8));
        logic.add(new KingBlack(Cell.E8));
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new KnightBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));
        try {
            logic.move(Cell.C8, Cell.A6);
        } catch (Exception ignored) {
        }

    }

}