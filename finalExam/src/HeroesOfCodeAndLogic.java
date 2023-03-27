import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            List<Integer> points = new ArrayList<>();
            points.add(Integer.parseInt(input[1]));
            points.add(Integer.parseInt(input[2]));

            heroes.put(input[0], points);
        }
        String actions = scanner.nextLine();
        while (!"End".equals(actions)) {
            String command = actions.split(" \\- ")[0];
            String heroName = actions.split(" \\- ")[1];
            switch (command) {
                case "CastSpell":
                    printCastTheSpell(heroes, heroName, actions);
                    break;
                case "TakeDamage":
                    printTakenDamage(heroes, heroName, actions);
                    break;
                case "Recharge":
                    printRecharged(heroes, heroName, actions);
                    break;
                case "Heal":
                    printHealed(heroes, heroName, actions);
                    break;
            }
            actions = scanner.nextLine();
        }
        heroes.entrySet().forEach(e ->  System.out.printf("%s%n  HP: %d%n  MP: %d%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }

    private static void printHealed(Map<String, List<Integer>> heroes, String heroName, String actions) {
        int hp = heroes.get(heroName).get(0);
        int amount = Integer.parseInt(actions.split(" \\- ")[2]);
        if (hp + amount > 100) {
            heroes.get(heroName).set(0,100);
        } else {
            heroes.get(heroName).set(0,hp + amount);
        }
        System.out.printf("%s healed for %d HP!%n", heroName, heroes.get(heroName).get(0) - hp);

    }

    private static void printRecharged(Map<String, List<Integer>> heroes, String heroName, String actions) {
        int mp = heroes.get(heroName).get(1);
        int amount = Integer.parseInt(actions.split(" \\- ")[2]);
        if (mp + amount > 200) {
            heroes.get(heroName).set(1,200);
        } else {
            heroes.get(heroName).set(1,mp + amount);
        }
        System.out.printf("%s recharged for %d MP!%n", heroName, heroes.get(heroName).get(1) - mp);

    }

    private static void printTakenDamage(Map<String, List<Integer>> heroes, String heroName, String actions) {
        int hp = heroes.get(heroName).get(0);
        int demage = Integer.parseInt(actions.split(" \\- ")[2]);
        String attacker = actions.split(" \\- ")[3];

        if (hp - demage > 0) {
            List<Integer> currentValue = heroes.get(heroName);
            currentValue.remove(0);
            currentValue.add(0, hp - demage);
            heroes.put(heroName, currentValue);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, demage, attacker, currentValue.get(0));
        } else {
            heroes.remove(heroName);
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
        }
    }

    private static void printCastTheSpell(Map<String, List<Integer>> heroes, String heroName, String actions) {
        int mp = heroes.get(heroName).get(1);
        int mpNeeded = Integer.parseInt(actions.split(" \\- ")[2]);
        String spellName = actions.split(" \\- ")[3];

        if (mp >= mpNeeded) {
            List<Integer> currentValue = heroes.get(heroName);
            currentValue.remove(1);
            currentValue.add(mp - mpNeeded);
            heroes.put(heroName, currentValue);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentValue.get(1));
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }
}
