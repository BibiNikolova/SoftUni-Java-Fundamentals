package mapsLambdaStreamAPI.src;

import java.security.KeyStore;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Moba {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> pool = new HashMap<>();

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

        pool.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    AtomicInteger result1 = new AtomicInteger();
                    entry1.getValue().forEach((key, value) -> result1.addAndGet(value));
                    AtomicInteger result2 = new AtomicInteger();
                    entry2.getValue().forEach((key, value) -> result2.addAndGet(value));
                    return Integer.compare(result2.get(), result1.get());
                })
                .forEach(entry -> {
                    int sum = entry.getValue().values().stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    System.out.printf("%s: %d skill%n", entry.getKey(), sum);
                    entry.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue()
                                    .reversed()
                                    .thenComparing(Map.Entry.comparingByKey()))
                            .forEach(internalEntry -> System.out.printf("- %s <::> %d%n", internalEntry.getKey(), internalEntry.getValue()));
                });
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
