package ru.GeekBrains.lesson5;

public class Person {
    String FIO;
    String post;
    String email;
    int telephone;
    int salary;
    int age;

    public Person(String FIO, String post, String email, int telephone, int salary, int age) {
        this.FIO = FIO;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return this.FIO + ", " + this.post + ", " + this.email + ", " + this.telephone + ", " +
                this.salary + ", " + this.age;
    }
}
