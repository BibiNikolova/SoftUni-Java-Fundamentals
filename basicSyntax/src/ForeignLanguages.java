import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        if("England".equals(country) ||"USA".equals(country)) {
            System.out.print("English");
        } else if("Spain".equals(country) || "Argentina".equals(country) || "Mexico".equals(country)) {
            System.out.print("Spanish");
        } else {
            System.out.print("unknown");
        }

    }
}
