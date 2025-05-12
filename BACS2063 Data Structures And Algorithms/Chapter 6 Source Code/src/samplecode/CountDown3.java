package samplecode;

import java.util.Scanner;

public class CountDown3 {
  
  public void countDown(int n) {
    System.out.println(n);
    if (n > 1) {
      countDown(n - 1);
    }
  }
  
  public static void main(String[] args) {
    CountDown3 c = new CountDown3();
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a non-negative integer number: ");
    int number = scanner.nextInt();

    System.out.printf("\nOutput for countDown(%d):\n", number);
    c.countDown(number);
  }
}
