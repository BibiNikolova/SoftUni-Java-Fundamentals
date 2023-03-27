import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 1) {
            System.out.println(n);
        } else {
            String row = "1";
            System.out.println(row);
            for (int i = 0; i < n - 1; i++) {
                long[] pascal = Arrays.stream(row.split(" "))
                        .mapToLong(Long::parseLong).toArray();
                String temp = "1";
                for (int j = 0; j < pascal.length; j++) {
                    if (j != pascal.length - 1) {
                        temp += " " + (pascal[j] + pascal[j + 1]);
                    } else {
                        temp += " " + 1;
                    }
                }
                row = temp;
                System.out.println(row);
            }
        }
    }
}
