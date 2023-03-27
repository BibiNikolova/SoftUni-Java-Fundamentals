import java.util.*;

public class Templates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //проверка дали ключ е част от мап с добавяне на стойност в лист
        Map<String, List<Double>> students = new LinkedHashMap<>();
        String name = scanner.nextLine();
        double grade = Double.parseDouble(scanner.nextLine());

        if (!students.containsKey(name)) {
            students.put(name, new ArrayList<>());
        }
        students.get(name).add(grade);

        // print list as value of a map

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            for (Double s : entry.getValue()) {
                System.out.println("-- " + s);
            }

        }
    }
}
