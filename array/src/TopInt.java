import java.util.Arrays;
import java.util.Scanner;

public class TopInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program to find all the top integers in an array.
        // A top integer is an integer that is bigger than all the elements to its right.
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int index = 0; index < array.length; index++) {
            int currentNum = array[index];
            if(index == array.length - 1) {
                System.out.print(currentNum + " ");
                break;
            }
            boolean isTop = false;
            for (int i = index + 1; i < array.length; i++) {
                if(currentNum > array[i]) {
                    isTop = true;
                } else {
                    isTop = false;
                    break;
                }
            }
            if(isTop){
                System.out.print(currentNum + " ");
            }
        }
    }
}
