package Stack;

public class StackImpl implements Stack {
    private int[] array;
    private int size;
    private int top;

    public StackImpl(int _size) {
        array = new int[_size];
        size = _size;
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() {
        return (top == size - 1);
    }

    @Override
    public void push(int item) {
        array[++top] = item;
    }

    @Override
    public int pop() {
        return array[top--];
    }

    @Override
    public int peek() {
        return array[top];
    }
}
