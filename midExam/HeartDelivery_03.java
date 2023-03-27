package midExam;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int currentIndex = 0;

        while (!"Love!".equals(input)) {
            String[] command = input.split(" ");
            int jump = Integer.parseInt(command[1]);
            if (isValidIndex(currentIndex, jump, houses)) {
                currentIndex += jump;
                if (houses[currentIndex] != 0) {
                    houses[currentIndex] -= 2;
                    if (houses[currentIndex] == 0) {
                        System.out.printf("Place %d has Valentine's day.\n", currentIndex);
                    }
                } else {
                    System.out.printf("Place %d already had Valentine's day.\n", currentIndex);
                }
            } else {
                currentIndex = 0;
                if (houses[currentIndex] != 0) {
                    houses[currentIndex] -= 2;
                    if (houses[currentIndex] == 0) {
                        System.out.printf("Place %d has Valentine's day.\n", currentIndex);
                    }
                } else {
                    System.out.printf("Place %d already had Valentine's day.\n", currentIndex);

                }

            }
            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.\n", currentIndex);
        int celebrate = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != 0) {
                celebrate += 1;
            }
        }
        if(celebrate == 0){
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", celebrate);
        }
    }

    private static boolean isValidIndex(int currentIndex, int jump, int[] houses) {
        if (currentIndex + jump > houses.length - 1) {
            return false;
        }
        return true;
    }
}

