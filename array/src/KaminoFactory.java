import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int newMaxLength = 0;
        int newMaxLengthIndex = 0;
        int maxSum = 0;
        int sum = 0;
        int inputNum = 0;
        int sample = 0;
        String temp = "";

        while (!"Clone them!".equals(input)) {
            String seq = "";
            for (int i = 0; i < input.length(); i++) {
                if ('!' != input.charAt(i)) {
                    seq += input.charAt(i) + " ";
                }
            }

            int[] sequence = stream(seq.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] lisLengths = new int[length];//дължината на поредицата
            for (int i = 0; i < lisLengths.length; i++) {
                lisLengths[i] = 1;
            }
            for (int j : sequence) {//сумира единиците в низа
                if (j == 1) {
                    maxSum += 1;
                }
            }

            for (int i = 1; i < sequence.length; i++) {// за всяко едно число
                if (sequence[i] == sequence[i - 1] && sequence[i] == 1) {//сравняваме с предходното дали можем да добавим 1 в поредицата
                    lisLengths[i] += 1;// заменяме текущия, за да обозначим нов макс
                }
            }

            int maxLength = 0;// максималната дължина на поредицата от единици(1)
            int maxLengthIndex = 0;//позицията, която показва края на макс дължина
            for (int i = 0; i < lisLengths.length; i++) {
                if (lisLengths[i] > maxLength) {
                    maxLength = lisLengths[i];
                    maxLengthIndex = i;
                }
            }

            boolean isMaxLength = false;
            boolean isMaxLeft = false;
            boolean isMaxSum = false;

            //longest subsequence of ones
            int maxLeftIndex = maxLengthIndex - maxLength + 1;//позицията, от която започва поредицата
            inputNum++;

            if (maxLength > newMaxLength && maxLength != 1) { //ако в текущата поредица има по-голяма дължина на низ от единици
                newMaxLength = maxLength;// присвояваме новата макс дължина
                isMaxLength = true;
            } else if (maxLength == newMaxLength && maxLength > 1) {
                //leftmost starting index
                if (maxLeftIndex < newMaxLengthIndex) {// ako текущия е на предходна позиция
                    isMaxLeft = true;
                    //greater sum
                } else if (sum < maxSum) {
                        isMaxSum = true;
                }
            }

            if (isMaxLength || isMaxLeft || isMaxSum) {
                newMaxLengthIndex = maxLeftIndex;//това отмества наляво
                temp = seq;
                sum = maxSum;
                sample = inputNum;
            }
            maxSum = 0;
            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", sample, sum);
        String[] finalArr = temp.split(" ");
        for (String s : finalArr) {
            System.out.print(s + " ");
        }
    }
}

