package pow;

public class Pow {
    public static long pow(int x, int n) throws NegativePowException {
        if (n < 0) {
            throw new NegativePowException("ERROR: Negative power");
        }

        if (n == 0) {
            return 1;
        }
        else {
            return pow(x, n - 1) * x;
        }
    }
}


