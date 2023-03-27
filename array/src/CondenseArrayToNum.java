import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int repetitions = 0; repetitions < nums.length - 1; repetitions++) {
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i] = nums[i] + nums[i + 1];
            }
        }
        System.out.println(nums[0]);
    }
}
