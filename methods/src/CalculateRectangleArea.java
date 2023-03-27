import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int hight = Integer.parseInt(scanner.nextLine());
        int area = calculateArea(width, hight);
        System.out.println(area);
    }

    private static int calculateArea(int width, int hight) {
        int area = width * hight;
        return area;
    }
}
