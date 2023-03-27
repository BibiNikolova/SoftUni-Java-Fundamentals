package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int moves = 0;

        while (!"end".equals(input)) {
            if (!isSequenceEmpty(sequence)) {
                break;
            } else {
                moves += 1;
                String[] indexes = input.split(" ");
                Arrays.sort(indexes);
                int index0 = Integer.parseInt(indexes[0]);
                int index1 = Integer.parseInt(indexes[1]);
                if (index0 == index1 ||
                        index0 < 0 || index0 >= sequence.size() ||
                        index1 < 0 || index1 >= sequence.size()) {
                    int middle = sequence.size() / 2;
                    sequence.add(middle, "-" + moves + "a");
                    sequence.add(middle + 1, "-" + moves + "a");
                    System.out.println("Invalid input! Adding additional elements to the board");
                } else {
                    if (sequence.get(index0).equals(sequence.get(index1))) {
                        System.out.printf("Congrats! You have found matching elements - %s!\n", sequence.get(index0));
                        sequence.remove(index0);
                        sequence.remove(index1 - 1);
                    } else {
                        System.out.println("Try again!");
                    }
                }
            }
            input = scanner.nextLine();
        }
        if(isSequenceEmpty(sequence)) {
            System.out.println("Sorry you lose :(");
            for (String s : sequence) {
                System.out.print(s + " ");
            }
        } else  {
            System.out.printf("You have won in %d turns!\n", moves);
        }
    }


        private static boolean isSequenceEmpty (List < String > sequence) {

            return sequence.size() > 0;
        }
    }
