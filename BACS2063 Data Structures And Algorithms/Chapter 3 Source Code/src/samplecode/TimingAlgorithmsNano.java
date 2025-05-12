package samplecode;

/**
 *
 * @author Lim
 */
public class TimingAlgorithmsNano {
    
    public static void main(String[] args) {
    long firstOperand = 7562;
    long secondOperand = 100000000;
        
    System.out.println("\nAlgorithm 1");
    System.out.println("===========");
    
    long product = 0;
    long startTime1 = System.nanoTime();
    for (long counter = secondOperand; counter > 0; counter--) {
      product += firstOperand;
    }
    System.out.println("The product of " + firstOperand + " and " + secondOperand + " is " + product);
    long endTime1 = System.nanoTime();
    long elapsedTime1 = endTime1 - startTime1;
    System.out.println("Execution time for Algorithm 1: " + elapsedTime1 + " ns\n\n");
    
    System.out.println("Algorithm 2");
    System.out.println("===========");
    
    product = 0;
    long startTime2 = System.nanoTime();
    long firstOperand1 = 7562;
    long secondOperand1 = 100000000; 
    int secondOperandLength = String.valueOf(secondOperand1).length();
    for (int digitPosition = 1; digitPosition <= secondOperandLength; digitPosition++) {
      int digit = (int) (secondOperand1 - (secondOperand1 / 10) * 10);
      for (int counter = digit; counter > 0; counter--) {
        product = product + firstOperand1;
      }
      secondOperand1 = secondOperand1 / 10; // discard last digit
      firstOperand1 = 10 * firstOperand1; // tack zero on right
    } 
    
    System.out.println("The product of " + firstOperand + " and " + secondOperand + " is " + product);
    long endTime2 = System.nanoTime();
    long elapsedTime2 = endTime2 - startTime2;
    System.out.println("Execution time for Algorithm 2: " + elapsedTime2 + " ns\n\n");
  }
}
