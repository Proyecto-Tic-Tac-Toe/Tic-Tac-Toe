package org.tictactoe.entity;

import java.util.Scanner;

import static org.tictactoe.entity.Board.*;


public class Game {
    public static Board board = new Board();
    public static Player player1;
    public static Player player2;

    public static void playerAssigne(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name player1, you play witch X: ");
        player1 = new Player("X",scanner.nextLine());

        System.out.println("Enter name player2, you play witch O: ");
        player2 = new Player("O",scanner.nextLine());

        board.initializeBoard();
    }

    public static void logicaGame(){
        System.out.println("███╗   ██╗███████╗██╗    ██╗     ██████╗  █████╗ ███╗   ███╗███████╗");
        System.out.println("████╗  ██║██╔════╝██║    ██║    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝");
        System.out.println("██╔██╗ ██║█████╗  ██║ █╗ ██║    ██║  ███╗███████║██╔████╔██║█████╗  ");
        System.out.println("██║╚██╗██║██╔══╝  ██║███╗██║    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("██║ ╚████║███████╗╚███╔███╔╝    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗");
        System.out.println("╚═╝  ╚═══╝╚══════╝ ╚══╝╚══╝      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");

        playerAssigne();

        Player currentPlayer = player1;
        boolean gameOver = false;
        board.printBoard();
        while (!gameOver) {

            board.placeNewPosition(board.checkCorrectPosition(captureNewPosition()), currentPlayer.getSymbol());
            board.printBoard();
            if(board.checkWin(currentPlayer.getSymbol())){
                System.out.println("Player " + currentPlayer.getName() + " wins!");
                gameOver = true;
            } else if (board.checkDraw()) {
                System.out.println("It's a draw!");
                gameOver = true;
            }
            currentPlayer = (currentPlayer.getSymbol() == player1.getSymbol()) ? player2 : player1;
        }

        System.out.println("  ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ ");
        System.out.println(" ██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
        System.out.println(" ██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝");
        System.out.println(" ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║██║   ██║██╔══╝  ██╔══██╗");
        System.out.println(" ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝╚██████╔╝███████╗██║  ██║");
        System.out.println("  ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝  ╚═════╝ ╚══════╝╚═╝  ╚═╝");

    }

}
