package Queue;

public class QueueImpl implements Queue {
    private int size;
    private int[] array;
    private int items = 0;
    private int head = 0;
    private int tail = -1;

    public QueueImpl(int _size) {
        array = new int[_size];
        size = _size;
    }

    @Override
    public boolean isEmpty() {
        return (items == 0);
    }

    @Override
    public boolean isFull() {
        return (items == size - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int item) {
        if (items == size-1) {
            tail = -1;
        }

        array[++tail] = item;
        items++;
    }

    @Override
    public int remove() {
        int item = array[head++];

        if (head == size) {
            head = 0;
        }

        items--;

        return item;
    }

    @Override
    public int peek() {
        return array[head];
    }
}
