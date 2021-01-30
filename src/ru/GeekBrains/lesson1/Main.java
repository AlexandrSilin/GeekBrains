package ru.GeekBrains.lesson1;

public class Main {
    public static void main(String[] args) {
        byte byteValue = 15;
        short shortValue = 2012;
        int intValue = 58942;
        long longValue = 21474836476547L;
        float floatValue = 56438.843f;
        double doubleValue = 3495629.829365986d;
        char charValue = 'b';
        boolean booleanValue = true;

        System.out.println("Byte value: " + byteValue + "\nShort value: " + shortValue + "\nInt value: " + intValue
            + "\nLong value: " + longValue + "\nFloat value: " + floatValue + "\nDouble value: " + doubleValue
            + "\nChar value: " + charValue + "\nBoolean value: " + booleanValue + "\n" + byteValue + " * "
            + "(" + shortValue + " + " + "(" + doubleValue + " / " + floatValue + ")) = "
            + solveExpression(byteValue,shortValue,doubleValue,floatValue) + "\nЛежит ли сумма в диапазоне [10, 20]: "
            + checkSum(shortValue, intValue) + "\nПоложительное ли число " + intValue + ": "
            + checkValue(intValue) + "\nОтрицательное ли число " + shortValue + ": " + checkNegativeNumber(shortValue)
            + "\n" + welcomeUsername("Илья") + "\nВисокосный ли год " + shortValue + ": " + checkYear(shortValue));
    }

    //Метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – входные параметры этого метода
    public static double solveExpression(int a, int b, double c, float d){
        return a * (b + (c / d));
    }

    //Метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false
    public static boolean checkSum(int a, int b){
        return a + b < 21 && a + b > 9;
    }

    //Метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    // положительное ли число передали, или отрицательное
    public static String checkValue(int value){
        return value > -1 ? "Число положительное" : "Число отрицателное";
    }

    //Метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное
    public static boolean checkNegativeNumber(int value){
        return value < 0;
    }

    //Метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    public static String welcomeUsername(String name){
        return "Привет, " + name + "!";
    }

    //Метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static String checkYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return "Год високосный";
        return "Год не является високосным";
    }
}
