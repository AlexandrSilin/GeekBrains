package ru.GeekBrains.lesson7;

public class Plate {

    private int food;
    private final int capacityPlate = 15;
    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Amount food: " + food;
    }

    public int getFood() {
        return food;
    }

    public void fulfillPlate(int food) {
        if (this.food + food > capacityPlate)
            this.food = capacityPlate;
        else
            this.food += food;
    }

    public boolean decreaseFood(int appetite) {
        if (appetite > this.food)
            return false;
        this.food -= appetite;
        return true;
    }
}
