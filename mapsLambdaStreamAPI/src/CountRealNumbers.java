import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> countNums = new TreeMap<>();
        for (Double n: input) {
            if(!countNums.containsKey(n)) {
                countNums.put(n, 0);
            }
            countNums.put(n, countNums.get(n) + 1);
        }
        for (Map.Entry<Double, Integer> entry : countNums.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
