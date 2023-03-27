import java.util.Scanner;

public class GreaterOfTwoValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                System.out.println(getMaxN(firstNum, secondNum));
                break;
            case "char":
                char firstC = scanner.nextLine().charAt(0);
                char secondC = scanner.nextLine().charAt(0);
                System.out.println(getMaxC(firstC, secondC));
                break;
            case "string":
                String firstS = scanner.nextLine();
                String secondS = scanner.nextLine();
                System.out.println(getMaxS(firstS, secondS));
        }
    }

    private static int getMaxN(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        }
        return secondNum;
    }

    private static char getMaxC(char firstC, char secondC) {
        if (firstC > secondC) {
            return firstC;
        }
        return secondC;
    }

    private static String getMaxS(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }
}
