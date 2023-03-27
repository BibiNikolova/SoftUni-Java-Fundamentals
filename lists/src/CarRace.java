import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> time = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        double leftRacer = 0;
        double rightRacer = 0;
        for (int i = 0; i < time.size() / 2; i++) {
            if (time.get(i) == 0) {
                leftRacer += time.get(i);
                leftRacer *= 0.8;
            } else {
                leftRacer += time.get(i);
            }
        }
        for (int i = time.size() - 1; i > time.size() / 2; i--) {
            if (time.get(i) == 0) {
                rightRacer += time.get(i);
                rightRacer *= 0.8;
            } else {
                rightRacer += time.get(i);
            }
        }
        if(leftRacer < rightRacer) {
            System.out.printf("The winner is left with total time: %.1f", leftRacer);
        } else {
            System.out.printf("The winner is right with total time: %.1f", rightRacer);
        }
    }
}
