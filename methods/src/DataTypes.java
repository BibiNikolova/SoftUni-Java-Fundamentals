import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String data = scanner.nextLine();

        switch (input){
            case"int":
                int intData = Integer.parseInt(data);
                printDataTypeResult(intData);
                break;
            case "real":
                double realData = Double.parseDouble(data);
                printDataTypeResult(realData);
                break;
            case"string":
                printDataTypeResult(data);
                break;
        }

    }

    private static void printDataTypeResult(String data) {
        System.out.println("$" + data + "$");
    }

    private static void printDataTypeResult(double realData) {
        System.out.printf("%.2f", realData * 1.5);
    }

    private static void printDataTypeResult(int intData) {
        System.out.println(intData * 2);
    }
}
