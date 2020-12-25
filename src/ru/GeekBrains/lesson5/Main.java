package ru.GeekBrains.lesson5;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("Ivanov Ivan Ivanovich", "Engineer", "ivivan@mailbox.com",
                892312312, 30000, 30);
        people[1] = new Person("Vinogradov Denis Maksimovich", "Deputy director", "denis@mailbox.com",
                891698248, 80000, 46);
        people[2] = new Person("Solovieva Maria Alekseevna", "Accountants", "masha@mailbox.com",
                892315175, 55000, 34);
        people[3] = new Person("Goncharova Irina Vladimirovna", "Trainee", "ira@mailbox.com",
                892887232, 20000, 21);
        people[4] = new Person("Komarov Vasiliy Romanovich", "Director", "vasya@mailbox.com",
                892759359, 100000, 48);
        for (Person person : people)
            if (person.getAge() > 40)
                System.out.println(person.toString());
    }
}
