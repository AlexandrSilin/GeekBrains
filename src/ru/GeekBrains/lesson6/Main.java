package ru.GeekBrains.lesson6;

public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cat("Barsik", 3, "Grey", 200, 2);
        Animal cat2 = new Cat("Stepan", 5, "Black", 300, 1);
        Animal dog1 = new Dog("Rex", 6, "Brown", 600, 10);
        Animal dog2 = new Dog("Sharik", 2, "Brown", 400, 7);

        System.out.println(cat1);
        if (cat1.swim(5))
            System.out.println(cat1.name + " swam 5m");
        else
            System.out.println(cat1.name + " didn't swim 5m");
        if (cat1.run(150))
            System.out.println(cat1.name + " ran 150m");
        else
            System.out.println(cat1.name + " didn't run 150m");

        System.out.println(cat2);
        if (cat2.jump(1))
            System.out.println(cat2.name + " was able to jump");
        else
            System.out.println(cat2.name + " couldn't jump");

        System.out.println(dog1);
        if (dog1.jump(1))
            System.out.println(dog1.name + " was able to jump");
        else
            System.out.println(dog1.name + " couldn't jump");

        System.out.println(dog2);
        if (dog2.swim(50))
            System.out.println(dog2.name + " swam 50m");
        else
            System.out.println(dog2.name + " didn't swim 50m");
    }
}
