package ru.GeekBrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGame extends JFrame {
    public EndGame(String string){
        setTitle("Game over");
        JTextField field = new JTextField(string);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        JButton button = new JButton("Ok");
        button.addActionListener(e -> dispose());
        setSize(300, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        add(button, BorderLayout.SOUTH);
        add(field, BorderLayout.CENTER);
        setVisible(true);
    }
}
