package fork_and_join;

import java.util.Scanner;

public class Fibonacci {

    private static long fibonacci(long n)
    {
        long a1 = 1, a2 = 1, a = 0;
        if (n == 1 || n == 2)
            return 1;
        long i = 3;
        while (i <= n)
        {
            a = a1 + a2;
            a1 = a2;
            a2 = a;
            i++;
        }
        return a;
    }
    public static void main(String[] args) {
        long n;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap n = ");
        n = in.nextLong();
        long start1 = System.nanoTime();
        long res = fibonacci(n);
        long end1 = System.nanoTime();
        System.out.println("Fib = " + res);
        System.out.println("Thời gian chạy (k dùng đa luồng): " + String.format("%.10f", (end1 - start1) * 1.0 / 1_000_000_000) + " s");
    }
}
