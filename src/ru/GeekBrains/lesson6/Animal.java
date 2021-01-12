package ru.GeekBrains.lesson6;

public abstract class Animal {
    protected final String name;
    protected final int age;
    protected final String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public abstract boolean run(double distance);

    public abstract boolean swim(double distance);

    public abstract boolean jump(double distance);
}
