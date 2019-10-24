package binary_tree;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(Node node) {
        Node current = root;

        if (current == null) {
            root = node;
            root.level = 1;
            return;
        }

        insert0(root, null, node, root.level);
    }

    private void insert0(Node curNode, Node prevNode, Node insNode, int curLevel) {
        if (curNode == null) {
            if (prevNode.key > insNode.key) {
                prevNode.leftNode = insNode;
            }
            else {
                prevNode.rightNode = insNode;
            }

            insNode.level = curLevel;

            return;
        } else {
            if (curNode.key > insNode.key) {
                insert0(curNode.leftNode, curNode, insNode, curLevel+1);
            } else if (curNode.key < insNode.key){
                insert0(curNode.rightNode, curNode, insNode, curLevel+1);
            } else {
                curNode.val = insNode.val;
            }
        }
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
        if (root == null) {
            return 0;
        }

        return getLevel0(root, root.level);
    }

    private int getLevel0(Node curNode, int curLevel) {
        if (curNode == null) {
            return curLevel;
        }

        int leftLevel =  getLevel0(curNode.leftNode, curNode.level);
        int rightLevel = getLevel0(curNode.rightNode, curNode.level);

        return (leftLevel > rightLevel) ? leftLevel : rightLevel;
    }

    public boolean isBalanced() {
        return false;
    }
}
