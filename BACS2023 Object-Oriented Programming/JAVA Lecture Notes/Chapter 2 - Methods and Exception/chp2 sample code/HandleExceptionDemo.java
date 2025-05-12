import java.util.*;

public class HandleExceptionDemo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continueInput = true;

    do {
      try {
        System.out.print("\nEnter an integer: ");
        int number = scanner.nextInt();

        // Display the result
        System.out.println("\nThe number entered is " + number);

        continueInput = false;
      }
      catch (InputMismatchException ex) {
        System.out.println("Try again. (" +
          "Incorrect input: an integer is required)");
        scanner.nextLine();
      }
    } while (continueInput);
  }
}
