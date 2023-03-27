package midExam;

import java.util.Scanner;

public class BonusScoringSystem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})

        double maxTotalBonus = 0;
        int maxAttendance = 0;

        while (students > 0 && lectures != 0) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = attendance * 1.0 / lectures * (5 + bonus);
            if (totalBonus > maxTotalBonus) {
                maxTotalBonus = totalBonus;
                maxAttendance = attendance;
            }
            students -= 1;
        }
        System.out.printf("Max Bonus: %.0f.\n", Math.ceil(maxTotalBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }
}
