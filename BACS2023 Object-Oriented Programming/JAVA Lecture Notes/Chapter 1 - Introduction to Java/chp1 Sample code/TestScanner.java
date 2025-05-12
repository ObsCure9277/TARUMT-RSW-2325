import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int intValue = scanner.nextInt();
        System.out.println("You entered the integer " + intValue);
        
        System.out.print("Enter a double value: ");
        double doubleValue = scanner.nextDouble();
        System.out.println("You entered the double value " + doubleValue);
        scanner.nextLine();
        System.out.print("Enter a string without space: ");
        String string = scanner.nextLine();
        System.out.println("You entered the string " + string);
    }

}
