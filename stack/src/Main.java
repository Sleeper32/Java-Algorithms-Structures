import PriorityQueue.PriorityQueueImpl;
import Queue.QueueImpl;
import Stack.StackImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //  StackImpl class testing
        System.out.println("------ Stack ------");

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

        System.out.println();

        //  Queue class testing
        System.out.println("------ Queue ------");

        QueueImpl queue = new QueueImpl(10);

        queue.insert(5);
        queue.insert(6);
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        for (int i = 1; i <= 10; i++) {
            queue.insert(i);
            System.out.println("inserted: " + i);
        }

        System.out.println("peek: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        System.out.println();

        // PriorityQueue class testing
        System.out.println("------ PriorityQueue ------");
        PriorityQueueImpl priorityQueue = new PriorityQueueImpl(10);
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            int item = random.nextInt(10);

            priorityQueue.insert(item);
            System.out.println("inserted: " + item);
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
