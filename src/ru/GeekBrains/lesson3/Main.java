package ru.GeekBrains.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Загадано слово. Какое?\nВведите ответ: ");
        String word = words[(int)(Math.random() * (words.length + 1))];
        while(true) {
            String answer = reader.readLine();
            if (word.equals(answer)) {
                System.out.println("Правильно!");
                break;
            }
            StringBuilder out = new StringBuilder("###############");
            for (int j = 0; j < word.length() && j < answer.length(); j++)
                if (word.charAt(j) == answer.charAt(j))
                    out.setCharAt(j, word.charAt(j));
            System.out.println(out);
        }
    }
}
