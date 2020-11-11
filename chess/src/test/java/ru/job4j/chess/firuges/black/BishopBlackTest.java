package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void StartPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack.position();
        assertEquals(new BishopBlack(Cell.F8),bishopBlack);
    }
    @Test
    public void CopyBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertEquals(bishopBlack.copy(Cell.C5), new BishopBlack(Cell.C5));
    }
}