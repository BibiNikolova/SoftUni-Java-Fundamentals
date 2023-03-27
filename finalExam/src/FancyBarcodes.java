import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Matcher matcher = Pattern.compile("^(@)[#]+(?<barcode>[A-Z][A-Za-z\\d]{4,}[A-Z])\\1[#]+$").matcher(input);
            if(matcher.find()){
                String barcode = matcher.group("barcode");
                System.out.print("Product group: ");
                matcher = Pattern.compile("\\d").matcher(barcode);
                if(matcher.find()){
                    System.out.print(matcher.group());
                    while (matcher.find()) {
                        System.out.print(matcher.group());
                    }
                } else {
                    System.out.print("00");
                }
                System.out.println();
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
