import java.math.*;

public class TestNumber{
  public static void main(String[] args) {
  	//Immutable objects
  	Integer d1 = 90;
		Integer d2 = 90;
		Integer d3 = d1;
		System.out.println(d1 == d2);
		System.out.println(d1 == d3);
		System.out.println(d3 == d2);
		
		d1=d1+20;;
		System.out.println(d1 == d2);
		System.out.println(d1 == d3);
		System.out.println(d3 == d2);
		
 		Double doubleObject = new Double(5.0);
		Double doubleObject1 = new Double("5.0");
		Integer integerObject = new Integer(5);
		Integer integerObject1 = new Integer("5");
		
		System.out.println("doubleObject  : " + doubleObject);
		System.out.println("doubleObject1 : " + doubleObject1);
		System.out.println("integerObject : " + integerObject);
		System.out.println("integerObject1: " + integerObject1);
	
		System.out.println("\n----------------------------------------P01\n");
	
		System.out.println("Integer.MAX_VALUE: "+ Integer.MAX_VALUE);
		//2,147,483,647

		System.out.println("Double.MAX_VALUE:  " + Double.MAX_VALUE);
		//1.79769313486231570e+308d

		System.out.println("Float.MIN_VALUE:   " + Float.MIN_VALUE);
		//1.4E-45
	
		System.out.println("\n----------------------------------------P02\n");
	
		//Convert doubleObject¡¯s value to a long variable l:
		Double doubleObject2 = new Double("1234567890.1234567890");
		long l = doubleObject2.longValue(); // Note it truncates

		//Assign the int value of integerObject to i:
		Integer integerObject2 = new Integer("1234567890");
		int i = integerObject2.intValue();

		//Converts double d to a string s:
		double d = 5.9;
		Double doubleObject3 = new Double(d);
		String s = doubleObject3.toString();

		System.out.println("long l  : " + l);
		System.out.println("int i   : " + i);
		System.out.println("String s: " + s);
	
		System.out.println("\n----------------------------------------P03\n");
	
		Double doubleObject4 = Double.valueOf("12.4");
		Integer integerObject4 = Integer.valueOf("12");
		System.out.println("doubleObject4 : " + doubleObject4);
		System.out.println("integerObject4: " + integerObject4);
	
		System.out.println("\n----------------------------------------P04\n");
	
		System.out.println("Integer.parseInt('11',2) : " + Integer.parseInt("11",2));
		System.out.println("Integer.parseInt('12',8) : " + Integer.parseInt("12",8));
		System.out.println("Integer.parseInt('13',10): " + Integer.parseInt("13",10));
		System.out.println("Integer.parseInt('1A',16): " + Integer.parseInt("1A",16));

 }   
}