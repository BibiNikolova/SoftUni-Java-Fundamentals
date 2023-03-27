import java.util.*;

public class A3_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroes = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String command = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            switch (command) {
                case "Enroll":
                    if (doesHeroExist(heroes, name)) {
                        System.out.println(name + " is already enrolled.");
                    } else {
                        heroes.put(name, new ArrayList<>());
                    }
                    break;
                case "Learn":
                    String spellName = input.split("\\s+")[2];
                    if (doesHeroExist(heroes, name)) {
                        if (doesAlreadyHaveSpellName(heroes, spellName)) {
                            System.out.println(name + " has already learnt " + spellName + ".");
                        } else {
                            heroes.get(name).add(spellName);
                        }
                    } else {
                        System.out.println(name + " doesn't exist.");
                    }
                    break;
                case "Unlearn":
                    String unspellName = input.split("\\s+")[2];
                    if (doesHeroExist(heroes, name)) {
                        if (doesAlreadyHaveSpellName(heroes, unspellName)) {
                            heroes.get(name).remove(unspellName);
                        } else {
                            System.out.println(name + " doesn't know " + unspellName + ".");
                        }
                    } else {
                        System.out.println(name + " doesn't exist.");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Heroes:");
        for (Map.Entry<String, List<String>> entry : heroes.entrySet()) {
            System.out.println("== " + entry.getKey() + ": " + String.join(", ",entry.getValue()));
        }
    }

    private static boolean doesAlreadyHaveSpellName(Map<String, List<String>> heroes, String spellName) {
        for (Map.Entry<String, List<String>> entry : heroes.entrySet()) {
            if (entry.getValue().contains(spellName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesHeroExist(Map<String, List<String>> heroes, String name) {
        for (Map.Entry<String, List<String>> entry : heroes.entrySet()) {
            if (entry.getKey().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
