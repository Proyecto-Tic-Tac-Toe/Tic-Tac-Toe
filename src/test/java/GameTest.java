import org.junit.jupiter.api.Test;
import org.tictactoe.entity.Board;
import org.tictactoe.entity.Game;
import org.tictactoe.entity.SymbolArt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void playerAssignTest(){
        String newPlayers = "Pepita\nRosita\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(newPlayers.getBytes()));

        Game.playerAssign();

        assertEquals("Pepita", Game.player1.getName());
        assertEquals("Rosita", Game.player2.getName());

        System.setIn(originalIn);
    }

}
