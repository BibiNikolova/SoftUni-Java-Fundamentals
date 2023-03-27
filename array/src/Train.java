import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] wagons = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            wagons[i] = scanner.nextInt();
            sum += wagons[i];
            System.out.print(wagons[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
