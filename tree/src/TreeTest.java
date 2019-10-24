import binary_tree.BinaryTree;
import binary_tree.Node;

public class TreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.insert(new Node(5, 5));
        System.out.println(bt.getLevel());
        bt.insert(new Node(3, 3));
        System.out.println(bt.getLevel());
        bt.insert(new Node(9, 9));
        System.out.println(bt.getLevel());
        bt.insert(new Node(2, 2));
        System.out.println(bt.getLevel());
        bt.insert(new Node(4, 4));
        System.out.println(bt.getLevel());
        bt.insert(new Node(7, 7));
        System.out.println(bt.getLevel());
        bt.insert(new Node(20, 20));
        System.out.println(bt.getLevel());
        bt.insert(new Node(1, 1));
        System.out.println(bt.getLevel());
        bt.insert(new Node(6, 6));
        System.out.println(bt.getLevel());
        bt.insert(new Node(8, 8));
        System.out.println(bt.getLevel());
        bt.insert(new Node(15, 15));
        System.out.println(bt.getLevel());
        bt.insert(new Node(25, 25));
        System.out.println(bt.getLevel());

        bt.display(bt.getRoot());
        System.out.println(bt.getLevel());
        System.out.println();


        BinaryTree bt2 = new BinaryTree();

        bt2.insert(new Node(2, 2));
        System.out.println(bt2.getLevel());
        bt2.insert(new Node(3, 3));
        System.out.println(bt2.getLevel());
        bt2.insert(new Node(4, 4));
        System.out.println(bt2.getLevel());
        bt2.insert(new Node(1, 1));
        System.out.println(bt2.getLevel());

        bt2.display(bt2.getRoot());
        System.out.println(bt2.getLevel());
    }
}
