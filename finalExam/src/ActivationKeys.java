import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String line = scanner.nextLine();
        while (!"Generate".equals(line)){
            String command = line.split(">>>")[0];
            switch (command){
                case"Contains":
                    String substring = line.split(">>>")[1];
                    if(activationKey.contains(substring)){
                        System.out.println(activationKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case"Flip":
                    String upperOrLower = line.split(">>>")[1];
                    int startIndex = Integer.parseInt(line.split(">>>")[2]);
                    int endIndex = Integer.parseInt(line.split(">>>")[3]);
                    String oldSub = activationKey.substring(startIndex,endIndex);
                    if(upperOrLower.equals("Upper")){
                        String newSub = activationKey.substring(startIndex,endIndex).toUpperCase();
                        activationKey = activationKey.replace(oldSub, newSub);
                    } else {
                        String newSub = activationKey.substring(startIndex,endIndex).toLowerCase();
                        activationKey = activationKey.replace(oldSub, newSub);
                    }
                    System.out.println(activationKey);
                    break;
                case"Slice":
                    int startIndex1 = Integer.parseInt(line.split(">>>")[1]);
                    int endIndex1 = Integer.parseInt(line.split(">>>")[2]);
                    String substring1 = activationKey.substring(startIndex1,endIndex1);
                    activationKey = activationKey.replace(substring1, "");
                    System.out.println(activationKey);
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
