import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> users = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)){

            String company = input.split(" -> ")[0];
            String id = input.split(" -> ")[1];

            if(!users.containsKey(company)){
                users.put(company, new ArrayList<>());
                users.get(company).add(id);
            } else if(!users.get(company).contains(id)) {
                users.get(company).add(id);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            for (String s : entry.getValue()) {
                System.out.println("-- " + s);
            }
        }
    }
}
