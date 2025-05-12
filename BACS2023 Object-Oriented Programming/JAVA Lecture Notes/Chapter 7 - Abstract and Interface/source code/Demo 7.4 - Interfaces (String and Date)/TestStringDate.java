import java.util.Date;

public class TestStringDate{

    public static void main(String[] args) {
    
    	String s1 = "abcdef";
    	String s2 = "abcdee";
    	String s3 = (String)Max.max(s1,s2);    	
    	System.out.println("s3 = " + s3);  
    		
    	Date d1 = new Date();
    	Date d2 = new Date();
    	Date d3 = (Date)Max.max(d1,d2);    	
    	System.out.println("d3 = " + d3);     		 	
    }   
}