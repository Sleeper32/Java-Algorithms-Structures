import lists.DSideLinkedList;
import lists.Iterator;
import lists.LinkedList;
import lists.List;

public class LinkApp {
    public static void main(String[] argv) {
        //  test LinkedList
        testLinkedList();

        // test DSideLinkedList
        testDSideLinkedList();

        // test Iterator
        testIterator();
    }

    static void testLinkedList() {
        System.out.println("------ Test LinkedList ------");

        List list = new LinkedList();

        list.insert("A", 12);
        list.insert("B", 32);
        list.insert("C", 2);
        list.insert("D", 15);
        list.insert("E", 7);
        list.insert("F", 22);
        list.insert("G", 77);
        list.display();

        System.out.println();

        list.delete();
        list.display();

        System.out.println();

        list.delete("D");
        list.display();

        System.out.println();

        System.out.println(list.find("E"));
        System.out.println();

        System.out.println(list.find("D"));
        System.out.println();
    }

    static void testDSideLinkedList() {
        System.out.println("------ Test DSideLinkedList ------");

        DSideLinkedList dlist = new DSideLinkedList();

        dlist.insert("AA",11);
        dlist.insert("BB",22);
        dlist.insert("DD",33);
        dlist.display();

        System.out.println();

        dlist.insertLast("EE",44);
        dlist.insertLast("FF",55);
        dlist.display();

        System.out.println();

        dlist.delete("EE");
        dlist.display();

        System.out.println();
    }

    static void testIterator() {
        System.out.println("------ Test Iterator ------");

        List list = new LinkedList();
        Iterator iterator = new Iterator(list);

        System.out.println(iterator.getCurrent());

        iterator.nextLink();
        System.out.println(iterator.getCurrent());

        System.out.println(iterator.atEnd());

        iterator.deleteCurrent();
        System.out.println(iterator.getCurrent());

        iterator.reset();
        System.out.println(iterator.getCurrent());

        System.out.println();

        iterator.insertAfter("AA", 11);
        iterator.insertAfter("BB", 22);
        iterator.insertAfter("CC", 33);
        iterator.insertAfter("DD", 44);
        iterator.insertAfter("EE", 55);
        list.display();

        System.out.println();

        iterator.reset();
        iterator.nextLink();
        iterator.nextLink();
        iterator.nextLink();
        iterator.insertBefore("XX", 0);
        iterator.insertBefore("ZZ", 0);
        list.display();
    }
}
