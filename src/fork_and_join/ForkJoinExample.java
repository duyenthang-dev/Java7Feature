package fork_and_join;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinExample extends RecursiveAction {
    private static final long threshold = 35;
    private volatile long number;

    public ForkJoinExample(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    protected void compute() {
        long n = number;
        if (n < threshold) {
            number = fib(n);
        }
        else  {
            ForkJoinExample t1 = new ForkJoinExample(n -1);
            ForkJoinExample t2 = new ForkJoinExample(n - 2);
            ForkJoinExample.invokeAll(t1, t2);
            number = t1.getNumber() + t2.getNumber();
        }
    }

    private long fib(long n) {
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
        ForkJoinExample task = new ForkJoinExample(n);


        long start1 = System.nanoTime();
        new ForkJoinPool().invoke(task);
        long end1 = System.nanoTime();
        System.out.println("Fib = " + task.getNumber());
        System.out.println("Thời gian chạy (dùng đa luồng): " + String.format("%.10f", (end1 - start1) * 1.0 / 1_000_000_000) + " s");

//        ForkJoinExample task2 = new ForkJoinExample(n);
//        long start2 = System.nanoTime();
//        long res = task2.fib(n);
//        long end2 = System.nanoTime();
//        System.out.println("Fib = " + res);
//        System.out.println("Thời gian chạy (k dùng đa luồng): " + (end2 - start2) * 1.0 / 1_000_000_000 + " s");
    }
}
