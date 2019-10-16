import fill_bag.Bag;
import fill_bag.Thing;
import pow.NegativePowException;
import pow.Pow;

public class Recursion {
    public static void main(String[] args) {
        //  Test pow()
        System.out.println("------ Test recursion pow ------");
        System.out.println();

        int x = 3;
        int n1 = -3, n2 = 0, n3 = 3;

        try {
            System.out.println(String.format("pow(%d, %d) = %d", x, n1, Pow.pow(x, n1)));
        } catch (NegativePowException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(String.format("pow(%d, %d) = %d", x, n2, Pow.pow(x, n2)));
        } catch (NegativePowException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(String.format("pow(%d, %d) = %d", x, n3, Pow.pow(x, n3)));
        } catch (NegativePowException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Test placement()
        System.out.println("------ Test recursion pow ------");
        System.out.println();

        Bag bag = new Bag(14);

        Thing[] things = new Thing[]{
                new Thing(5, 3),
                new Thing(10, 5),
                new Thing(6, 4),
                new Thing(5, 2)
        };

        bag.fill(things);
        System.out.println(bag);


        Bag bag1 = new Bag(3);

        bag1.fill(things);
        System.out.println(bag1);

        Bag bag2 = new Bag(5);

        bag2.fill(things);
        System.out.println(bag2);

        Bag bag3 = new Bag(10);

        bag3.fill(things);
        System.out.println(bag3);

    }
}




