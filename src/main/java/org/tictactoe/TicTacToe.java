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
        System.out.print("Select a row (0-2) and a column (0-2), enter the numbers separated by a space: ");
        String newPosition = scanner.nextLine();
        String[] stringArrayNewPosition = newPosition.split(" ");
        int[] arrayNewPosition = new int[2];
        for(int i = 0; i < stringArrayNewPosition.length; i++){
            arrayNewPosition[i] = Integer.parseInt(stringArrayNewPosition[i]);
        }
        arrayNewPosition = checkCorrectPosition(arrayNewPosition);
        return arrayNewPosition;
    }

    static void placeNewPosition(int[] newPositions, char currentPlayer){
        board[newPositions[0]][newPositions[1]] = currentPlayer;
    }

    static int[] checkCorrectPosition(int[] newPositions ){
        for (int i=0; i<newPositions.length ;i++){
            if (newPositions[i]< 0 || newPositions[i]>2){
                System.out.println("This position does not exist");
                return captureNewPosition();
            }
        }
        if (board[newPositions[0]][newPositions[1]]!='_'){
            System.out.println("This position is taken");
            return captureNewPosition();
        }
        return newPositions;
    }

    static boolean checkWin(char currentPlayer) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

}
