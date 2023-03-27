import java.util.*;
        import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*Read a list of integers, remove all negative numbers
        from it and print the remaining elements in reversed order.
        In case of no elements left in the list, print "empty".*/

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int i = nums.size() - 1;
        while (i >= 0) {
            if (nums.get(i) < 0) {
                nums.remove(i);
            }
            i--;
        }
        Collections.reverse(nums);
        if(nums.size()==0){
            System.out.println("empty");
        } else {
            for (Integer num : nums) {
                System.out.print(num + " ");
            }
        }
    }
}
