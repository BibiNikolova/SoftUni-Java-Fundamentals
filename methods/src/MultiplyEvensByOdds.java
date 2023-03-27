import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(multiplyEvensToOdds(num));
    }

    private static int multiplyEvensToOdds(int num) {

        int sumEvens = sumEvens(num);
        int sumOdds = sumOdds(num);

        return sumEvens * sumOdds;
    }

    private static int sumOdds(int num) {

        String toString = Integer.toString(num);
        int[]arr = Arrays.stream(toString.split(""))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0){
                sum += arr[i];
            }
        }
        return sum;
    }

    private static int sumEvens(int num) {
        String toString = Integer.toString(num);
        int[]arr = Arrays.stream(toString.split(""))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0){
                sum += arr[i];
            }
        }
        return sum;
    }
}
