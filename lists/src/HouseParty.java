import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommands = Integer.parseInt(scanner.nextLine());

        List<String> guestLIst = new ArrayList<>();
        for (int i = 0; i < numCommands; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            if (input[2].equals("going!")) {
                if (!isInTheGuestList(guestLIst, input)) {
                    guestLIst.add(name);
                } else {
                    System.out.printf("%s is already in the list!\n", name);
                }
            } else if(input[2].equals("not")) {
                if(isInTheGuestList(guestLIst, input)) {
                    guestLIst.remove(name);
                } else {
                    System.out.printf("%s is not in the list!\n", name);
                }
            }
        }
        for (String input : guestLIst) {
            System.out.println(input);
        }
    }

    private static boolean isInTheGuestList(List<String> guestList, String[] input) {
        for (int i = 0; i < guestList.size(); i++) {
            if(guestList.get(i).equals(input[0])) {
                return true;
            }
        }
        return false;
    }
}
