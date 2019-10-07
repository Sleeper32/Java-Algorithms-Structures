package PriorityQueue;

public class PriorityQueueImpl implements PriorityQueue {

    private int[] array;
    private int size = 0;
    private int items = 0;

    public PriorityQueueImpl(int _size) {
        array = new int[_size];
        size = _size;
    }

    @Override
    public boolean isFull() {
        return (items == size);
    }

    @Override
    public boolean isEmpty() {
        return (items == 0);
    }

    @Override
    public void insert(int item) {
        int i;

        for (i = items; i > 0; i--) {
            if (item > array[i-1]) {
                array[i] = array[i-1];
            }
            else {
                break;
            }
        }

        array[i] = item;
        items++;
    }

    @Override
    public int remove() {
        return array[--items];
    }

    @Override
    public int peek() {
        return array[items-1];
    }
}
