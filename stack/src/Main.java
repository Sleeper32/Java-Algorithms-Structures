import Deque.Deque;
import Deque.DequeImpl;
import PriorityQueue.PriorityQueueImpl;
import Queue.QueueImpl;
import Stack.Stack;
import Stack.StackImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
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

        System.out.println();

        // Reverse string
        System.out.println("------ Reverse string ------");

        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        String inputString;

        do {
            inputString = bufferedReader.readLine();
            System.out.println(reverseString(inputString));
        }
        while(!inputString.equals(""));

        System.out.println();

        // Deque class test
        System.out.println("------ Deque ------");

        DequeImpl deque = new DequeImpl(10);

        while (!deque.isFull()) {
            int item = random.nextInt(10);

            if(item % 2 == 0) {
                deque.pushHead(item);

                System.out.println("pushHead: " + item);
            }
            else {
                deque.pushTail(item);

                System.out.println("pushTail: " + item);
            }
        }

        System.out.println();

        int selector = 1;
        int item = 0;

        while (!deque.isEmpty()) {
            if (selector == 1) {
                System.out.println("popHead: " + deque.popHead());
            }
            else {
                System.out.println("popTail: " + deque.popTail());
            }

            selector *= -1;
        }
    }

    public static String reverseString(String string) {
        StackImpl chars = new StackImpl(string.length());
        String revString = "";

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            chars.push(ch);
        }

        while (!chars.isEmpty()) {
            revString += (char) chars.pop();
        }

        return revString;
    }
}
