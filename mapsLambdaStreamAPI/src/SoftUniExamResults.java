import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userList = new LinkedHashMap<>();
        Map<String, Integer> submissionList = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"exam finished".equals(input)) {
            if (!input.contains("banned")) {
                String username = input.split("-")[0];
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);
                if (!userList.containsKey(username)) {
                    userList.put(username, points);
                    if (!submissionList.containsKey(language)) {
                        submissionList.put(language, 0);
                    }
                } else {
                    if (points > userList.get(username)) {
                        userList.put(username, points);
                    }
                }
                int countSubmissions = submissionList.get(language);
                submissionList.put(language, countSubmissions + 1);

            } else {
                String bannedStudent = input.split("-")[0];
                userList.remove(bannedStudent);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : userList.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submissionList.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


    }
}
