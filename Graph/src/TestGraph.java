import graph.Graph;
import graph.Path;
import graph.Point;

public class TestGraph {
    static public void main(String[] args) {

        test1();
        test2();
    }

    public static void test1() {
        final int GRAPH_SIZE = 10;

        Graph graph = new Graph(GRAPH_SIZE);
        Point a = new Point("A");
        Point b = new Point("B");
        Point c = new Point("C");
        Point d = new Point("D");
        Point e = new Point("E");
        Point f = new Point("F");
        Point g = new Point("G");
        Point h = new Point("H");
        Point i = new Point("I");
        Point k = new Point("K");

        graph.addPoint(a);
        graph.addPoint(b);
        graph.addPoint(c);
        graph.addPoint(d);
        graph.addPoint(e);
        graph.addPoint(f);
        graph.addPoint(g);
        graph.addPoint(h);
        graph.addPoint(i);
        graph.addPoint(k);

        graph.addLink(a, b, 2);
        graph.addLink(b, c, 3);
        graph.addLink(c, e, 1);
        graph.addLink(a, d, 5);
        graph.addLink(d, e, 6);
        graph.addLink(e, f, 7);
        graph.addLink(e, g, 1);
        graph.addLink(f, i, 6);
        graph.addLink(g, h, 2);
        graph.addLink(h, i, 3);
        graph.addLink(i, k, 1);

        graph.printMinPath();
        graph.printMinLength();
    }

    public static void test2() {
        int size = 6;
        Graph graph = new Graph(size);

        Point p1 = new Point("1");
        Point p2 = new Point("2");
        Point p3 = new Point("3");
        Point p4 = new Point("4");
        Point p5 = new Point("5");
        Point p6 = new Point("6");

        graph.addPoint(p1);
        graph.addPoint(p2);
        graph.addPoint(p3);
        graph.addPoint(p4);
        graph.addPoint(p5);
        graph.addPoint(p6);

        graph.addLink(p1, p2, 7);
        graph.addLink(p1, p3, 9);
        graph.addLink(p1, p6, 14);
        graph.addLink(p2, p4, 15);
        graph.addLink(p2, p3, 10);
        graph.addLink(p3, p4, 11);
        graph.addLink(p3, p6, 2);
        graph.addLink(p6, p5, 9);
        graph.addLink(p5, p4, 6);

        graph.printMinPath();
        graph.printMinLength();
    }
}
