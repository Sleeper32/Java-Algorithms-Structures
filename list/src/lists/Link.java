package lists;

class Link {

    String name;
    int age;

    Link next;

    public Link(String _name, int _age) {
        name = _name;
        age = _age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", name, age);
    }
}

