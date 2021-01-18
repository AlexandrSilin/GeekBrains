package ru.GeekBrains.lesson7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Barsik", 0);
        cats[1] = new Cat("Stepan", 5);
        cats[2] = new Cat("Masha", 5);
        cats[3] = new Cat("Markiz", 7);
        Plate plate = new Plate(15);
        for (Cat cat : cats){
            if (!cat.isSatiety()) {
                cat.eat(plate);
                if (plate.getFood() < cat.getAppetite()) {
                    plate.fulfillPlate(cat.getAppetite() - plate.getFood());
                    cat.eat(plate);
                }
            }
            else
                System.out.println(cat.getName() + " is not hungry.");
            plate.info();
        }
    }
}
