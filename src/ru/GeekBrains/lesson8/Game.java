package ru.GeekBrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class Game implements Constants {
    private static final Map map = new Map();
    private static String win = "Draw";
    private static final AI ai = new AI(Constants.DOT_O, Constants.DOT_X);

    protected static class MyWindow extends JFrame {

        public MyWindow() {
            setTitle("Tic-Tac-Toe");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(600, 600);
            setResizable(false);
            setLocationRelativeTo(null);
            GridLayout gridLayout = new GridLayout(Constants.SIZE, Constants.SIZE);
            setLayout(gridLayout);
            JButton [][] jButtons = new JButton[Constants.SIZE][Constants.SIZE];

            for (int i = 0; i < Constants.SIZE; i++)
                for (int j = 0; j < Constants.SIZE; j++){
                    int finalJ = j;
                    int finalI = i;
                    jButtons[i][j] = new JButton(){
                        @Override
                        public void paint(Graphics graphics){
                            super.paint(graphics);
                            if (map.getSymbol(finalI, finalJ) == Constants.DOT_O){
                                graphics.drawOval(this.getWidth() / 4, this.getHeight() / 4,
                                        this.getWidth() / 2, this.getWidth() / 2);
                                graphics.setColor(Color.RED);
                                graphics.fillOval(this.getWidth() / 4, this.getHeight() / 4,
                                        this.getWidth() / 2, this.getWidth() / 2);
                            }
                            else if (map.getSymbol(finalI, finalJ) == Constants.DOT_X){
                                Graphics2D g2d = (Graphics2D) graphics;
                                g2d.setStroke(new BasicStroke(10));
                                g2d.setColor(Color.BLUE);
                                g2d.drawLine(this.getWidth() / 3, this.getHeight() / 3, (int)(this.getWidth() / 1.5),
                                        (int)(this.getHeight() / 1.5));
                                g2d.drawLine(this.getWidth() / 3, (int)(this.getHeight() / 1.5),
                                        (int)(this.getWidth() / 1.5), this.getHeight() / 3);
                            }
                        }
                    };

                    jButtons[i][j].addActionListener(e -> {
                        if (map.checkCell(finalI, finalJ) && map.checkMap()) {
                            map.setCell(finalI, finalJ, Constants.DOT_X);
                            if (checkWin(Constants.DOT_X)) {
                                win = "You win!";
                                new EndGameWindow(win);
                                end(jButtons);
                            }
                            if (map.checkMap() && win.equals("Draw"))
                                ai.aiTurn(map, jButtons);
                            if (checkWin(ai.getSymbol())) {
                                win = "You lose";
                                new EndGameWindow(win);
                                end(jButtons);
                            }
                            jButtons[finalI][finalJ].setEnabled(false);
                        }
                        repaint();
                        if (!map.checkMap() && win.equals("Draw"))
                            new EndGameWindow(win);
                    });
                    add(jButtons[i][j]);
                }
            setVisible(true);
        }
    }

    private static void end(JButton[][] jButtons){
        for (int i = 0; i < Constants.SIZE; i++)
            for (int j = 0; j < Constants.SIZE; j++)
                jButtons[i][j].setEnabled(false);
    }

    private static class WindowRunnable implements Runnable {
        @Override
        public void run() {
            new MyWindow();
        }
    }

    private static class EndGameWindow extends JFrame {
        public EndGameWindow(String string){
            setTitle("Game over");
            JLabel label = new JLabel(string);
            setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            JButton button = new JButton("Ok");
            button.addActionListener(e -> dispose());
            setSize(300, 100);
            setLocationRelativeTo(null);
            setResizable(false);
            add(button, BorderLayout.SOUTH);
            add(label, BorderLayout.CENTER);
            setVisible(true);
            setAlwaysOnTop(true);
        }
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new WindowRunnable());
    }

    private static boolean checkRows(char symbol){
        for (int i = 0; i < Constants.SIZE; i++){
            int rows = 0;
            for (int j = 0; j < Constants.SIZE; j++) {
                if (Game.map.getSymbol(i, j) == symbol)
                    rows++;
                else
                    break;
                if (rows == Constants.DOTS_TO_WIN)
                    return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(char symbol){
        for (int i = 0; i < Constants.SIZE; i++) {
            int columns = 0;
            for (int j = 0; j < Constants.SIZE; j++) {
                if (Game.map.getSymbol(j, i) == symbol)
                    columns++;
                else
                    break;
                if (columns == Constants.DOTS_TO_WIN)
                    return true;
            }
        }
        return false;
    }

    private static boolean checkPrimaryDiagonals(char symbol){
        int primary = 0;
        int primaryMinor = 0;
        int primaryMajor = 0;
        for (int i = 0; i < Constants.SIZE; i++){
            if (Game.map.getSymbol(i, i) == symbol)
                primary++;
            if (Game.map.getSymbol(i, i + 1) == symbol)
                primaryMajor++;
            if (Game.map.getSymbol(i, i - 1) == symbol)
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

    private static boolean checkWin(char symbol){
        if (checkRows(symbol))
            return true;
        if (checkColumns(symbol))
            return true;
        if (checkPrimaryDiagonals(symbol))
            return true;
        return checkSecondaryDiagonals(Game.map, symbol);
    }
}