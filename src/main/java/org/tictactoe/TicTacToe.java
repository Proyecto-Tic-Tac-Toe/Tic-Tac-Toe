package org.tictactoe;

import java.util.Scanner;

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
        System.out.println("---------");
    }

    static int[] captureNewPosition(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a row and a column: ");
        String newPosition = scanner.nextLine();
        String[] stringArrayNewPosition = newPosition.split(" ");
        int[] arrayNewPosition = new int[2];
        for(int i = 0; i < stringArrayNewPosition.length; i++){
            arrayNewPosition[i] = Integer.parseInt(stringArrayNewPosition[i]);
        }
        return arrayNewPosition;
    }

    static void placeNewPosition(int[] newPositions, char currentPlayer){
        board[newPositions[0]][newPositions[1]] = currentPlayer;
    }

}
