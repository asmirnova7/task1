import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Числа от 1 до 100, которые делятся на 3 без остатка
        task2_1();

        // метод, принимающий на вход натуральные числа n и k и выводящий
        // в консоль первые n натуральных чисел, делящихся на k без остатка
        task2_2();

        // метод  для нахождения в массиве чисел позиции элемента
        // с наибольшим / наименьшим значением
        task2_3();

        // метод, принимающий на вход
        // вещественное число x и натуральное число n и возвращающий сумму
        task2_4();

        //  метод, принимающий на вход два отсортированных массива чисел
        //  и возвращающий новый отсортированный массив как результат слияния
        task2_5();
    }

    private static int [] mergeArray(int [] arrayA, int [] arrayB) {

        int [] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length){
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayC;
    }

    public static void task2_5() {
        int[] arrayA = new int[] {1, 4, 7, 10, 15, 20};
        int[] arrayB = new int [] {3, 8, 17, 18, 22};

        int[] arrayC = mergeArray(arrayA, arrayB);

        System.out.println("Массив А:");
        for(int a : arrayA){
            System.out.println(a);
        }

        System.out.println("Массив B:");
        for(int b : arrayB){
            System.out.println(b);
        }

        System.out.println("Массив C:");
        for(int c : arrayC){
            System.out.println(c);
        }
    }

    private static int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * getFactorial(f - 1);
        }
    }

    public static void task2_4() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размерность массива:");
        int n = input.nextInt();
        int arrayFact[] = new int[n];
        double arrayDeg[] = new double[n];

        System.out.println("Введите " + n + " натуральных чисел:");
        for (int i = 0; i < n; i++) {
            arrayFact[i] = getFactorial(input.nextInt());
        }

        System.out.println("Введите вещественное число x:");
        double x = input.nextDouble();

        for (int i = 0; i < n; i++) {
            arrayDeg[i] = Math.pow(x,i);
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arrayDeg[i] / arrayFact[i];
        }

        System.out.println("Массив факториалов числа " + n);
        for (int i = 0; i < n; i++) {
            System.out.println(arrayFact[i]);
        }

        System.out.println("Массив степеней числа " + x);
        for (int i = 0; i < n; i++) {
            System.out.println(arrayDeg[i]);
        }

        System.out.println("Сумма массива степеней числа " + x + ", деленных на факториалы числа " + n + " = " + sum);
        System.out.println("Math.exp(" + x + ") = " + Math.exp(x));
    }
    public static void task2_3() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Введите элементы массива:");
        /* Пройдёмся по всему массиву, заполняя его */
        int min = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
            if (i == 0) {
                min = array[0];
                max = array[0];
            }
            else
            {
                if (array[i] < min) {
                    min = array[i];
                }

                if (array[i] > max) {
                    max = array[i];
                }
            }
        }

        System.out.println(String.format("min = %s, max = %s", min, max));
    }

    public static  void task2_2() {
        System.out.println("Введите натуральные числа n и k:");
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int k = console.nextInt();
        int sum = 0;
        System.out.println("Первые " + n + " натуральных чисел, делящихся на " + k + " без остатка:");
        int i = 1;
        while ((sum <= n) &&  (i <= (n * k))) {
            if (i % k == 0) {
                System.out.println(i);
                sum++;
            }
            i++;
        }
    }

    public static void task2_1() {
        System.out.println("Числа от 1 до 100, которые делятся на 3 без остатка:");
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0) {
               System.out.println(i);
            }
        }

    }
}