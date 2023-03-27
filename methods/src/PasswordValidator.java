import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if(!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if(!isValidContent(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isValidDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if(isValidLength(password) && isValidContent(password) && isValidDigits(password)){
            System.out.println("Password is valid");
        }
    }
    //валидираме дължината
    private  static boolean isValidLength(String password) {
        return(password.length() >= 6 && password.length() <= 10);
    }
    //валидираме съдържание
    private static boolean isValidContent(String password) {
        for(char symbol :password.toCharArray()){
            if(!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
    //валидираме брой цифри
    private static boolean isValidDigits(String password){
        int countDigit = 0;
        for (char symbol : password.toCharArray()) {
            if(Character.isDigit(symbol)) {
                countDigit ++;
            }
        }
        return  countDigit >= 2;
    }
}
