import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceBook = new HashMap<>();

        List<String> allUsers = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"Lumpawaroo".equals(input)) {
            if (input.contains("|")) {
                //•	If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
                //•	Only if there is no such force user in any force side -> add the force user to the corresponding side.
                //•	If there is such force user already -> skip the command and continue to the next operation.
                String side = input.split(" \\| ")[0];
                String user = input.split(" \\| ")[1];

                if (!forceBook.containsKey(side)) {
                    forceBook.put(side, new ArrayList<>());
                }
                if (!allUsers.contains(user)) {
                    allUsers.add(user);
                    forceBook.get(side).add(user);
                }

            } else if (input.contains(" -> ")) {
                //•	If there is such force user already -> change their side.
                //•	If there is no such force user in any force side -> add the force user to the corresponding force side.
                //•	If there is no such force user and no such force side -> create new force side and add the force user to the corresponding side.
                //•	Then you should print on the console: "{force_user} joins the {force_side} side!".
                String user1 = input.split(" -> ")[0];
                String changedSide = input.split(" -> ")[1];

                if (!forceBook.containsKey(changedSide)) {
                    forceBook.put(changedSide, new ArrayList<>());
                }
                if (!allUsers.contains(user1)) {
                    allUsers.add(user1);
                    forceBook.get(changedSide).add(user1);
                    System.out.printf("%s joins the %s side!%n", user1, changedSide);
                } else {
                    for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                        if (entry.getValue().contains(user1) && !entry.getKey().equals(changedSide)) {
                            entry.getValue().remove(user1);
                            forceBook.get(changedSide).add(user1);
                            System.out.printf("%s joins the %s side!%n", user1, changedSide);
                            break;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (String s : entry.getValue()) {
                    System.out.println("! " + s);
                }
            }
        }
    }
}
