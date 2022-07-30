import java.util.Scanner;

public class Main {

    public static long fib(long n) {
        if (n % 2 == 0) {
            return fibEven(n);
        } else {
            return fibOdd(n);
        }
    }

    public static long fibEven(long n) {
        return n <= 1 ? n : fibEven(n - 2) - fibEven(n - 1);
    }

    public static long fibOdd(long n) {
        return n <= 1 ? n : fibOdd(n - 1) + fibOdd(n - 2);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }
}