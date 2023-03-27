import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Write a program that receives an array and the number of rotations
        // you have to perform (the first element goes at the end) Print the resulting array. 32 61 21 51 47
        String input = scanner.nextLine();
        String[]array = input.split(" ");
        int round = Integer.parseInt(scanner.nextLine());
        for (int r = 0; r < round; r++) {
            String firstElement = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = firstElement;
        }
        for (String s : array) {
            System.out.print(s + " ");
        }
    }
}
