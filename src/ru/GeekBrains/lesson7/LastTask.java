package ru.GeekBrains.lesson7;

public class LastTask {
    public static String getString(String string){
        return string;
    }

    public static void main(String[] args) {
        String string = getString("I like Java!!!");
        System.out.println(string.charAt(string.length() - 1));
        System.out.println(string.endsWith("!!!"));
        System.out.println(string.startsWith("I like"));
        System.out.println(string.contains("Java"));
        System.out.println(string.indexOf("Java"));
        System.out.println(string.replaceAll("a", "o"));
        System.out.println(string.toUpperCase());
        System.out.println(string.toLowerCase());
        String del = "Java";
        System.out.println(string.substring(0, string.indexOf(del)) +
                string.substring(string.lastIndexOf(del) + del.length()));
    }
}
