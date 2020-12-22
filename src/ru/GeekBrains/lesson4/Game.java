package ru.GeekBrains.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game implements Constants {

    public static void main(String[] args) throws IOException {
        System.out.println("Чем играть?\n1 - X, 2 - O:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(reader.readLine());
        boolean win = false;
        while (choice > 2 || choice < 1) {
            System.out.println("Введите крректное значение");
            choice = Integer.parseInt(reader.readLine());
        }
        Human human = choice == 1 ? new Human(Constants.DOT_X) : new Human(Constants.DOT_O);
        AI ai = choice == 1 ? new AI(Constants.DOT_O, Constants.DOT_X) : new AI(Constants.DOT_X, Constants.DOT_O);
        Map map = new Map();
        do {
            System.out.println("Текущее состояние поля:");
            map.printMap();
            human.humanTurn(map);
            if (checkWin(map, human.getSymbol())){
                win = true;
                System.out.println("Победил человек");
            }
            ai.aiTurn(map);
            if (checkWin(map, ai.getSymbol())){
                win = true;
                System.out.println("Победил компьютер");
            }
        } while (map.checkMap() && !win);
        if (!(map.checkMap() && win))
            System.out.println("Ничья");
        map.printMap();
        reader.close();
    }

    private static boolean checkRows(Map map, char symbol){
        for (int i = 0; i < Constants.SIZE; i++){
            int rows = 0;
            for (int j = 0; j < Constants.SIZE; j++) {
                if (map.getSymbol(i, j) == symbol)
                    rows++;
                else
                    break;
                if (rows == Constants.DOTS_TO_WIN)
                    return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(Map map, char symbol){
        for (int i = 0; i < Constants.SIZE; i++) {
            int columns = 0;
            for (int j = 0; j < Constants.SIZE; j++) {
                if (map.getSymbol(j, i) == symbol)
                    columns++;
                else
                    break;
                if (columns == Constants.DOTS_TO_WIN)
                    return true;
            }
        }
        return false;
    }

    private static boolean checkPrimaryDiagonals(Map map, char symbol){
        int primary = 0;
        int primaryMinor = 0;
        int primaryMajor = 0;
        for (int i = 0; i < Constants.SIZE; i++){
            if (map.getSymbol(i, i) == symbol)
                primary++;
            if (map.getSymbol(i, i + 1) == symbol)
                primaryMajor++;
            if (map.getSymbol(i, i - 1) == symbol)
                primaryMinor++;
            if (primary == Constants.DOTS_TO_WIN || primaryMajor == Constants.DOTS_TO_WIN ||
                    primaryMinor == Constants.DOTS_TO_WIN)
                return true;
        }
        return false;
    }

    public static boolean checkSecondaryDiagonals(Map map, char symbol){
        int secondary = 0;
        int secondaryMinor = 0;
        int secondaryMajor = 0;
        for (int i = Constants.SIZE - 1; i >= 0; i--){
            if (map.getSymbol(i, Constants.SIZE - i) == symbol)
                secondary++;
            if (map.getSymbol(i, Constants.SIZE - 1 - i) == symbol)
                secondaryMajor++;
            if (map.getSymbol(i, Constants.SIZE - 1 - (i + 1)) == symbol)
                secondaryMinor++;
            if (secondary == Constants.DOTS_TO_WIN || secondaryMinor == Constants.DOTS_TO_WIN
                    || secondaryMajor == Constants.DOTS_TO_WIN)
                return true;
        }
        return false;
    }

    private static boolean checkWin(Map map, char symbol){
        if (checkRows(map, symbol))
            return true;
        if (checkColumns(map, symbol))
            return true;
        if (checkPrimaryDiagonals(map,symbol))
            return true;
        return checkSecondaryDiagonals(map, symbol);
    }
}