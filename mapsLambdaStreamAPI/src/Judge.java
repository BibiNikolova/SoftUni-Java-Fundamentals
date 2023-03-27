package mapsLambdaStreamAPI.src;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> courseStatistic = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"no more time".equals(input)) {
            String user = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            if (!isContestExist(courseStatistic, contest)) {
                courseStatistic.put(contest, new HashMap<>());
                courseStatistic.get(contest).put(user, points);
            } else {
                if (!isParticipating(courseStatistic, user, contest)) {
                    courseStatistic.get(contest).put(user, points);
                } else {
                    if (isHigher(courseStatistic, user, contest, points)) {
                        courseStatistic.get(contest).put(user, points);
                    }
                }
            }

            input = scanner.nextLine();
        }

        int[] num = new int[1];
        courseStatistic.forEach((k, v) -> {
            int count = v.entrySet().size();
            num[0] = 0;
            System.out.printf("%s: %d participants%n", k, count);
            v.entrySet().stream()
                    .sorted((p1, p2) -> {
                        int result = p2.getValue().compareTo(p1.getValue());
                        if(result == 0){
                            result = p1.getKey().compareTo(p2.getKey());
                        }
                        return  result;
                    })
                    .forEach(score ->
                            System.out.printf("%d. %s <::> %d%n", ++num[0], score.getKey(), score.getValue()));

        });

        Map<String, Integer> indStanding = new HashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : courseStatistic.entrySet()) {
            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                indStanding.putIfAbsent(integerEntry.getKey(), 0);
                indStanding.put(integerEntry.getKey(),
                        indStanding.get(integerEntry.getKey()) + integerEntry.getValue());
            }
        }
        System.out.println("Individual standings:");
        num[0] = 0;
        indStanding.entrySet().stream()
                .sorted((p1, p2) -> {
                    int result = p2.getValue().compareTo(p1.getValue());
                    if(result == 0){
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return  result;
                })
                .forEach(score -> {
                    System.out.printf("%d. %s -> %d%n", ++num[0], score.getKey(), score.getValue());
                });
    }

    private static boolean isParticipating(Map<String, Map<String, Integer>> courseStatistic, String user, String contest) {
        for (Map.Entry<String, Map<String, Integer>> entry : courseStatistic.entrySet()) {
            if (entry.getKey().equals(contest) && entry.getValue().containsKey(user)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContestExist(Map<String, Map<String, Integer>> courseStatistic, String contest) {
        for (Map.Entry<String, Map<String, Integer>> entry : courseStatistic.entrySet()) {
            if (entry.getKey().equals(contest)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHigher(Map<String, Map<String, Integer>> courseStatistic, String user, String
            contest, int points) {
        for (Map.Entry<String, Map<String, Integer>> entry : courseStatistic.entrySet()) {
            if (entry.getKey().equals(contest)) {
                for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                    if (integerEntry.getKey().equals(user)) {
                        if (integerEntry.getValue() < points) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
