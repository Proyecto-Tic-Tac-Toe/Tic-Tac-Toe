package org.tictactoe;

import static org.tictactoe.TicTacToe.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("███╗   ██╗███████╗██╗    ██╗     ██████╗  █████╗ ███╗   ███╗███████╗");
        System.out.println("████╗  ██║██╔════╝██║    ██║    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝");
        System.out.println("██╔██╗ ██║█████╗  ██║ █╗ ██║    ██║  ███╗███████║██╔████╔██║█████╗  ");
        System.out.println("██║╚██╗██║██╔══╝  ██║███╗██║    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("██║ ╚████║███████╗╚███╔███╔╝    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗");
        System.out.println("╚═╝  ╚═══╝╚══════╝ ╚══╝╚══╝      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");

        char currentPlayer = 'x';
        boolean gameOver = false;

        while (!gameOver) {
            printBoard();
            placeNewPosition(checkCorrectPosition(captureNewPosition()), currentPlayer);
            printBoard();
            if(checkWin(currentPlayer)){
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (checkDraw()) {
                ;
                System.out.println("It's a draw!");
                gameOver = true;
            }
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }

        System.out.println("  ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ ");
        System.out.println(" ██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
        System.out.println(" ██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝");
        System.out.println(" ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║██║   ██║██╔══╝  ██╔══██╗");
        System.out.println(" ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝╚██████╔╝███████╗██║  ██║");
        System.out.println("  ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝  ╚═════╝ ╚══════╝╚═╝  ╚═╝");




    }
}