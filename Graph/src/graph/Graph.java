package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
    private int capacity;
    private int size;

    private Point[] points;
    private int[][] linkMatrix;

    private int lengths[];
    private int paths[];

    public Graph(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        points = new Point[capacity];
        linkMatrix = new int[capacity][capacity];
    }

    public void addPoint(Point point) {
        point.setKey(size);
        points[size] = point;
        size++;
    }

    public Point getPointByKey(int key) {
        for (int i = 0; i < size; i++) {
            if (points[i].getKey() == key) return points[i];
        }

        return null;
    }

    public void addLink(Point p1, Point p2, int length) {
        int key1 = p1.getKey();
        int key2 = p2.getKey();

        linkMatrix[key1][key2] = length;
        linkMatrix[key2][key1] = length;
    }

    public void printMinPath() {
        calcMinPathsAndLengths();

        Stack<Point> path = new Stack<Point>();
        int key = size-1;

        while(key != 0) {
            path.push(getPointByKey(key));
            key = paths[key];
        }
        path.push(getPointByKey(key));

        System.out.print("Min path from " + getPointByKey(0) + " to " + getPointByKey(size-1) + ": ");
        while(!path.empty()) {
            System.out.print(path.pop() + " ");
        }
        System.out.println();
    }

    public void printMinLength() {
        calcMinPathsAndLengths();

        System.out.println("Min length: " + lengths[size-1]);
    }

    private void calcMinPathsAndLengths() {
        Deque<Point> deque = new LinkedList<Point>();
        boolean[] visited = new boolean[size];

        paths = new int[size];
        lengths = new int[size];
        for (int i = 1; i < size; i++) {
            lengths[i] = Integer.MAX_VALUE;
        }

        deque.addLast(points[0]);

        int keyPointFrom = 0;
        int length = 0;
        int curLength = 0;

        while(!deque.isEmpty()) {
            keyPointFrom = deque.peekFirst().getKey();

            boolean[] processed = new boolean[size];
            for (int keyPointTo = 1; keyPointTo < size; keyPointTo++) {
                int minLength = Integer.MAX_VALUE;
                int keyMin = 0;

                for (int i = 1; i<size; i++) {
                    length = linkMatrix[keyPointFrom][i];
                    if (length > 0 && length < minLength && !processed[i] && !visited[i]) {
                        minLength = length;
                        keyMin = i;
                        processed[i] = true;
                    }
                }

                if (!visited[keyMin]) {
                    deque.addLast(points[keyMin]);

                    curLength = lengths[keyPointFrom] + minLength;
                    if (curLength < lengths[keyMin]) {
                        lengths[keyMin] = curLength;
                        paths[keyMin] = keyPointFrom;
                    }
                }
            }

            deque.removeFirst();
            visited[keyPointFrom] = true;
        }
    }
}
