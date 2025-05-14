package org.tictactoe;

public class TicTacToe {
    //Crear metodo print board
    private static char[][] board = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };
    //Crear array de dos dimensiones
    static void printBoard () {
        System.out.print("---------");
        System.out.println();
        for (int i=0; i<board.length; i++){
            System.out.print("| ");
            for (int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();

        }
        System.out.print("---------");


    }

}
