package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int size;
    private Point[] points;
    private int count;
    private int[][] linkMatrix;

    public Graph(int size) {
        this.size = size;

        points = new Point[size];
        linkMatrix = new int[size][size];
    }

    public void addPoint(Point point) {
        point.setKey(count);
        points[count] = point;
        count++;
    }

    public void addLink(Point p1, Point p2, int length) {
        int key1 = p1.getKey();
        int key2 = p2.getKey();

        linkMatrix[key1][key2] = length;
        linkMatrix[key2][key1] = length;
    }

    //public Path getMinPath() {
    public void getMinPath() {
        Path[] paths = new Path[size];
        Tree pathTree = new Tree();

        //Deque<Point> deque = new LinkedList<Point>();
        Deque<Node> dequeNode = new LinkedList<Node>();

        //deque.addLast(points[0]);

        Node root = new Node(points[0]);
        pathTree.setRoot(root);
        dequeNode.addLast(root);

        //while(!deque.isEmpty()) {
        while ((!dequeNode.isEmpty())) {
            //Point pointFrom = deque.peekFirst();
            //int keyPointFrom = pointFrom.getKey();

            Node parentNode = dequeNode.peekFirst();
            int keyPointFrom = parentNode.getPoint().getKey();

            for (int keyPointTo = keyPointFrom + 1; keyPointTo < size; keyPointTo++) {
                int length = linkMatrix[keyPointFrom][keyPointTo];
                if (length > 0) {
                    Point pointTo = points[keyPointTo];

             //       deque.addLast(pointTo);

                    Node childNode = new Node(pointTo);

                    dequeNode.addLast(childNode);
                    pathTree.addNode(parentNode, childNode);
                }
            }

            //Point point = deque.removeFirst();
            //System.out.println(point);

            dequeNode.removeFirst();
        }

        //return path;
        System.out.println();
        System.out.println("tree:");
        pathTree.display();
    }
}

class Node {
    private Point point;
    private Node parent;
    private LinkedList<Node> chields;

    public Node(Point point) {
        this.point = point;
        this.chields = new LinkedList<Node>();
    }

    public void setParent(Node node) {
        parent = node;
    }

    public Point getPoint() {
        return point;
    }

    public Node getParent() {
        return parent;
    }

    public void addChield(Node node) {
        chields.add(node);
    }

    public LinkedList<Node> getChields() {
        return chields;
    }

    public String toString() {
        return String.format("%s", point);
    }
}

class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void setRoot(Node node) {
        root = node;
    }

    public void addNode(Node parent, Node child) {
        child.setParent(parent);
        parent.addChield(child);
    }

    public void display() {
        display0(root, "");
    }

    private void display0(Node node, String path) {
        if (node.getChields().size() == 0) {
            System.out.println(path + "-" + node);
            return;
        }

        for (Node child: node.getChields()) {
            display0(child, path + "-" + node);
        }
    }
}
