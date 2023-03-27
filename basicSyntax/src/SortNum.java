import java.util.Scanner;

public class SortNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int max = 0;
        int min = 0;
        int middle = 0;
        if (n1 >= n2 && n1 >= n3) {
            max = n1;
            if (n2 >= n3) {
                middle = n2;
                min = n3;
                System.out.printf("%d%n%d%n%d", max, middle, min);
            } else {
                middle = n3;
                min = n2;
                System.out.printf("%d%n%d%n%d", max, middle, min);
            }
        } else if (n2 >= n1 && n2 >= n3) {
            max = n2;
            if (n1 >= n3) {
                middle = n1;
                min = n3;
                System.out.printf("%d%n%d%n%d", max, middle, min);
            } else {
                middle = n3;
                min = n1;
                System.out.printf("%d%n%d%n%d", max, middle, min);
            }
        } else {
            max = n3;
            if (n2 >= n1) {
                middle = n2;
                min = n1;
                System.out.printf("%d%n%d%n%d", max, middle, min);
            } else {
                middle = n1;
                min = n2;
                System.out.printf("%d%n%d%n%d", max, middle, min);
            }
        }
    }
}
