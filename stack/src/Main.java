import Queue.QueueImpl;
import Stack.StackImpl;

public class Main {
    public static void main(String[] args) {
        //  StackImpl class testing
        StackImpl stack = new StackImpl(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        //  Queue class testing
        QueueImpl queue = new QueueImpl(10);

        for (int i = 1; i <= 10; i++) {
            queue.insert(i);
            System.out.println("inserted: " + i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
