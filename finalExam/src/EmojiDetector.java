import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int num = 1;

        Matcher matcherNum = Pattern.compile("\\d+").matcher(input);
        while (matcherNum.find()) {
            String currentNum = matcherNum.group();
            char[] currentN = currentNum.toCharArray();
            for (char c : currentN) {
                String cOfN = String.valueOf(c);
                num *= Integer.parseInt(cOfN);
            }
        }

        Map<String, Integer> emojies = new LinkedHashMap<>();

        Matcher matcher = Pattern.compile("([:]{2}|[*]{2})(?<name>[A-Z][a-z]{2,})\\1").matcher(input);
        while (matcher.find()) {
            String emojiesName = matcher.group("name");
            int value = 0;
            for (char c : emojiesName.toCharArray()) {
                int v = c;
                value += v;
            }
            emojies.put(matcher.group(), value);
        }
        System.out.println("Cool threshold: " + num);
        System.out.println(emojies.size() + " emojis found in the text. The cool ones are:");
        int finalNum = num;
        emojies.entrySet().forEach(e-> {
            if(e.getValue() > finalNum){
                System.out.println(e.getKey());
           }
        });
    }
}
