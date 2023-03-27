import java.util.Scanner;


public class AddAndSubtract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        System.out.println(subtractNums(n1, n2, n3));
    }

    private static int subtractNums(int n1, int n2, int n3) {
       int finalSum = sumNums(n1, n2) - n3;
       return finalSum;
    }
    private static int sumNums(int n1, int n2){
        int sum = n1 + n2;
        return sum;
    }
}
