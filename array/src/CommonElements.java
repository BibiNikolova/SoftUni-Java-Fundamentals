import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Hey hello 2 4
        //10 hey 4 hello
        String input = scanner.nextLine();
        String input2 = scanner.nextLine();
        String[] splitedInput = input.split(" ");
        String[] splitedInput2 = input2.split(" ");

        for (int i = 0; i < splitedInput.length; i++) {
            for (int j = 0; j < splitedInput2.length; j++) {
                if(splitedInput[i].equals(splitedInput2[j])) {
                    String sameWord = splitedInput[i];
                    System.out.print(sameWord + " ");
                }
            }
        }
    }
}
