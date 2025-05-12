// Filename: TestDate.java

public class TestDate {
	public static void main(String[] args) {
		java.util.Date date = new java.util.Date();
		
		System.out.println("The elapsed time since Jan 1, 1970 is " + 
			date.getTime() + " milliseconds");
		System.out.println(date.toString());
	}
}