import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that finds the longest sequence of equal elements in an array of integers.
        // If several longest sequences exist, print the leftmost one.
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int currentNum = 0;
        int count = 1;
        int longest = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                if(count > longest) {
                    currentNum = nums[i];
                    longest = count;
                }
            } else {
                count = 1;
            }
        }
        for (int i = 0; i < longest; i++) {
            System.out.print(currentNum + " ");
        }
    }
}
