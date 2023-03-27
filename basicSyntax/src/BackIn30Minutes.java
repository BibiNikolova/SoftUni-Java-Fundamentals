import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        int startTimeInMin = h * 60 + m;
        int finalTimeInMin = startTimeInMin + 30;
        int hourIn30 = finalTimeInMin / 60;
        int minIn30 = finalTimeInMin % 60;

        if (hourIn30 >= 24) {
            hourIn30 -= 24;
        } else {

        }
        if (minIn30 < 10) {
            System.out.printf("%d:%02d", hourIn30, minIn30);
        } else {
            System.out.printf("%d:%d", hourIn30, minIn30);

        }
    }
}

