package ru.GeekBrains.lesson6;

import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        int cats = 0, dogs = 0;
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Barsik", 3, "Grey", 200, 2);
        animals[1] = new Cat("Stepan", 5, "Black", 300, 1);
        animals[2] = new Dog("Rex", 6, "Brown", 600, 10);
        animals[3] = new Dog("Sharik", 2, "Brown", 400, 7);

        for (Animal animal : animals){
            if (animal instanceof Cat)
                cats++;
            if (animal instanceof Dog)
                dogs++;
            System.out.println(animal);
            double distance = Math.random() * 1.5;
            if (animal.jump(distance))
                System.out.println(animal.name + " was able to jump");
            else
                System.out.println(animal.name + " couldn't jump");
            distance = Math.random() * 500;
            if (animal.run(distance))
                System.out.println(animal.name + " ran " + Math.ceil(distance * 1000) / 1000 + "m");
            else
                System.out.println(animal.name + " didn't run " + Math.ceil(distance * 1000) / 1000 + "m");
            distance = Math.random() * 2;
            if (animal.swim(distance))
                System.out.println(animal.name + " swam " + Math.ceil(distance * 1000) / 1000 + "m");
            else
                System.out.println(animal.name + " didn't swim " + Math.ceil(distance * 1000) / 1000 + "m");
        }
        System.out.println("\nDogs: " + dogs + ", cats: " + cats);
    }
}
