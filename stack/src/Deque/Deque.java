package Deque;

public interface Deque {

    public void pushTail(int item);

    public void pushHead(int item);

    public int popTail();

    public int popHead();

    public boolean isEmpty();

    public boolean isFull();

    public void clear();
}
