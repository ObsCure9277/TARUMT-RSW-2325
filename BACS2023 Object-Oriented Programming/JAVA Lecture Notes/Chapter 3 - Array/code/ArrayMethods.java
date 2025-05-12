public class ArrayMethods {
	public static void main(String[] args) {
		int[] list1 = new int[]{1, 2, 3, 4, 5, 6};
		int[] list2 = reverse(list1);
		
		System.out.print("list1: ");
		displayArray(list1);
		System.out.print("list2: ");
		displayArray(list2);
	}
	
	public static int[] reverse(int[] list) {
		int[] result = new int[list.length];
		
		for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
			result[j] = list[i];
		}
		
		return result;
	}
	
	public static void displayArray(int[] list) {
		for (int element: list)
			System.out.print(element + " ");
		System.out.println("");
	}
	
	public static void displayArray(double[] list) {
		for (double element: list)
			System.out.print(element + " ");
		System.out.println("");
	}
	
	public static void displayArray(char[] list) {
		for (char element: list)
			System.out.print(element + " ");
		System.out.println("");
	}
}