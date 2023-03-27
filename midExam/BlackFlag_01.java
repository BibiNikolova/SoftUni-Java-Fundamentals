package midExam;

import java.util.Scanner;

public class BlackFlag_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double collectedPlunder = 0;

        for (int i = 1; i <= days; i++) {
            collectedPlunder += dailyPlunder;
            if(i % 3 == 0) {
                collectedPlunder += dailyPlunder * 0.5;
            }
            if(i % 5 == 0) {
                collectedPlunder *= 0.7;
            }
        }
        if(collectedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", collectedPlunder);
        } else {
            double part = collectedPlunder * 100/expectedPlunder;
            System.out.printf("Collected only %.2f%% of the plunder.", part);
        }
    }
}
