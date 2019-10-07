package Queue;

public interface Queue {

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public void insert(int item);

    public int remove();

    public int peek();

}
