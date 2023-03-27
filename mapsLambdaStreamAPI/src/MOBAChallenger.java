package mapsLambdaStreamAPI.src;

import java.util.*;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> pool = new TreeMap<>();

        while (!"Season end".equals(input)) {
            if (input.contains("->")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);

                pool.putIfAbsent(player, new HashMap<>());
                pool.get(player).putIfAbsent(position, -1);
                if (pool.get(player).get(position) < skill) {
                    pool.get(player).put(position, skill);
                }
            } else {
                String player1 = input.split(" vs ")[0];
                String player2 = input.split(" vs ")[1];
                if (doesPlayerExist(pool, player1) && doesPlayerExist(pool, player2)) {
                    String currentPosition = getCurrentPosition(pool, player1, player2);
                    if (currentPosition != null) {
                        int currentSkill1 = getCurrentSkill(pool, currentPosition, player1);
                        int currentSkill2 = getCurrentSkill(pool, currentPosition, player2);
                        if (currentSkill1 > currentSkill2) {
                            pool.remove(player2);
                        } else if (currentSkill2 > currentSkill1) {
                            pool.remove(player2);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        pool.forEach((k, v) -> {
            int sum = v.entrySet().stream()
                    .mapToInt(s -> s.getValue())
                    .sum();
            Map<String, Integer> totalSkills = new HashMap<>();
            totalSkills.put(k, sum);
            totalSkills.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()));
            System.out.printf("%s: %d skill%n", k, sum);
            v.entrySet().stream()
                    .sorted((s1, s2) -> {
                        int result = s2.getValue().compareTo(s1.getValue());
                        if (result == 0) {
                            result = s1.getKey().compareTo(s2.getKey());
                        }
                        return result;
                    })
                    .forEach(s -> System.out.printf("- %s <::> %d%n", s.getKey(), s.getValue()));
        });
       /* pool.entrySet().stream()
                .sorted((f, s) -> Integer.compare(s.getValue().entrySet().stream().mapToInt(v -> v.getValue()).sum()
                            , f.getValue().entrySet().stream().mapToInt(v -> v.getValue()).sum()))
                .forEach((k,v) -> {
                    System.out.printf("%s: %d skill%n", k, sum);
                    v.entrySet().stream()
                            .sorted((s1, s2) -> {
                                int result = s2.getValue().compareTo(s1.getValue());
                                if (result == 0) {
                                    result = s1.getKey().compareTo(s2.getKey());
                                }
                                return result;
                            })
                            .forEach(s -> System.out.printf("- %s <::> %d%n", s.getKey(), s.getValue()));
                });*/
    }

    private static int getCurrentSkill(Map<String, Map<String, Integer>> pool, String currentPosition, String player1) {
        return pool.get(player1).get(currentPosition);
    }

    private static String getCurrentPosition(Map<String, Map<String, Integer>> pool, String player1, String player2) {
        Map<String, Integer> current1 = pool.get(player1);
        Map<String, Integer> current2 = pool.get(player2);
        for (Map.Entry<String, Integer> entry : current1.entrySet()) {
            for (Map.Entry<String, Integer> keyEntry : current2.entrySet()) {
                if (keyEntry.getKey().equals(entry.getKey())) {
                    return keyEntry.getKey();
                }
            }
        }
        return null;
    }

    private static boolean doesPlayerExist(Map<String, Map<String, Integer>> pool, String player) {
        for (Map.Entry<String, Map<String, Integer>> entry : pool.entrySet()) {
            if (entry.getKey().equals(player)) {
                return true;
            }
        }
        return false;
    }
}
