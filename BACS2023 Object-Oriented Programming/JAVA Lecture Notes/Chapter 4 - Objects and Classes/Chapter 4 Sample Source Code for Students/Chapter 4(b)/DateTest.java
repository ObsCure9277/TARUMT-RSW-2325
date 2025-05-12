
import  java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter; 

public class DateTest {
  public static void main(String[] args) {
   
      LocalDate today = LocalDate.now();
      LocalDate aprilFool = LocalDate.of(2020, Month.APRIL, 1);

      System.out.println("April fool : " + aprilFool.toString());
      System.out.println("Today : " + today.toString());
      
      DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
      String formatDateTime = today.format(format);  
      System.out.println("After Formatting: " + formatDateTime);  
  }
}
