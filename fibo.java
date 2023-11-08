import java.util.Scanner;

public class fibo {
    public static int fibonacciRecursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static int fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int temp = a;
                a = b;
                b = temp + b;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a method to calculate Fibonacci numbers:");
        System.out.println("1. Recursive");
        System.out.println("2. Non-Recursive (Iterative)");
        int choice = scanner.nextInt();

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int result = 0;

        switch (choice) {
            case 1:
                result = fibonacciRecursive(n);
                break;
            case 2:
                result = fibonacciIterative(n);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}
