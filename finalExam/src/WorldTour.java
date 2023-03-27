import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!"Travel".equals(input)) {
            String[] commands = input.split(":");
            switch (commands[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    if (isValidIndex(stops, index)) {
                        stops.insert(index, commands[2]);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    if (isValidIndex(stops, startIndex) && isValidIndex(stops, endIndex)) {
                        stops.replace(startIndex, endIndex + 1, "");
                    }
                    break;
                case "Switch":
                    String old = commands[1];
                    String newStop = commands[2];
                    if(stops.toString().contains(old)){
                       stops.replace(stops.indexOf(old),stops.indexOf(old) + old.length(), newStop);
                       //stops.toString().replace(old, newStop);
                    }
                    break;
            }
            System.out.println(stops);
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static boolean isValidIndex(StringBuilder stops, int index) {
        return index >= 0 && index <= stops.length() - 1;
    }
}
