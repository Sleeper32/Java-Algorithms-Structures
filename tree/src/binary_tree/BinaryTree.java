package binary_tree;

public class BinaryTree {
    private Node root;

    public void insert(Node node) {
        Node current = root;

        if (current == null) {
            root = node;
            return;
        }

        insert0(root, null, node);
    }

    private void insert0(Node curNode, Node prevNode, Node insNode) {
        if (curNode == null) {
            if (prevNode.key > insNode.key) {
                prevNode.leftNode = insNode;
            } else {
                prevNode.rightNode = insNode;
            }

            return;
        } else {
            if (curNode.key > insNode.key) {
                insert0(curNode.leftNode, curNode, insNode);
            } else if (curNode.key < insNode.key) {
                insert0(curNode.rightNode, curNode, insNode);
            } else {
                curNode.val = insNode.val;
            }
        }
    }

    public void display() {
        display(root);
    }

    public void display(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node);
            display(node.leftNode);
            display(node.rightNode);
        }
    }

    public int getLevel() {
        return getLevel(this.root);
    }

    public int getLevel(Node startNode) {
        if (startNode == null) {
            return 0;
        }

        return getLevel0(startNode, 0);
    }

    private int getLevel0(Node curNode, int curLevel) {
        if (curNode == null) {
            return curLevel;
        }

        int leftLevel = getLevel0(curNode.leftNode, curLevel) + 1;
        int rightLevel = getLevel0(curNode.rightNode, curLevel) + 1;

        return (leftLevel > rightLevel) ? leftLevel : rightLevel;
    }

    public boolean isBalanced() {
        int leftLevel = getLevel(root.leftNode);
        int rightLevel = getLevel(root.rightNode);

        if (Math.abs(leftLevel - rightLevel) > 1) {
            return false;
        } else {
            return true;
        }
    }
}
