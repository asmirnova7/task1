import java.util.Enumeration;
import java.util.LinkedList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        //task1();

        task2();
    }

    public static void task2() {
        LinkList<String> linkList = new LinkList<>();

        int n = 100000;
        for (int i = 0; i < n; i++) {
            linkList.add(UUID.randomUUID().toString());
        }

        System.out.println("LinkList");

        long start = System.nanoTime();
        linkList.add(0,UUID.randomUUID().toString());
        long end = System.nanoTime();

        int curSize = linkList.getCurrentSize();

        System.out.println("добавление нового элемента в начало списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkList.add(n/2,UUID.randomUUID().toString());
        end = System.nanoTime();

        curSize = linkList.getCurrentSize();

        System.out.println("добавление нового элемента в середину списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkList.add(UUID.randomUUID().toString());
        end = System.nanoTime();

        curSize = linkList.getCurrentSize();

        System.out.println("добавление нового элемента в конец списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkList.remove(0);
        end = System.nanoTime();

        curSize = linkList.getCurrentSize();

        System.out.println("удаление элемента из начала списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkList.remove(n/2);
        end = System.nanoTime();

        curSize = linkList.getCurrentSize();

        System.out.println("удаление элемента из середины списка " + (end - start) + " размер списка " + curSize);


        start = System.nanoTime();
        linkList.remove( curSize - 1);
        end = System.nanoTime();

        curSize = linkList.getCurrentSize();
        System.out.println("удаление элемента с конца списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        LinkList.ListItem<String> elem =  linkList.get(0);
        end = System.nanoTime();
        System.out.println("получение элемента из начала списка " + (end - start));

        start = System.nanoTime();
        linkList.get(n/2);
        end = System.nanoTime();

        System.out.println("получение элемента из середины списка " + (end - start));

        start = System.nanoTime();
        linkList.get(curSize - 1);
        end = System.nanoTime();

        System.out.println("получение элемента с конца списка " + (end - start));

        start = System.nanoTime();
        for (String item: linkList) {
            ;
        }
        end = System.nanoTime();

        System.out.println("проход по всему списку " + (end - start));


        System.out.println("LinkedList");

        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            linkedList.add(UUID.randomUUID().toString());
        }

        start = System.nanoTime();
        linkedList.add(0,UUID.randomUUID().toString());
        end = System.nanoTime();

        curSize = linkedList.size();

        System.out.println("добавление нового элемента в начало списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkedList.add(n/2,UUID.randomUUID().toString());
        end = System.nanoTime();

        curSize = linkedList.size();

        System.out.println("добавление нового элемента в середину списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkedList.add(UUID.randomUUID().toString());
        end = System.nanoTime();

        curSize = linkedList.size();

        System.out.println("добавление нового элемента в конец списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkedList.remove(0);
        end = System.nanoTime();

        curSize = linkedList.size();

        System.out.println("удаление элемента из начала списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        linkedList.remove(n/2);
        end = System.nanoTime();

        curSize = linkedList.size();

        System.out.println("удаление элемента из середины списка " + (end - start) + " размер списка " + curSize);


        start = System.nanoTime();
        linkedList.remove( curSize - 1);
        end = System.nanoTime();

        curSize = linkedList.size();
        System.out.println("удаление элемента с конца списка " + (end - start) + " размер списка " + curSize);

        start = System.nanoTime();
        String element =  linkedList.get(0);
        end = System.nanoTime();
        System.out.println("получение элемента из начала списка " + (end - start));

        start = System.nanoTime();
        element =  linkedList.get(n/2);
        end = System.nanoTime();

        System.out.println("получение элемента из середины списка " + (end - start));

        start = System.nanoTime();
        element =  linkedList.get(curSize - 1);
        end = System.nanoTime();

        System.out.println("получение элемента с конца списка " + (end - start));

        start = System.nanoTime();
        for (String item: linkedList) {
            ;
        }
        end = System.nanoTime();

        System.out.println("проход по всему списку " + (end - start));


    }
    public static void task1() {
        LinkList<String> linkList = new LinkList<>();

        for (int i = 0; i < 5; i++) {
            linkList.add(UUID.randomUUID().toString());
        }

        LinkList.ListIterator iterator = linkList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        for (String elem: linkList) {
            System.out.println(elem.toString());
        }

        System.out.println();

        linkList.forEach(System.out::println);
    }
}