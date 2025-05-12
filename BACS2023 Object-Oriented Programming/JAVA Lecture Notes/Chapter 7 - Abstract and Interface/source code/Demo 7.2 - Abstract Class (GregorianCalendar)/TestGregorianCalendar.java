import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestGregorianCalendar {
  public static void main(String[] args){
  
  // Construct a Gregorian calendar for the current date and time
  /** java.util.Calendar calendar = new java.util.GregorianCalendar(); */
  Calendar calendar = new GregorianCalendar();
  
  System.out.println("Year\tMonth\tDate\tHour\tHour24\tMinute\tSecond");
  System.out.println(
  calendar.get(Calendar.YEAR) + "\t" +
  calendar.get(Calendar.MONTH) + "\t\t" +	
  calendar.get(Calendar.DATE) + "\t\t" +
  calendar.get(Calendar.HOUR) + "\t\t" +
  calendar.get(Calendar.HOUR_OF_DAY) + "\t\t" +	
  calendar.get(Calendar.MINUTE) + "\t\t" +	
  calendar.get(Calendar.SECOND));
  
  System.out.println("\nDay of week: " + calendar.get(Calendar.DAY_OF_WEEK));	
  System.out.println("Day of month: " + calendar.get(Calendar.DAY_OF_MONTH));	
  System.out.println("Day of year: " + calendar.get(Calendar.DAY_OF_YEAR));  
  System.out.println("\nWeek of month: " + calendar.get(Calendar.WEEK_OF_MONTH));	
  System.out.println("Week of year: " + calendar.get(Calendar.WEEK_OF_YEAR));	
  
  calendar.set(2009, 9, 12);	
  System.out.println("\n\nYear\tMonth\tDate");
  System.out.println(
  calendar.get(Calendar.YEAR) + "\t" +
  calendar.get(Calendar.MONTH) + "\t\t" +	
  calendar.get(Calendar.DATE) );
  
  calendar.add(Calendar.MONTH, 9);	
  System.out.println("\n\nYear\tMonth\tDate");
  System.out.println(
  calendar.get(Calendar.YEAR) + "\t" +
  calendar.get(Calendar.MONTH) + "\t\t" +	
  calendar.get(Calendar.DATE) );
  }  		
}
