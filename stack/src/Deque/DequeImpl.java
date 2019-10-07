package Deque;

public class DequeImpl implements Deque {

    private int size;
    private int[] array;
    private int head = 0;
    private int tail = -1;
    private int items = 0;

    public DequeImpl(int _size) {
        size = _size;
        array = new int[_size];
    }

    @Override
    public void pushTail(int item) {
        if (tail == size-1) {
            tail = -1;
        }

        array[++tail] = item;
        items++;
    }

    @Override
    public void pushHead(int item) {
        if(head == 0) {
            head = size;
        }

        array[--head] = item;
        items++;
    }

    @Override
    public int popTail() {
        int item = array[tail];

        tail--;
        if (tail == -1) {
            tail = size-1;
        }

        items--;

        return item;
    }

    @Override
    public int popHead() {
        int item = array[head];

        head++;
        if (head == size) {
            head = 0;
        }

        items--;

        return item;
    }

    @Override
    public boolean isEmpty() {
        return (items == 0);
    }

    @Override
    public boolean isFull() {
        return (items == size);
    }

    @Override
    public void clear() {
        tail = -1;
        head = 0;
        size = 0;
        items = 0;
    }
}
