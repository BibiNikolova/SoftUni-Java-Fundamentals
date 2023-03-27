import java.util.Arrays;
import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Read a list of integers and find the longest increasing subsequence (LIS).
// If several such exist, print the leftmost.
        int[] list = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        //когато е трудно да гледаме напред в поредицата,
        //гледаме назад и динамично оптимизираме.
        int[] lisLengths = new int[list.length];
        int[] lisPrev = new int[list.length];
        for (int i = 0; i < lisLengths.length; i++) {
            lisLengths[i] = 1;
            lisPrev[i] = -1;
        }
        for (int currentIndex = 1; currentIndex < list.length; currentIndex++) {// за всяко едно число
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {//ходим по предходните
                if (list[prevIndex] < list[currentIndex]) {//гледаме дали можем да добавим съответното число в поредицата
                    int candidate = lisLengths[prevIndex] + 1;//ако можем, гледамe дължината до него и добавяме 1
                    if (candidate > lisLengths[currentIndex]) {// ако е по-голяма от текущата дължина
                        lisLengths[currentIndex] = candidate;// заменяме текущия, за да обозначим нов макс
                        lisPrev[currentIndex] = prevIndex;// тук ще кажем откъде сме дошли
                    }
                }
            }
        }
        int maxLength = 0;
        int maxLengthIndex = 0;
        for (int i = 0; i < lisLengths.length; i++) {
            if (lisLengths[i] > maxLength) {
                maxLength = lisLengths[i];
                maxLengthIndex = i;
            }
        }
        int index = maxLengthIndex;
        int[] lis = new int[maxLength];
        int pos = 0;
        while (index != -1){
            lis[pos] = list[index];
            pos ++;
            index = lisPrev[index];
        }
        for (int i = lis.length - 1; i >= 0 ; i--) {
            System.out.print(lis[i] + " ");
        }

    }
}
