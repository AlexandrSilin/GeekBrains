package ru.GeekBrains.lesson6;

public class Cat extends Animal{
    private final int runDistance;
    private final int jumpDistance = 2;
    private final int swimDistance;

    public Cat(String name, int age, String color, int runDistance, int swimDistance) {
        super(name, age, color);
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
    }

    @Override
    public boolean run(int distance) {
        return distance <= runDistance;
    }

    @Override
    public boolean swim(int distance) {
        return distance <= swimDistance;
    }

    @Override
    public boolean jump(int distance) {
        return distance <= jumpDistance;
    }

    @Override
    public String toString(){
        return "\nCat:\nName: " + name + ", color: " + color + ", age: " + age;
    }
}
