import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that determines if there exists an element in the array
        // such that the sum of the elements on its left is equal to the sum of the elements
        // on its right. If there are no elements to the left/right, their sum is considered to be 0.
        // Print the index that satisfies the required condition or "no" if there is no such index.
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int leftSum = 0;
        int rightSum = 0;
        boolean isEqual = false;
        boolean isNull = false;
        int rightIndex = 0;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers.length == 1) {
                isNull = true;
                break;
           }
            for (int i = 0; i < index; i++) {
                int currentNum = numbers[i];
                leftSum += currentNum;
            }
            for (int i = index + 1; i < numbers.length; i++) {
                int currentNum = numbers[i];
                rightSum += currentNum;
            }
            if (rightSum == leftSum) {
                isEqual = true;
                rightIndex = index;
                break;
            } else {
                isEqual = false;
            }
            leftSum = 0;
            rightSum = 0;
        }
        if (isNull) {
            System.out.print(0);
        } else if (isEqual) {
            System.out.println(rightIndex);
        } else {
            System.out.println("no");
        }
    }
}

