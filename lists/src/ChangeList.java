import java.util.*;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> line = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            int element = Integer.parseInt(command[1]);
            if ("Delete".equals(command[0])) {
                int i = line.size() - 1;
                while (i >= 0) {
                    if (line.get(i) == element) {
                        line.remove(i);
                    }
                    i--;
                }
            } else if ("Insert".equals(command[0])) {
                int index = Integer.parseInt(command[2]);
                line.add(index, element);
            }
            input = scanner.nextLine();
        }
        for (Integer integer : line) {
            System.out.print(integer + " ");
        }

    }
}
