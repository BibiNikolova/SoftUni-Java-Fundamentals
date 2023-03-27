package midExam;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int shots = 0;

        while (!"End".equals(input)) {
            int index = Integer.parseInt(input);
            if (isValidIndex(sequence, index)) {
                // shoot
                int value = sequence[index];
                sequence[index] = -1;
                shots += 1;
                for (int i = 0; i < sequence.length; i++) {
                    // increase
                    if (sequence[i] <= value && sequence[i] != -1) {
                        sequence[i] += value;
                        //reduce
                    } else if (sequence[i] > value && sequence[i] != -1) {
                        sequence[i] -= value;
                    }

                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shots);
        for (int s:sequence){
            System.out.print(s + " ");
        }
    }

    private static boolean isValidIndex(int[] sequence, int index) {
        return index <= sequence.length - 1 && index >= 0;
    }
}
