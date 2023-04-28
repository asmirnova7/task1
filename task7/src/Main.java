import figure.rectangle.rectangle;
import figure.triangle.equilateralTriangle;
import figure.triangle.rectangularTriangle;
import figure.triangle.triangle;

import java.util.*;

import static java.lang.System.nanoTime;

public class Main {

    public  static final int MAX_SIZE = 1000000;

    public static void main(String[] args) {
        // 1
        task1();

        System.out.println();

        // 2
        task2();
    }

    public static void task2() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < MAX_SIZE; i++) {
            arrayList.add(UUID.randomUUID().toString());
            linkedList.add(UUID.randomUUID().toString());
        };

        addFirstElement(arrayList, UUID.randomUUID().toString());
        addFirstElement(linkedList, UUID.randomUUID().toString());

        addMiddleElement(arrayList, UUID.randomUUID().toString());
        addMiddleElement(linkedList, UUID.randomUUID().toString());

        addEndElement(arrayList, UUID.randomUUID().toString());
        addEndElement(linkedList, UUID.randomUUID().toString());

        removeFirstElement(arrayList);
        removeFirstElement(linkedList);

        removeMiddleElement(arrayList);
        removeMiddleElement(linkedList);

        removeEndElement(arrayList);
        removeEndElement(linkedList);

        getFistElement(arrayList);
        getFistElement(linkedList);

        getMiddleElement(arrayList);
        getMiddleElement(linkedList);

        getEndElement(arrayList);
        getEndElement(linkedList);

        runAllElements(arrayList);
        runAllElements(linkedList);
    }

    public static void addFirstElement(List<String> someList, String elem) {
        long before = System.nanoTime();
        someList.add(0, elem);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - добавление нового элемента в начало списка - " + count);
    }

    public static void addMiddleElement(List<String> someList, String elem) {
        long before = System.nanoTime();
        someList.add(someList.size()/2, elem);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - добавление нового элемента в середину списка - " + count);
    }

    public static void addEndElement(List<String> someList, String elem) {
        long before = System.nanoTime();
        someList.add(elem);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - добавление нового элемента в конец списка - " + count);
    }

    public static void removeFirstElement(List<String> someList) {
        long before = System.nanoTime();
        someList.remove(0);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - удаление элемента из начала списка - " + count);
    }

    public static void removeMiddleElement(List<String> someList) {
        long before = System.nanoTime();
        someList.remove(someList.size()/2);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - удаление элемента из середины списка - " + count);
    }

    public static void removeEndElement(List<String> someList) {
        long before = System.nanoTime();
        someList.remove(someList.size()-1);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - удаление элемента с конца списка - " + count);
    }

    public static void getFistElement(List<String> someList) {
        long before = System.nanoTime();
        String elem = someList.get(0);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - получение элемента из начала списка - " + count);
    }

    public static void getMiddleElement(List<String> someList) {
        long before = System.nanoTime();
        String elem = someList.get(someList.size()/2);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - получение элемента из середины списка - " + count);
    }

    public static void getEndElement(List<String> someList) {
        long before = System.nanoTime();
        String elem = someList.get(someList.size() - 1);
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - получение элемента с конца списка - " + count);
    }

    public static void runAllElements(List<String> someList) {
        long before = System.nanoTime();
        for (String elem: someList) {
           ;
        }
        long after = System.nanoTime();
        long count = after - before;

        System.out.println(someList.getClass().getSimpleName() + " - проход по всему списку  - " + count);
    }

    public static void task1() {
        ArrayList<rectangle> listRect = new ArrayList<>(4);
        listRect = initRect(listRect);

        listRect.sort(rectangle::compareTo);

        System.out.println("Прямоугольники:");
        for (rectangle rect: listRect) {
            System.out.println(rect.toString());
        }

        System.out.println("\n");

        ArrayList<triangle> listTriangle1 = new ArrayList<>(4);
        listTriangle1 = initTriangles(listTriangle1,4);

        listTriangle1.sort(triangle::compareTo);

        System.out.println("Треугольники (сортировка по периметру):");
        for (triangle triangleVal: listTriangle1) {
            System.out.println(triangleVal.toString());
        }

        System.out.println();

        ArrayList<triangle> listTriangle2 = new ArrayList<>(6);
        listTriangle2 = initTriangles(listTriangle2,6);

        triangle.triangleComparator comparator = new triangle.triangleComparator();
        Collections.sort(listTriangle2, comparator);

        System.out.println("Треугольники (сортировка по площади):");
        for (triangle triangleVal: listTriangle2) {
            System.out.println(triangleVal.toString());
        }

        System.out.println();

        Map<Double, rectangle> mapRect =  new TreeMap<>();
        for (rectangle rect: listRect) {
            mapRect.put(rect.getPerimeter(), rect);
        }

        System.out.println("TreeMap (прямоугольники:)");
        for (Map.Entry<Double, rectangle> entry : mapRect.entrySet()) {
            System.out.println("Периметр: " + entry.getKey() + " - " + entry.getValue().toString());
        }

    }

    public static ArrayList<rectangle> initRect(ArrayList<rectangle> someRects) {
        someRects.add(new rectangle(10,20));
        someRects.add(new rectangle(3,1));
        someRects.add(new rectangle(4,5));
        someRects.add(new rectangle(1,2));
        return  someRects;
    }

    public static ArrayList<triangle> initTriangles(ArrayList<triangle> someTriangles, int size) {
        int min = 1, max = 30;

        double a = 0;
        double b = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                a = Math.round((Math.random() * ((max - min) + 1)) + min);
                b = Math.round((Math.random() * ((max - min) + 1)) + min);
                someTriangles.add(new rectangularTriangle(a, b));
            }
            else {
                a = Math.round((Math.random() * ((max - min) + 1)) + min);
                someTriangles.add(new equilateralTriangle(a));
            }
        }
        return  someTriangles;
    }
}