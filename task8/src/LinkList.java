import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkList<E> implements Iterable<E> {
    static ListItem head;
    static ListItem current;

    static int currentSize;

    static class ListItem<E> {

        E data;
        ListItem next;

        ListItem(E d) {
            data = d;
            next = null;
            currentSize++;
        }

        @Override
        public String toString() {
            return current.data.toString();
        }
    }

   // ListIterator<E> iterator = new ListIterator<E>();
    static class ListIterator<E> implements Iterator<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < currentSize && current != null;
        }

        @Override
        public E next() {
            ListItem<E> item = null;
            if (currentIndex == 0)
            {
                item = current = head;
            }
            else {
                item = current.next;
            }
            currentIndex++;
            return item.data;
        }
    }

    @Override
    public ListIterator<E> iterator() {
        return new ListIterator<E>();
    }

    public int getCurrentSize() {
        return currentSize - 1;
    }
    public void add(E data) {
        ListItem newItem = new ListItem(data);

        if (head == null) {
            head = newItem;
        }
        else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newItem;
        }
    }

    public void add(int index, E data) {
        ListItem newItem = new ListItem(data);

        current = head;
        ListItem prev = head;

        if (index == 0) {
            newItem.next = head;
            head = newItem;
            return;
        }

        while (current.next != null && --index > 0) {
            prev = current;
            current = current.next;
        }

        prev.next = newItem;

        newItem.next = current;
    }

    public ListItem get(int index) {
        int count = 0;
        current = head;

        while (count != index) {
            current = current.next;
            count++;
        }
        return current;
    }

    public void set(int index, E data) {
        int count = 0;
        if (index >= 0 && index <= currentSize) {
            current = head;
            while (count != index) {
                current.data = data;
                count++;
            }
        }
    }

    public void remove(int index) {
        ListItem currNode = head, prev = null;

        if (index == 0 && currNode != null) {
            prev = head = currNode.next;
        }

        int counter = 0;

        while (current != null) {

            if (counter == index) {

                prev.next = currNode.next;
                currentSize--;
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(
                    index + " position element not found");
        }
    }
    public int size() {
        return this.currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void clear() {
        head = null;
    }
}
