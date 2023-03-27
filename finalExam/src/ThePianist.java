import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plays = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> playList = new LinkedHashMap<>();

        for (int i = 0; i < plays; i++) {
            String input = scanner.nextLine();
            String play = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String tone = input.split("\\|")[2];

            List<String> value = new ArrayList<>();
            value.add(composer);
            value.add(tone);

            playList.put(play, value);
        }
        String line = scanner.nextLine();
        while (!"Stop".equals(line)) {
            String[] commands = line.split("\\|");
            String play = commands[1];
            switch (commands[0]) {
                case "Add":
                    String composer = commands[2];
                    String tone = commands[3];
                    if (playList.containsKey(play)) {
                        System.out.println(play + " is already in the collection!");
                    } else {
                        List<String> value = new ArrayList<>();
                        value.add(composer);
                        value.add(tone);

                        playList.put(play, value);
                        System.out.printf("%s by %s in %s added to the collection!%n", play, composer, tone);
                    }
                    break;
                case "Remove":
                    if (playList.containsKey(play)) {
                        playList.remove(play);
                        System.out.printf("Successfully removed %s!%n", play);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", play);
                    }
                    break;
                case "ChangeKey":
                    if (playList.containsKey(play)) {
                        List<String> current = playList.get(play);
                        current.remove(1);
                        current.add(commands[2]);
                        playList.put(play, current);
                        System.out.printf("Changed the key of %s to %s!%n", play, commands[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", play);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        playList.entrySet().forEach(entry ->
                System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
