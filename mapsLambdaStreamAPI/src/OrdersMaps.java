import java.util.*;

public class OrdersMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Double> priceList = new LinkedHashMap<>();
        Map<String, Integer> quantityList = new LinkedHashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] line = input.split("\\s+");
            String article = line[0];
            double price = Double.parseDouble(line[1]);
            int quantity = Integer.parseInt(line[2]);

            if(!priceList.containsKey(article)){
                priceList.put(article, price);
                quantityList.put(article,quantity);

            } else {
                quantityList.put(article, quantityList.get(article) + quantity);
                if(price != priceList.get(article)){
                    priceList.put(article, price);
                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : priceList.entrySet()) {
            String name = entry.getKey();
            double sum = entry.getValue() * quantityList.get(name);
            System.out.printf("%s -> %.2f%n",entry.getKey(), sum);

        }

    }
}
