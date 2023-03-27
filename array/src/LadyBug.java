import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] field = new int[size];
        String[] ladyBugIndexes = scanner.nextLine().split(" ");//positions of ladybugs inside the field
        for (String index : ladyBugIndexes) {
            int i = Integer.parseInt(index);
            if (i >= 0 && i < field.length) {
                field[i] = 1;
            }
        }
        String command = scanner.nextLine();

        //ladybug changes its position
        while (!"end".equals(command)) {
            String[] commandArr = command.split(" ");
            int flying = Integer.parseInt(commandArr[0]);
            int landing = Integer.parseInt(commandArr[2]);

            if (flying >= 0 && flying < field.length && field[flying] == 1) {//is there a ladybug to be replaced
                field[flying] = 0;
                if (commandArr[1].equals("right")) {
                    flying += landing;
                    while (flying < field.length && field[flying] == 1) {
                        flying += landing;
                    }
                    if (flying < field.length) {
                        field[flying] = 1;
                    }
                } else {
                    flying -= landing;
                    while (flying >= 0 && field[flying] == 1) {
                        flying -= landing;
                    }
                    if (flying >= 0) {
                        field[flying] = 1;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int i : field) {
            System.out.print(i + " ");
        }
    }
}


