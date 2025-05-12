public class TestArraysClass {
	public static void main(String[] args) {
		double[] numbers = {6.1, 4.3, 8.4, 2.7, 5.5, 9.7, 1.1, 3.6};
			
		System.out.print("array numbers before sort: ");
		ArrayMethods.displayArray(numbers);
		java.util.Arrays.sort(numbers);
		System.out.print("array numbers after sort : ");
		ArrayMethods.displayArray(numbers);
				
		char[] chars = {'a', 'A', '4', 'F', 'D', 'P'};
		
		System.out.print("\narray chars before sort: ");
		ArrayMethods.displayArray(chars);
		java.util.Arrays.sort(chars, 1, 3);
		System.out.print("array chars after sort : ");
		ArrayMethods.displayArray(chars);
		
		int[] integers = {90, 80, 70, 60, 50, 40, 30, 20, 10};
		System.out.print("\narray integers before sort: ");
		ArrayMethods.displayArray(integers);
		java.util.Arrays.sort(integers);
		System.out.print("array integers after sort : ");
		ArrayMethods.displayArray(integers);
		
		System.out.println("\nSearching for element 10...  Index = " + 
			java.util.Arrays.binarySearch(integers, 10));
		System.out.println("\nSearching for element 50...  Index = " + 
			java.util.Arrays.binarySearch(integers, 50));
		System.out.println("\nSearching for element 90...  Index = " + 
			java.util.Arrays.binarySearch(integers, 90));
		System.out.println("\nSearching for element 77...  Index = " + 
			java.util.Arrays.binarySearch(integers, 77));
		System.out.println("\nSearching for element 5...  Index = " + 
			java.util.Arrays.binarySearch(integers, 5));
		
		int [] x=new int[10];
		java.util.Arrays.fill(x,-1);
		ArrayMethods.displayArray(x);
	}
}