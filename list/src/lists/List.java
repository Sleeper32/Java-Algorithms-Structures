package lists;

abstract public class List {
    Link first;

    public List() {
    }

    abstract public void insert(String name, int age);

    public Link delete() {
        Link current = first;

        if (current != null) {
            first = current.next;
        }

        return current;
    }

    public Link delete(String name) {
        Link current = first;
        Link prev = first;

        while (current != null) {
            if (current.name.equals(name) == true) {
                break;
            }

            prev = current;
            current = current.next;
        }

        prev.next = current.next;

        return current;
    }

    public Link find(String name) {
        Link current = first;

        while (current != null) {
            if (current.name.equals(name) == true) {
                break;
            }

            current = current.next;
        }

        return current;
    }

    public void display() {
        Link current = first;

        while (current != null) {
            System.out.println(current);

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    Link getFirst() {
        return first;
    }

    void setFirst(Link link) {
        first = link;
    }
}
