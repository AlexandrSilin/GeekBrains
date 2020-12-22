package ru.GeekBrains.lesson4;

public class AI {
    private final char symbol;
    private final char enemySymbol;
    private final int needPut = Constants.DOTS_TO_WIN - 1;

    AI(char symbol, char enemySymbol){
        this.symbol = symbol;
        this.enemySymbol = enemySymbol;
    }

    public char getSymbol(){
        return symbol;
    }

    private boolean checkMap(Map map, char symbol){
        int rows = checkRows(map, symbol);
        if (rows >= 0)
            if (blockRow(map, rows))
                return true;
        int columns = checkColumns(map, symbol);
        if (columns >= 0)
            if (blockColumn(map, columns))
                return true;
        if (checkPrimaryDiagonal(map, symbol))
            if (blockPrimaryDiagonal(map))
                return true;
        if (Constants.SIZE == 5) {
            if (checkPrimaryMinorDiagonal(map, symbol))
                if (blockPrimaryMinorDiagonal(map))
                    return true;
            if (checkPrimaryMajorDiagonal(map, symbol))
                if (blockPrimaryMajorDiagonal(map))
                    return true;
            if (checkSecondaryMinorDiagonal(map, symbol))
                if (blockSecondaryMinorDiagonal(map))
                    return true;
            if (checkSecondaryDiagonal(map, symbol))
                if (blockSecondaryDiagonal(map))
                    return true;
            if (checkSecondaryMajorDiagonal(map, symbol))
                if (blockSecondaryMajorDiagonal(map))
                    return true;
        }
        return false;
    }

    public void aiTurn(Map map){
        if (checkMap(map, symbol))
            return;
        if (checkMap(map, enemySymbol))
            return;
        int x = (int) (Math.random() * Constants.SIZE);
        int y = (int) (Math.random() * Constants.SIZE);
        while (!map.checkCell(x, y)) {
            x = (int) (Math.random() * Constants.SIZE);
            y = (int) (Math.random() * Constants.SIZE);
        }
        map.setCell(x, y, symbol);
    }

    private boolean checkSecondaryMinorDiagonal(Map map, char symbol){
        int secondaryMinor = 0;
        for (int i = 1; i < Constants.SIZE - 1; i++){
            if (map.getSymbol(i, Constants.SIZE - i) == symbol)
                secondaryMinor++;
            if (secondaryMinor == needPut)
                return true;
        }
        return false;
    }

    private boolean blockSecondaryMinorDiagonal(Map map){
        for (int i = 1; i < Constants.SIZE - 1; i++)
            if (map.checkCell(i, Constants.SIZE - i)) {
                map.setCell(i, Constants.SIZE - i, symbol);
                return true;
            }
        return false;
    }

    private boolean checkSecondaryDiagonal(Map map, char symbol){
        int secondary = 0;
        for (int i = 0; i < Constants.SIZE; i++){
                if (map.getSymbol(i, Constants.SIZE - 1 - i) == symbol)
                    secondary++;
                if (secondary == needPut)
                    return true;
            }
        return false;
    }

    private boolean blockSecondaryDiagonal(Map map){
        for (int i = 1; i < Constants.SIZE; i++)
                if (map.checkCell(i, Constants.SIZE - 1 - i)) {
                    map.setCell(i, Constants.SIZE - 1 - i, symbol);
                    return true;
                }
        if (map.checkCell(0, Constants.SIZE - 1)) {
            map.setCell(0, Constants.SIZE - 1, symbol);
            return true;
        }
        return false;
    }

    private boolean checkSecondaryMajorDiagonal(Map map, char symbol){
        int secondaryMajor = 0;
        for (int i = 0; i < Constants.SIZE - 1; i++){
            if (map.getSymbol(i, Constants.SIZE - 1 - (i + 1)) == symbol)
                secondaryMajor++;
            if (secondaryMajor == needPut)
                return true;
        }
        return false;
    }

    private boolean blockSecondaryMajorDiagonal(Map map){
        for (int i = 0; i < Constants.SIZE - 1; i++)
            if (map.checkCell(i, Constants.SIZE - 1 - (i + 1))) {
                map.setCell(i, Constants.SIZE - 1 - (i + 1), symbol);
                return true;
            }
        return false;
    }

    private int checkRows(Map map, char symbol){
        for (int i = 0; i < Constants.SIZE; i++){
            int rows = 0;
            for (int j = 0; j < Constants.SIZE; j++) {
                if (map.getSymbol(i, j) == symbol)
                    rows++;
                if (rows == needPut)
                    return i;
            }
        }
        return -1;
    }

    private boolean blockRow(Map map, int rows){
        for (int i = 1; i < Constants.SIZE; i++)
            if (map.checkCell(rows, i)) {
                map.setCell(rows, i, symbol);
                return true;
            }
        if (map.checkCell(rows, 0)){
            map.setCell(rows, 0, symbol);
            return true;
        }
        return false;
    }

    private int checkColumns(Map map, char symbol){
        for (int i = 0; i < Constants.SIZE; i++) {
            int columns = 0;
            for (int j = 0; j < Constants.SIZE; j++) {
                if (map.getSymbol(j, i) == symbol)
                    columns++;
                if (columns == needPut)
                    return i;
            }
        }
        return -1;
    }

    private boolean blockColumn(Map map, int columns){
        for (int i = 1; i < Constants.SIZE; i++)
            if (map.checkCell(i, columns)) {
                map.setCell(i, columns, symbol);
                return true;
            }
        if (map.checkCell(0, columns)){
            map.setCell(0, columns, symbol);
            return true;
        }
        return false;
    }

    private boolean checkPrimaryMajorDiagonal(Map map, char symbol){
        int primaryMajor = 0;
        for (int i = 0; i < Constants.SIZE; i++){
                if (map.getSymbol(i, i + 1) == symbol)
                    primaryMajor++;
                if (primaryMajor == needPut)
                    return true;
            }
        return false;
    }

    private boolean blockPrimaryMajorDiagonal(Map map){
        for (int i = 0; i < Constants.SIZE; i++)
            if (map.checkCell(i, i + 1)) {
                map.setCell(i, i + 1, symbol);
                return true;
            }
        return false;
    }

    private boolean checkPrimaryMinorDiagonal(Map map, char symbol){
        int primaryMinor = 0;
        for (int i = 0; i < Constants.SIZE; i++){
            if (map.getSymbol(i, i - 1) == symbol)
                primaryMinor++;
            if (primaryMinor == needPut)
                return true;
        }
        return false;
    }

    private boolean blockPrimaryMinorDiagonal(Map map){
        for (int i = 0; i < Constants.SIZE; i++)
            if (map.checkCell(i, i - 1)) {
                map.setCell(i, i - 1, symbol);
                return true;
            }
        return false;
    }

    private boolean checkPrimaryDiagonal(Map map, char symbol){
        int primary = 0;
        for (int i = 0; i < Constants.SIZE; i++){
            if (map.getSymbol(i, i) == symbol)
                primary++;
            if (primary == needPut)
                return true;
            }
        return false;
    }

    private boolean blockPrimaryDiagonal(Map map){
        for (int i = 1; i < Constants.SIZE; i++)
            if (map.checkCell(i, i)){
                map.setCell(i, i, symbol);
                return true;
            }
        if (map.checkCell(0, 0)){
            map.setCell(0, 0, symbol);
            return true;
        }
        return false;
    }
}