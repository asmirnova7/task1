import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Задание 1
        Student[] arrStudent = new Student[3];
        String[] arrNames = {"Мария Погребняк", "Николай Сидоров", "Людмила Чурсина"};

        System.out.println("Наши студенты:");
        for (int i = 0; i < arrStudent.length; i++) {
            arrStudent[i] = new Student(i+1, arrNames[i], BigDecimal.valueOf(25000));
            System.out.println(arrStudent[i].toString());
        }

        // Задание 2
        boolean printArrays = true; // выводить массивы

        String[] arr1 = new String[1000000];

        if (printArrays) {
            System.out.println("\nМассив arr1:");
        }

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = UUID.randomUUID().toString();
            if (printArrays) {
                System.out.println(arr1[i]);
            }
        }

        String[] arr2 = arr1.clone();

        Sortable sort = new Sortable();

        long timeStart1 = System.currentTimeMillis();
        sort.quickSort(arr1, 0, arr1.length-1);
        long timeEnd1 = System.currentTimeMillis();

        if (printArrays) {
            System.out.println("\nСортировка массива arr1 методом quick sort");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);
            }
        }

        // восстанавливаем неотсортированный массив
        arr1 = arr2.clone();

        long timeStart2 = System.currentTimeMillis();
        sort.arraySort(arr1);
        long timeEnd2 = System.currentTimeMillis();

        if (printArrays) {
            System.out.println("\nСортировка массива arr1 методом Arrays.sort");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);
            }
        }

        // восстанавливаем неотсортированный массив
        arr1 = arr2.clone();

        LocalDateTime dateStart1 = LocalDateTime.now();
        sort.quickSort(arr1, 0, arr1.length-1);
        LocalDateTime dateEnd1 = LocalDateTime.now();

        if (printArrays) {
            System.out.println("\nСортировка массива arr1 методом quick sort");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr2[i]);
            }
        }

        // восстанавливаем неотсортированный массив
        arr1 = arr2.clone();

        LocalDateTime dateStart2 = LocalDateTime.now();
        sort.arraySort(arr1);
        LocalDateTime dateEnd2 = LocalDateTime.now();

        if (printArrays) {
            System.out.println("\nСортировка массива arr1 методом Arrays.sort");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);
            }
        }
        System.out.println("\nИзмерения с помощью System.currentTimeMillis()");
        System.out.println("Время сортировки arr1 методом quick sort, мс.: " + (timeEnd1 - timeStart1));
        System.out.println("Время сортировки arr1 методом Arrays.sort, мс.: " + (timeEnd2 - timeStart2));

        System.out.println("\nИзмерения с помощью Duration.between()");
        System.out.println("Время сортировки arr1 методом quick sort, мс.: " + Duration.between(dateStart1,dateEnd1).toMillis());
        System.out.println("Время сортировки arr1 методом Arrays.sort, мс.: " + Duration.between(dateStart2,dateEnd2).toMillis());
    }
}