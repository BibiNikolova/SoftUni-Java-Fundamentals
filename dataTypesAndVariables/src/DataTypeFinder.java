import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isNum = false;
        boolean isN = false;
        String type = "";

        while (!"END".equals(input)) {
            if (input.length() == 1 && (input.charAt(0) <= 47 || input.charAt(0) > 57)) {
                type = "character";
            } else if ("true".equals(input) || "false".equals(input)) {
                type = "boolean";
            } else {
                type = "string";
            }
            try {
                Integer.parseInt(input);
                isNum = true;
            } catch (NumberFormatException e) {
                isN = false;
            }
            try {
                Float.parseFloat(input);
                isN = true;
            } catch (NumberFormatException e) {
                isNum = false;
            }
            if (isNum) {
                type = "integer";
                isNum = false;
            } else if (isN){
                type = "floating point";
                isN = false;
            }
            System.out.printf("%s is %s type\n", input, type);
            input = scanner.nextLine();

        }
    }
}
