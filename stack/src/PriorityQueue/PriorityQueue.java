package PriorityQueue;

public interface PriorityQueue {

    public boolean isFull();

    public boolean isEmpty();

    public void insert(int item);

    public int remove();

    public int peek();
}
