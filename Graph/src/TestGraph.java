import graph.Graph;
import graph.Path;
import graph.Point;

public class TestGraph {
    static public void main(String[] args) {
        final int GRAPH_SIZE = 6;

        Graph graph = new Graph(GRAPH_SIZE);
        Point a = new Point("A");
        Point b = new Point("B");
        Point c = new Point("C");
        Point d = new Point("D");
        Point e = new Point("E");

        graph.addPoint(a);
        graph.addPoint(b);
        graph.addPoint(c);
        graph.addPoint(d);
        graph.addPoint(e);

        graph.addLink(a, b, 2);
        graph.addLink(b, c, 3);
        graph.addLink(c, e, 1);
        graph.addLink(a, d, 5);
        graph.addLink(d, e, 6);

        // graph.getAllPath();

        //Path minPath = graph.getMinLengthPath();
        graph.getMinPath();
    }
}
