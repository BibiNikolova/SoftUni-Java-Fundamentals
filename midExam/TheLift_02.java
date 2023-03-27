package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int capacity = 0;
        for (int i = 0; i < wagons.size(); i++) {
            capacity += wagons.get(i);
        }
        int freeCapacity = (wagons.size() * 4) - capacity;
        for (int i = 0; i < wagons.size(); i++) {
            int seats = wagons.get(i);
            if (seats < 4) {
                int freeSpace = 4 - seats;
                if (people - freeSpace >= 0) {
                    wagons.set(i, seats + freeSpace);
                    people -= freeSpace;
                    freeCapacity -= freeSpace;
                } else {
                    wagons.set(i, seats + people);
                    freeCapacity -= people;
                    people = 0;
                    break;
                }
            }
        }
        if (people >= 0 && freeCapacity <= 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", people);
        } else {
            System.out.println("The lift has empty spots!");
        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
