package ru.GeekBrains.lesson6;

public class Dog extends Animal{
    private final int runDistance;
    private final double jumpDistance = 0.5;
    private final int swimDistance;

    public Dog(String name, int age, String color, int runDistance, int swimDistance) {
        super(name, age, color);
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
    }

    @Override
    public boolean run(double distance) {
        return distance <= runDistance;
    }

    @Override
    public boolean swim(double distance) {
        return distance <= swimDistance;
    }

    @Override
    public boolean jump(double distance) {
        return distance <= jumpDistance;
    }

    @Override
    public String toString(){
        return "\nDog:\nName: " + name + ", color: " + color + ", age: " + age;
    }
}
