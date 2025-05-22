package org.tictactoe.entity;

public class SymbolArt {

    public static String[] getX() {
        return new String[]{
                "██╗░░██╗",
                "╚██╗██╔╝",
                "░╚███╔╝░",
                "░██╔██╗░",
                "██╔╝╚██╗",
                "╚═╝░░╚═╝"
        };
    }

    public static String[] getO() {
        return new String[]{
                "░█████╗░",
                "██╔══██╗",
                "██║░░██║",
                "██║░░██║",
                "╚█████╔╝",
                "░╚════╝░"
        };
    }

    public static String[] getEmpty() {
        return new String[]{
                "░░░░░░░░",
                "░░░░░░░░",
                "░░░░░░░░",
                "░░░░░░░░",
                "░░░░░░░░",
                "░░░░░░░░"
        };
    }
}
