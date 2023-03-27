package midExam;

import java.util.Scanner;

public class SoftUniReception_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employee1 = scanner.nextInt();
        int employee2 = scanner.nextInt();
        int employee3 = scanner.nextInt();
        int employees = employee1 + employee2 + employee3;

        int students = scanner.nextInt();
        int countHours = 0;
        int breakHour = 0;

        while (students > 0) {
            students -= employees;
            countHours += 1;
            if(countHours % 3 == 0 && students > 0) {
                breakHour += 1;
            }
        }

            System.out.printf("Time needed: %dh.", countHours + breakHour);
    }
}
