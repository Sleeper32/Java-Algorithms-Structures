package lists;

interface IIterator {

    void reset();

    void nextLink();

    Link getCurrent();

    boolean atEnd();

    void insertAfter(String name, int age);

    void insertBefore(String name, int age);

    String deleteCurrent();
}
