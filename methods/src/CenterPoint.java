import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());


        if(printFirstPointSquareRoot(x1, y1) > printSecondPointSquareRoot(x2, y2)) {
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            System.out.printf("(%d, %d)", x1, y1);
        }
    }

    private static double printSecondPointSquareRoot(int x2, int y2) {
        double c = Math.pow(x2, 2) + Math.pow(y2, 2);
        return Math.sqrt(c);
    }

    private static double printFirstPointSquareRoot(int x1, int y1) {
        double c = Math.pow(x1, 2) + Math.pow(y1, 2);
        return Math.sqrt(c);
    }
}
