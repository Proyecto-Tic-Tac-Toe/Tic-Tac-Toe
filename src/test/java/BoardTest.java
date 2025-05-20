import org.junit.jupiter.api.Test;
import org.tictactoe.entity.Board;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;



public class BoardTest {
    @Test
    void initializeBoardTest(){
        //Arrange
        Board board = new Board();
        String[][]  expected = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
        //Act
        board.initializeBoard();
        String[][] result = board.getBoard();
        //Assert
        assertArrayEquals(expected,result);
    }
    @Test
    void arrayTwoIntCaptureNewPositionTest(){
        //Arrange
        Board board = new Board();
        String newPosition = "1 2";
        int[] expected = {1,2};
        InputStream scanner = System.in;
        System.setIn(new ByteArrayInputStream(newPosition.getBytes()));
        //Act
        board.initializeBoard();
        int[] result = board.captureNewPosition();
        //Assert
        assertArrayEquals(expected,result);
    }
    @Test
    void checkDrowTest(){
        //Arrange
        Board board = new Board();
        String[][] expected = {{"X","O","X"},{"O","X","O"},{"O","X","O"}};
        //Act
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
        //Assert
        assertArrayEquals(expected,result);
    }
    @Test
    void checkWinTest(){
        //Arrange
        Board board = new Board();
        String[][] expected = {{"X","O","X"},{"O","X","O"},{"O","X","O"}};
        //Act
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
        //Assert
        assertArrayEquals(expected,result);
    }

    @Test
    void checkCorrectPositionTest(){
        //Arrange
        Board board = new Board();
        int[] expected = {0,0};
        //Act
        board.initializeBoard();
        int[] result = board.checkCorrectPosition(new int[]{0,0});
        //Assert
        assertArrayEquals(expected,result);
    }

}
