import binary_tree.BinaryTree;
import binary_tree.Node;

import java.util.Random;

public class TreeTest {

    final static int NUM_TREES = 20;
    final static int MAX_LEVEL_TREE = 6;

    public static void main(String[] args) {
        Random random = new Random();
        BinaryTree[] bt = new BinaryTree[NUM_TREES];
        int balancedCount = 0;

        for(int i = 0; i < NUM_TREES; i++) {
            int level = 0;
            boolean balanced = false;

            bt[i] = new BinaryTree();
            while (level < MAX_LEVEL_TREE) {
                int val = 100 - random.nextInt(200);

                bt[i].insert(new Node(val, val));
                level = bt[i].getLevel();
            }

            balanced = bt[i].isBalanced();
            if (balanced) balancedCount++;

            System.out.println("three N" + (i + 1) + ":");
            System.out.println(String.format("level = %d, balanced = %s", level, balanced));
            bt[i].display();
            System.out.println();
        }

        System.out.println(String.format("Balanced trees: %d/%d (%.2f%%)", balancedCount, NUM_TREES, (float)balancedCount/(float)NUM_TREES*100f));
    }
}
