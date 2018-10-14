public class Primes {

    /** Print all primes up to ARGS[0] (interpreted as an
     *  integer), 10 to a line. */
    public static void main(String[] args) {
        int testnum = 101;
        printPrimes (testnum);
//        printPrimes (Integer.parseInt (args[0]));
    }

    /** Print all primes up to and including LIMIT, 10 to
     *  a line. */
/*    public static void printPrimes (int limit) {
        printPrimes (2, limit, 0);
        System.out.println ();
    }*/

    public static void printPrimes (int limit) {
        int np = 0;
        for (int p = 2; p <= limit; p += 1) {
            if (isPrime(p)) {
                System.out.print(p + " ");
                np += 1;
                if (np % 10 == 0)
                    System.out.println();
            }
        }
    }

    /** Print all primes from L to U, inclusive, 10 to a
     *  line, given that there are initially M primes
     *  printed on the current line. */
    public static void printPrimes (int L, int U, int M) {
        if (L <= U) {
            if (! isPrime (L))
                printPrimes (L+1, U, M);
            else {
                if (M == 10) {
                    System.out.println ();
                    M = 0;
                }
                System.out.print (L + " ");
                printPrimes (L+1, U, M+1);
            }
        }
    }

    /** True iff X is a prime number. */
    public static boolean isPrime (int x) {
        if (x <= 1)
            return false;
        else
            return ! isDivisible (x, 2);
    }

    /** True iff X is divisible by any positive number >=K
     *  and <X, given K>1. */
    public static boolean isDivisible (int x, int k) {
        if (k >= x)
            return false;
        else if (x % k == 0)
            return true;
        else
            return isDivisible (x, k+1);
    }

}
