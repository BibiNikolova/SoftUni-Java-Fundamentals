import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<String> letters = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String line = scanner.nextLine();
        while (!line.equals("3:1")) {
            String[] data = line.split("\\s+");
            String command = data[0];
            switch (command) {
                case "merge":
                    List<String> result = new ArrayList<>();
                    int start = Math.max(0, Integer.parseInt(data[1]));
                    int end = Math.min(Integer.parseInt(data[2]), letters.size() - 1);
                    if (start > 0 && start < letters.size()) {
                        result.addAll(letters.subList(0, start));
                    }
                    if (start < letters.size()) {

                        List<String> mergedElements = letters.subList(start, end + 1);
                        String merged = "";
                        for (String mergedElement : mergedElements) {
                            merged += mergedElement;
                        }
                        result.add(merged);
                    }
                    if (end < letters.size()){
                    result.addAll(letters.subList(end + 1, letters.size()));
                }
                if (!result.isEmpty()) {
                    letters = result;
                }
                break;
                case "divide":
                    result = new ArrayList<>();
                    int index = Integer.parseInt(data[1]);
                    int parts = Integer.parseInt(data[2]);
                    String element = letters.get(index);
                    if (element.length() % parts == 0) {
                        int symbols = element.length() / parts;
                        for (int i = 0; i < parts; i++) {
                            //add first element
                            result.add(element.substring(0, symbols));
                            //remove first element
                            element = element.substring(symbols);
                        }
                        letters.remove(index);
                        letters.addAll(index, result);

                    } else {
                        int symbols = element.length() / parts;
                        for (int i = 0; i < parts; i++) {
                            if(i == parts - 1 ){
                                result.add(element);
                            } else {
                                //add first element
                                result.add(element.substring(0, symbols));
                                //remove first element
                                element = element.substring(symbols);
                            }
                        }
                        letters.remove(index);
                        letters.addAll(index, result);

                    }

                    break;
            }
            line = scanner.nextLine();
        }
        letters.forEach(s -> System.out.print(s + " "));
    }
}


