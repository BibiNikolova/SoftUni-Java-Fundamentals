package midExam;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequence = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //average num
        double averageNum = printAverageNum(sequence);

        //greater than average
        List<Integer> greaterNums = new ArrayList<>();
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) > averageNum) {
                greaterNums.add(sequence.get(i));
            }
        }
        int length = greaterNums.size();
        if (length == 0) {
            System.out.println("No");
        } else {
            //descending order
            Collections.sort(greaterNums);
            Collections.reverse(greaterNums);

            for (int i = 0; i < length; i++) {
                if (i > 4) {
                    break;
                } else {
                    System.out.print(greaterNums.get(i) + " ");
                }
            }
        }
    }

    private static double printAverageNum(List<Integer> sequence) {
        double sum = 0;
        for (Integer integer : sequence) {
            sum += integer;
        }
        return sum / sequence.size();
    }
}
