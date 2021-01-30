package ru.GeekBrains.lesson8;

public class Map implements Constants {
    private final char[][] map;

    Map(){
        map = new char[Constants.SIZE][Constants.SIZE];
        for (int i = 0; i < Constants.SIZE; i++)
            for (int j = 0; j < Constants.SIZE; j++)
                map[i][j] = Constants.DOT_EMPTY;
    }

    public void setCell(int x, int y, char sym){
        map[x][y] = sym;
    }

    public char getSymbol(int x, int y){
        if (x < 0 || y < 0 || x > Constants.SIZE - 1 || y > Constants.SIZE - 1)
            return ' ';
        return map[x][y];
    }

    public boolean checkCell(int x, int y){
        if (x < 0 || y < 0 || x > Constants.SIZE - 1 || y > Constants.SIZE - 1)
            return false;
        return map[x][y] == Constants.DOT_EMPTY;
    }

    public boolean checkMap(){
        for (int i = 0; i < Constants.SIZE; i++)
            for (int j = 0; j < Constants.SIZE; j++)
                if (checkCell(i, j))
                    return true;
        return false;
    }

    public void printMap(){
        for (int i = 0; i < Constants.SIZE + 1; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < Constants.SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < Constants.SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}