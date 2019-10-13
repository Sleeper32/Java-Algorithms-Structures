package lists;

public class Iterator implements IIterator {

    private List list;

    private Link current;
    private Link previous;

    public Iterator(List _list) {
        list = _list;

        current = list.getFirst();
        previous = null;
    }

    @Override
    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    @Override
    public void nextLink() {
        if (current == null) {
            return;
        }

        previous = current;
        current = current.next;
    }

    @Override
    public Link getCurrent() {
        return current;
    }

    @Override
    public boolean atEnd() {
        return (current == null ? true : current.next == null);
    }

    @Override
    public void insertAfter(String name, int age) {
        Link newLink = new Link(name, age);

        if (current == null) {
            list.setFirst(newLink);
        }
        else {
            previous = current;

            newLink.next = current.next;
            current.next = newLink;
        }

        current = newLink;
    }

    @Override
    public void insertBefore(String name, int age) {
        Link newLink = new Link(name, age);

        if (current == null) {
            list.setFirst(newLink);
        }
        else {
            previous.next = newLink;
            newLink.next = current;
        }

        current = newLink;
    }

    @Override
    public String deleteCurrent() {
        String name = null;

        if (current == null) {
            return null;
        }

        name = current.name;

        if (atEnd() != true) {
            previous.next = current.next;
        }

        return name;
    }
}
