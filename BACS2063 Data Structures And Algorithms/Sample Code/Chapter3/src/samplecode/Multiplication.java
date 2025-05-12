package samplecode;
/**
 * Refactoring carried out to extract method for the lines of code that perform 
 * the computation of the multiplication to facilitate code reuse.
 * 
 * @version 2.0
 */


public class Multiplication {

  public static long multiply1(long firstOperand, long secondOperand) {
    long product = 0;
    for (long counter = secondOperand; counter > 0; counter--) {
      product += firstOperand;
    }
    return product;
  }

  public static long multiply2(long firstOperand, long secondOperand) {
    long product = 0;
    int secondOperandLength = String.valueOf(secondOperand).length();
    for (int digitPosition = 1; digitPosition <= secondOperandLength; digitPosition++) {
      int digit = (int) (secondOperand - (secondOperand / 10) * 10);
      for (int counter = digit; counter > 0; counter--) {
        product = product + firstOperand;
      }
      secondOperand = secondOperand / 10; // discard last digit
      firstOperand = 10 * firstOperand; // tack zero on right
    } 
    return product;
  }

}
