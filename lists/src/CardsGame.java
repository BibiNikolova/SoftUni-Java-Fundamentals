import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            int firstPlayerCard = firstPlayer.get(0);
            int secondPlayerCard = secondPlayer.get(0);
            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayer.add(secondPlayerCard);
                secondPlayer.add(firstPlayerCard);
                secondPlayer.remove(0);
                firstPlayer.remove(0);
            } else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }
        if (firstPlayer.size() == 0) {
            int sum = 0;
            for (Integer i : secondPlayer) {
                sum += i;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (Integer i : firstPlayer) {
                sum += i;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }
}
