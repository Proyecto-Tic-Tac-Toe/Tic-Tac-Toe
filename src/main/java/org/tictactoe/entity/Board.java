package org.tictactoe.entity;

import java.util.Objects;
import java.util.Scanner;

public class Board {

    private static String[][] board;
    private static int size = 3;

    public static String[][] getBoard() {
        return board;
    }

    public static int getSize() {
        return size;
    }

    public static void initializeBoard (){

        board = new String[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] ="_";
            }
        }
    }

    public static void printBoard() {

        System.out.println("╔═══════════════════════════════╗");
        for (int row = 0; row < size; row++) {
            for (int line = 0; line < 6; line++) {
                System.out.print("║ ");
                for (int col = 0; col < size; col++) {
                    String cell = board[row][col];
                    String[] art;
                    if ("X".equals(cell)) {
                        art = SymbolArt.getX();
                    } else if ("O".equals(cell)) {
                        art = SymbolArt.getO();
                    } else {
                        art = SymbolArt.getEmpty();
                    }
                    System.out.print(art[line] + "  ");
                }
                System.out.println("║");
            }
            System.out.println("╠═══════════════════════════════╣");
        }
    }


    public static int[] captureNewPosition(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a row (0-2) and a column (0-2), enter the numbers separated by a space: ");
        String newPosition = scanner.nextLine();
        String[] stringArrayNewPosition = newPosition.split(" ");

        int[] arrayNewPosition = new int[2];
        for(int i = 0; i < stringArrayNewPosition.length; i++){
            if (stringArrayNewPosition.length>2){
                System.out.println("Enter only a couple of numeric values between 0 and 2");
                return captureNewPosition();
            }
            if (!stringArrayNewPosition[i].equals("0") && !stringArrayNewPosition[i].equals("1") && !stringArrayNewPosition[i].equals("2")){
                System.out.println("Enter only a couple of numeric values between 0 and 2");
                return captureNewPosition();

            } else {
                arrayNewPosition[i] = Integer.parseInt(stringArrayNewPosition[i]);
            }
        }

        arrayNewPosition = checkCorrectPosition(arrayNewPosition);
        return arrayNewPosition;
    }

    public static void placeNewPosition(int[] newPositions, String currentPlayer){
        board[newPositions[0]][newPositions[1]] = currentPlayer;
    }

    public static int[] checkCorrectPosition(int[] newPositions ){

        if (!Objects.equals(board[newPositions[0]][newPositions[1]], "_")){
            System.out.println("This position is taken");
            return captureNewPosition();
        }
        return newPositions;
    }

    public static boolean checkWin(String currentPlayer){

        for (int i=0;i<size ;i++){
            if (Objects.equals(board[i][0], currentPlayer) && Objects.equals(board[i][1], currentPlayer) && Objects.equals(board[i][2], currentPlayer)) {
                return true;
            }
        }

        for (int i=0;i<size ;i++){
            if (Objects.equals(board[0][i], currentPlayer) && Objects.equals(board[1][i], currentPlayer) && Objects.equals(board[2][i], currentPlayer)) {
                return true;
            }
        }

        if (Objects.equals(board[0][0], currentPlayer) && Objects.equals(board[1][1], currentPlayer) && Objects.equals(board[2][2], currentPlayer)) {
            return true;
        }

        return Objects.equals(board[0][2], currentPlayer) && Objects.equals(board[1][1], currentPlayer) && Objects.equals(board[2][0], currentPlayer);
    }

    public static boolean checkDraw(){

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Objects.equals(board[i][j], "_")) {
                    return false;
                }
            }
        }
        return true;
    }

}
