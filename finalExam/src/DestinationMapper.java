import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();
        List<String> destinations = new ArrayList<>();
        int points = 0;

        Pattern pattern = Pattern.compile("([=\\/])(?<place>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(places);
        while (matcher.find()) {
            String place = matcher.group("place");
            destinations.add(place);
            points += place.length();
        }
        System.out.println("Destinations: " + String.join( ", ",destinations));
        System.out.println("Travel Points: " + points);
    }
}
