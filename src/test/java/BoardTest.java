import org.junit.jupiter.api.Test;
import org.tictactoe.entity.Board;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void initializeBoardTest(){

        Board board = new Board();
        String[][]  expected = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};

        board.initializeBoard();
        String[][] result = board.getBoard();

        assertArrayEquals(expected,result);
    }

    @Test
    void arrayTwoIntCaptureNewPositionTest(){

        Board board = new Board();
        String newPosition = "1 2";
        int[] expected = {1,2};
        InputStream scanner = System.in;
        System.setIn(new ByteArrayInputStream(newPosition.getBytes()));

        board.initializeBoard();
        int[] result = board.captureNewPosition();

        assertArrayEquals(expected,result);
    }

    @Test
    void checkDrowTest(){

        Board board = new Board();
        String[][] expected = {{"X","O","X"},{"O","X","O"},{"O","X","O"}};

        board.initializeBoard();
        board.placeNewPosition(new int[]{0,0},"X");
        board.placeNewPosition(new int[]{0,1},"O");
        board.placeNewPosition(new int[]{0,2},"X");
        board.placeNewPosition(new int[]{1,0},"O");
        board.placeNewPosition(new int[]{1,1},"X");
        board.placeNewPosition(new int[]{1,2},"O");
        board.placeNewPosition(new int[]{2,0},"O");
        board.placeNewPosition(new int[]{2,1},"X");
        board.placeNewPosition(new int[]{2,2},"O");
        String[][] result = board.getBoard();

        assertArrayEquals(expected,result);
    }

    @Test
    void checkWinTest(){

        Board board = new Board();
        String[][] expected = {{"X","O","X"},{"O","X","O"},{"O","X","O"}};

        board.initializeBoard();
        board.placeNewPosition(new int[]{0,0},"X");
        board.placeNewPosition(new int[]{0,1},"O");
        board.placeNewPosition(new int[]{0,2},"X");
        board.placeNewPosition(new int[]{1,0},"O");
        board.placeNewPosition(new int[]{1,1},"X");
        board.placeNewPosition(new int[]{1,2},"O");
        board.placeNewPosition(new int[]{2,0},"O");
        board.placeNewPosition(new int[]{2,1},"X");
        board.placeNewPosition(new int[]{2,2},"O");
        String[][] result = board.getBoard();

        assertArrayEquals(expected,result);
    }

    @Test
    void checkCorrectPositionTest(){

        Board board = new Board();
        int[] expected = {0,0};

        board.initializeBoard();
        int[] result = board.checkCorrectPosition(new int[]{0,0});

        assertArrayEquals(expected,result);
    }

}
