package org.tictactoe.entity;

import java.util.Scanner;

public class Board {


    private static String[size][size] board;
    private static int size = 3;



    public static void initializeBoard (){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = "_";
            }
        }
    }

    public static void printBoard () {
        System.out.print("---------");
        System.out.println();
        for (int i=0; i<size; i++){
            System.out.print("| ");
            for (int j=0; j<size; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();

        }
        System.out.println("---------");
    }

    public static int[] captureNewPosition(){
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

    public static void placeNewPosition(int[] newPositions, String currentPlayer){
        board[newPositions[0]][newPositions[1]] = currentPlayer;
    }

    public static int[] checkCorrectPosition(int[] newPositions ){
        for (int i=0; i<newPositions.length ;i++){
            if (newPositions[i]< 0 || newPositions[i]>2){
                System.out.println("This position does not exist");
                return captureNewPosition();
            }
        }
        if (board[newPositions[0]][newPositions[1]]!="_"){
            System.out.println("This position is taken");
            return captureNewPosition();
        }
        return newPositions;
    }

    public static boolean checkWin(String currentPlayer){
        for (int i=0;i<size ;i++){
            if (board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer) {
                return true;
            }
        }
        for (int i=0;i<size ;i++){
            if (board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer) {
                return true;
            }
        }
        if (board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer) {
            return true;
        }
        if (board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer) {
            return true;
        }
        return false;
    }

    public static boolean checkDraw(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == "_") {
                    return false;
                }
            }
        }
        return true;
    }

}
