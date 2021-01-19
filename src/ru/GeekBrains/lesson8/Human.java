package ru.GeekBrains.lesson8;

import java.util.Scanner;

public class Human {
    private final char symbol;

    static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    public Human(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }

    private static int getCoordinate(){
        int x = scanner.nextInt() - 1;
        while (x > Constants.SIZE - 1 || x < 0) {
            System.out.println("Введите корректное значение:");
            x = scanner.nextInt() - 1;
        }
        return x;
    }

    public void humanTurn(Map map) {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки x:");
            x = getCoordinate();
            System.out.println("Введите координаты ячейки y:");
            y = getCoordinate();
        } while (!map.checkCell(x, y));
        map.setCell(x, y, symbol);
    }
}
