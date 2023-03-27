import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mixedList = new ArrayList<>();

        int[] range = new int[2];

        if (firstList.size() > secondList.size()) {
            range[0] = firstList.get(firstList.size() - 1);
            range[1] = firstList.get(firstList.size() - 2);
            mixedList.addAll(firstList.subList(0, secondList.size()));
            mixedList.addAll(secondList);
        } else {
            range[0] = secondList.get(0);
            range[1] = secondList.get(1);
            mixedList.addAll(firstList);
            mixedList.addAll(secondList.subList(2, secondList.size()));
        }
        Arrays.sort(range);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < mixedList.size(); i++) {
            int element = mixedList.get(i);
            if(element > range[0] && element < range[1]) {
               result.add(element);
            }
        }
        Collections.sort(result);
        for (Integer e : result) {
            System.out.print(e + " ");
        }
    }
}
