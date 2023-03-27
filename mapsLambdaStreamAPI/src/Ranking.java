import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestList = new HashMap<>();

        String input = scanner.nextLine();

        while (!"end of contests".equals(input)) {
            contestList.put(input.split(":")[0], input.split(":")[1]);

            input = scanner.nextLine();
        }
        Map<String, Map<String, Integer>> students = new TreeMap<>();

        String line = scanner.nextLine();

        while (!"end of submissions".equals(line)) {
            String contest = line.split("=>")[0];
            String password = line.split("=>")[1];
            String user = line.split("=>")[2];
            int points = Integer.parseInt(line.split("=>")[3]);

            if (isContestValid(contestList, contest, password)) {
                if (!doesStudentExist(students, user)) {
                    students.put(user, new HashMap<>());
                    students.get(user).put(contest, points);
                } else {
                    if (!doesCourseExist(students, user, contest)) {
                        students.get(user).put(contest, points);
                    } else {
                        if (isLarger(students, user, contest, points)) {
                            students.get(user).put(contest, points);
                        }
                    }
                }
            }
            line = scanner.nextLine();
        }
        int maxSum = Integer.MIN_VALUE;
        String bestStudent = null;
        for (Map.Entry<String, Map<String, Integer>> entry : students.entrySet()) {
            int sum = entry.getValue().entrySet()
                    .stream()
                    .mapToInt(c -> c.getValue())
                    .sum();
            if (sum > maxSum) {
                maxSum = sum;
                bestStudent = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestStudent, maxSum);
        System.out.println("Ranking:");
        students.forEach((k, v) -> {
            System.out.printf("%s%n", k);
            v.entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
            .forEach(score -> System.out.printf("#  %s -> %d%n", score.getKey(), score.getValue()));
        });
    }

    private static boolean doesCourseExist(Map<String, Map<String, Integer>> students, String user, String contest) {
        for (Map.Entry<String, Map<String, Integer>> entry : students.entrySet()) {
            if (entry.getKey().equals(user)) {
                for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                    if (integerEntry.getKey().contains(contest)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isLarger(Map<String, Map<String, Integer>> students, String user, String contest, int points) {
        for (Map.Entry<String, Map<String, Integer>> entry : students.entrySet()) {
            if (entry.getKey().equals(user)) {
                for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                    if (integerEntry.getKey().equals(contest)) {
                        if (integerEntry.getValue() < points) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isContestValid(Map<String, String> contestList, String contest, String password) {
        for (Map.Entry<String, String> entry : contestList.entrySet()) {
            if (entry.getKey().equals(contest) && entry.getValue().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesStudentExist(Map<String, Map<String, Integer>> students, String user) {
        for (Map.Entry<String, Map<String, Integer>> entry : students.entrySet()) {
            if (entry.getKey().equals(user)) {
                return true;
            }
        }
        return false;
    }
}
