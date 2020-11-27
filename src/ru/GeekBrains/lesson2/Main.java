public class Main {
    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] arr2 = fulfillArray(8);
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr4 = getArray(10);
        int[] checkArr = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] pushArr = {1, 2, 3, 4, 5};
        
        System.out.println("1. Исходный массив: ");
        printArray(arr1);
        System.out.println("\n0 -> 1, 1 -> 0:");
        printArray(changeArray(arr1));
        
        System.out.println("\n\n2. Заполняем массив значениями:");
        printArray(arr2);

        System.out.println("\n\n3. Исходный массив: ");
        printArray(arr3);
        System.out.println("\nЧисла меньше 6 умножаем на 2:");
        printArray(multiplyValues(arr3));

        System.out.println("\n\n4. Двумерный массив (диагональ = 1):");
        printArray(arr4);

        System.out.println("\n5. Поиск максимума и минимума в массиве" + "\nИсходный массив:");
        printArray(arr3);
        int[] maxMin = findMaxMin(arr3);
        System.out.println("\nМаксимум = " + maxMin[0] + " " + ", минимум = " + maxMin[1]);

        System.out.println("\n6. true, если в массиве есть место, в котором сумма левой и правой части массива равны"
                + "\nИсходный массив:");
        printArray(checkArr);
        System.out.println("\nОтвет: " + checkBalance(checkArr));
        System.out.println("Исходный массив:");
        printArray(arr3);
        System.out.println("\nОтвет: " + checkBalance(arr3));

        System.out.println("7. Сдвиг элементов на n позиций\nИсходный массив:");
        printArray(pushArr);
        System.out.println("\nРезультат (свиг на 2 позиции влево):");
        printArray(pushValues(pushArr, 2));
        System.out.println("\nРезультат (свиг на 2 позиции вправо):");
        printArray(pushValues(pushArr, -4));
    }

    public static void printArray(int[] arr){
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void printArray(int[][] arr){
        for (int[] i : arr) {
            for (int Int : i)
                System.out.print(Int + " ");
            System.out.println();
        }
    }

    public static int[] changeArray(int[] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 1)
                arr[i] = 0;
            else
                arr[i] = 1;
        return arr;
    }

    public static int[] fulfillArray(int size){
        int [] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = i * 3;
        return arr;
    }

    public static int[] multiplyValues(int[] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6)
                arr[i] *= 2;
        return arr;
    }

    public static int[][] getArray(int size){
        int [][] arr = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (i == j)
                    arr[i][j] = 1;
                else
                    arr[i][j] = (int) (Math.random() * 100);
        return arr;
    }

    public static int[] findMaxMin(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            if (max < i)
                max = i;
            if (min > i)
                min = i;
        }
        return new int[] {min, max};
    }

    public static boolean checkBalance(int[] arr){
        int left = 0;
        int right = 0;
        for (int count = 0; count < arr.length; count++) {
            for (int i = 0; i < count; i++) {
                left += arr[i];
                for (int j = i; j < arr.length; j++)
                    right += arr[j];
                if (left == right)
                    return true;
                right = 0;
            }

        }
        return false;
    }

    public static int [] pushValues(int[] arr, int n){
        if (n > 0)
            for (int count = 0; count < n; count++) {
                int tail = arr[0];
                for (int i = 0; i < arr.length - 1; i++)
                    arr[i] = arr[i + 1];
                arr[arr.length - 1] = tail;
            }
        else {
            n *= -1;
            for (int count = 0; count < n; count++) {
                int head = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--)
                    arr[i] = arr[i - 1];
                arr[0] = head;
            }
        }
        return arr;
    }
}