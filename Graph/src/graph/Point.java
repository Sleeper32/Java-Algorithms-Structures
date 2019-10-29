package graph;

public class Point {
    private String label;
    private int key;

    public Point(String label) {
        this.label = label;
    }

    void setKey(int key) {
        this.key = key;
    }

    int getKey() {
       return key;
    }

    public String toString() {
        return label;
    }
}


