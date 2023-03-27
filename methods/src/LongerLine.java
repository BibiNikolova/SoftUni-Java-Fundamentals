import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());
        double d1 = printFirstLineDistance(x1, x2, y1, y2);
        double d2 = printSecondLineDistance(x3, x4, y3, y4);

        if (printFirstLineDistance(x1, x2, y1, y2) >= printSecondLineDistance(x3, x4, y3, y4)) {
            if(printFirstPointSquareRoot(x1, y1) > printSecondPointSquareRoot(x2, y2)) {
                System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            }
        } else {
            if(printThirdPointSquareRoot(x3, y3) > printForthPointSquareRoot(x4, y4)) {
                System.out.printf("(%d, %d)(%d, %d)", x4, y4, x3, y3);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
            }
        }
    }

    private static double printSecondLineDistance(int x3, int x4, int y3, int y4) {

        return Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
    }

    private static double printFirstLineDistance(int x1, int x2, int y1, int y2) {
        double d = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        return Math.sqrt(d);
    }
    private static double printSecondPointSquareRoot(int x2, int y2) {
        double c = Math.pow(x2, 2) + Math.pow(y2, 2);
        return Math.sqrt(c);
    }

    private static double printFirstPointSquareRoot(int x1, int y1) {
        double c = Math.pow(x1, 2) + Math.pow(y1, 2);
        return Math.sqrt(c);
    }
    private static double printThirdPointSquareRoot(int x3, int y3) {
        double c = Math.pow(x3, 2) + Math.pow(y3, 2);
        return Math.sqrt(c);
    }

    private static double printForthPointSquareRoot(int x4, int y4) {
        double c = Math.pow(x4, 2) + Math.pow(y4, 2);
        return Math.sqrt(c);
    }
}


