import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();
        temp.addAll(drumSet);
        String input = scanner.nextLine();

        while (!"Hit it again, Gabsy!".equals(input)){
            int power = Integer.parseInt(input);
            for (int i = 0; i < temp.size(); i++) {
                int drum = temp.get(i);
                if(drum - power > 0) {
                    temp.set(i, drum - power);
                } else {
                    if(drumSet.get(i) * 3 < budget && temp.get(1) != 0) {
                        temp.set(i, drumSet.get(i));
                        budget -= drumSet.get(i) * 3;
                    } else {
                        temp.set(i, 0);
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) != 0) {
                System.out.print(temp.get(i) + " ");
            }
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", budget);
    }
}
