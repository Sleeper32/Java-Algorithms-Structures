package binary_tree;

public class Node {
    int key;
    int val;
    int level;
    Node leftNode;
    Node rightNode;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public String toString() {
        return String.format("key = %d; val = %d (lKey = %s, rKey = %s)", key, val, stringLink(leftNode), stringLink(rightNode));
    }

    private String stringLink(Node node) {
        String link;

        if (node == null) {
            link = "null";
        } else {
            link = String.format("%d", node.key);
        }

        return link;
    }
}
