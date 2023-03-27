import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> tickets = Arrays.stream(scanner.nextLine().split("[, ]+"))
                .collect(Collectors.toList());

        Pattern pattern = Pattern.compile("(@{6,9}|#{6,9}|\\${6,9}|\\^{6,9})+");
        Pattern pattern1 = Pattern.compile("@{20}|#{20}|\\${20}|\\^{20}");


        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String leftTicket = ticket.substring(0, 10);
                String rightTicket = ticket.substring(10);
                StringBuilder left = new StringBuilder();
                StringBuilder right = new StringBuilder();

                Matcher matcher = pattern.matcher(leftTicket);
                if (matcher.find()) {
                    left.append(matcher.group());
                }
                matcher = pattern.matcher(rightTicket);
                if (matcher.find()) {
                    right.append(matcher.group());
                }

                if (!getMatch(left, right)) {
                    System.out.println("ticket \"" + ticket + "\" - no match");
                } else {
                    if (isJackpot(ticket, pattern1)) {
                        System.out.println("ticket \"" + ticket + "\" - 10" + ticket.charAt(0) + " Jackpot!");
                    } else {
                        String winSymCount = printCount(left, right);
                        System.out.println("ticket \"" + ticket + "\" - " + winSymCount);
                    }
                }
            }
        }
    }

    private static String printCount(StringBuilder left, StringBuilder right) {
        StringBuilder sb = new StringBuilder();
        int length = 0;

        if (left.length() - right.length() >= 0) {
            length = right.length();
        } else {
            length = left.length();
        }
        sb.append(length);
        sb.append(left.charAt(0));
        return sb.toString();
    }


    private static boolean isJackpot(String ticket, Pattern pattern1) {
        Matcher matcher = pattern1.matcher(ticket);
        return matcher.find();
    }

    private static boolean getMatch(StringBuilder left, StringBuilder right) {
        if(left.length()!=0 && right.length()!=0){
            if (left.substring(left.length() - 1).equals(right.substring(right.length() - 1))) {
                return true;
            }
        }
        return false;
    }
}


