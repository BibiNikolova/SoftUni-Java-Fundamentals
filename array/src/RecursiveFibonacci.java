import java.util.Scanner;

public class RecursiveFibonacci {
    //Finds nth fibonacci number
    public static int fib(int i) {
        if (i <= 1) return i;
        return fib(i - 1) + fib(i - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wanted = Integer.parseInt(scanner.nextLine());
        System.out.println(fib(wanted));
    }
}


