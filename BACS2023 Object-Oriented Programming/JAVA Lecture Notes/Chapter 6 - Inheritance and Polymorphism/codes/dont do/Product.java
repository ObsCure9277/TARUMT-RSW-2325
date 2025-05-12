
import java.util.*;

public class Product {
	private String name;
	private String id;
	
	//.....
	
	Scanner scan = new Scanner(System.in);
	public int menu(){
		System.out.printf("%s\n%s\n%s\n", 
			 "ABC Store", 
			 "1. Product Detail", 
			 "2. New Product");
	 	System.out.print("Enter Selection : " );
		return scan.nextInt();
	}
    
    
}