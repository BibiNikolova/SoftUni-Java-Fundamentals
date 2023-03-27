import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case ("swap"):
                    int index = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    for (int i = 0; i < arr.length; i++) {
                        if (index == i) {
                            int currentMod = arr[i];
                            arr[i] = arr[index2];
                            arr[index2] = currentMod;
                            break;
                        }
                    }
                    break;
                case ("multiply"):
                    int index3 = Integer.parseInt(command[1]);
                    int index4 = Integer.parseInt(command[2]);
                    for (int i = 0; i < arr.length; i++) {
                        if (index3 == i) {
                            arr[i] = arr[i] * arr[index4];
                            break;
                        }
                    }
                    break;
                case ("decrease"):
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] -= 1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < arr.length; i++) {
            if(i != arr.length -1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.println(arr[i]);
            }

        }
    }
}

