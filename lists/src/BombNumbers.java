import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> line = stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] detonationsTokens = scanner.nextLine().split(" ");
        int bomb = Integer.parseInt(detonationsTokens[0]);
        int power = Integer.parseInt(detonationsTokens[1]);
        while (line.contains(bomb)) {
            int bombIndex = line.indexOf(bomb);
            int start = Math.max(bombIndex - power, 0);
            int end = Math.min(bombIndex - power, line.size() - 1);
 /*         int start = bombIndex - power;
            int end = bombIndex + power;
            if(start < 0){
                start = 0;
            }
            if(end >= line.size()){
                end = line.size()-1;
            }
            for (int i = start; i <= end ; i++) {
            line.remove(start);
            }*/
        }
        int sum = 0;
        for (int i = 0; i < line.size(); i++) {
            sum += line.get(i);
        }
        System.out.println(sum);
    }
}
