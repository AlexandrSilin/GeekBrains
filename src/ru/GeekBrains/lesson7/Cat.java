package ru.GeekBrains.lesson7;

public class Cat {
    private final String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.satiety = appetite == 0;
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isSatiety(){
        return this.satiety;
    }

    public void eat(Plate plate) {
        System.out.println(this.name + " is eating...");
        if (plate.decreaseFood(getAppetite())) {
            appetite = 0;
            satiety = true;
        }
        else
            System.out.println("There is not enough food in the plate. " + this.name + " is still hungry");
    }

    public String getName(){
        return this.name;
    }

    public int getAppetite() {
        return appetite;
    }
}
