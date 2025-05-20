import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    @Test
    void arrayTwoIntCaptureNewPositionTest(){
        //Arrange
        String newPosition = "1 2";
        int[] expected = {1,2};
        InputStream scanner = System.in;
        System.setIn(new ByteArrayInputStream(newPosition.getBytes()));
        //Act
        int[] result = TicTacToe.captureNewPosition();
        //Assert
        assertArrayEquals(expected,result);
    }
}
