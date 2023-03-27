import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceSaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());
        double totalSaber = priceSaber * Math.ceil(students * 1.1);
        int freeBelts = students / 6;
        double totalSum = totalSaber + ((students - freeBelts) * priceBelt) + students * priceRobe;
        if(money >= totalSum) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", Math.abs(money - totalSum));
        }
    }
}
