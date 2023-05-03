import java.util.Enumeration;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        LinkList<String> linkList = new LinkList<>();

        for (int i = 0; i < 2; i++) {
            linkList.add(UUID.randomUUID().toString());
        }

        LinkList.ListIterator iterator = linkList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().data);
        }

        for (String elem: linkList) {
            System.out.println(elem.toString());
        }
    }
}