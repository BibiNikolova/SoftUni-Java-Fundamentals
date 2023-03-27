import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courseList = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String name = input.split(" : ")[1];

            if (!courseList.containsKey(course)) {
                courseList.put(course, new ArrayList<>());
            }
            courseList.get(course).add(name);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : courseList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            for (String s : entry.getValue()) {
                System.out.println("-- " + s);
            }
        }
    }
}
