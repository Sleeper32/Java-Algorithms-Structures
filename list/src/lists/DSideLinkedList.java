package lists;

public class DSideLinkedList extends List {

    private Link last;

    @Override
    public void insert(String name, int age) {
        Link newLink = new Link(name, age);

        if (first == null) {
            last = newLink;
        }
        else {
            newLink.next = first;
        }

        first = newLink;
    }

    public void insertLast(String name, int age) {
        Link newLink = new Link(name, age);

        if (last == null) {
            first = newLink;
        }
        else {
            last.next = newLink;
        }

        last = newLink;
    }
}
