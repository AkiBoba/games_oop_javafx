package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void positionTest() {
        Figure blackBishop = new BishopBlack(Cell.F8);
        assertThat(blackBishop.position(), is(Cell.F8));
    }

    @Test
    public void copyTest() {
        Figure blackBishop = new BishopBlack(Cell.F8);
        blackBishop = blackBishop.copy(Cell.H3);
        assertThat(blackBishop.position(), is(Cell.H3));
    }

    @Test
    public void wayTest() {
        Figure blackBishop = new BishopBlack(Cell.C8);
        Cell[] cells = blackBishop.way(Cell.A6);
        assertThat(cells, is(new Cell[] {Cell.B7, Cell.A6}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void noDiagonalTest() throws ImpossibleMoveException {
        Figure blackBishop = new BishopBlack(Cell.C8);
            blackBishop.way(Cell.G3);
    }

    @Test(expected = OccupiedCellException.class)
    public void noFreeTest() throws OccupiedCellException,
            FigureNotFoundException, ImpossibleMoveException {
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
        logic.move(Cell.C8, Cell.A6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void noFoundTest() throws OccupiedCellException,
            FigureNotFoundException, ImpossibleMoveException {
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
        logic.add(new QueenBlack(Cell.D8));
        logic.add(new KingBlack(Cell.E8));
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new KnightBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));
        logic.move(Cell.C8, Cell.A6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void noMoveTest() throws OccupiedCellException,
            FigureNotFoundException, ImpossibleMoveException {
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
        logic.move(Cell.C8, Cell.A4);
    }
}