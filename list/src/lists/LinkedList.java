package lists;

public class LinkedList extends List {

    @Override
    public void insert(String name, int age) {
        Link newLink = new Link(name, age);

        if (first != null) {
            newLink.next = first;
        }

        first = newLink;
    }
}
