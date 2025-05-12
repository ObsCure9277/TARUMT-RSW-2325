public class TestCustomInterfaces2 {
  public static void main(String[] args) {
  	Object[] mixedArray = new Object[7];
  	
     mixedArray[0] = new Tiger("Bengal Tiger", "India", 200000);
     mixedArray[1] = new Tiger("Malayan Tiger", "Malaysia", 50000);
     mixedArray[2] = new Chicken("Jungle Fowl", "Unknown", 12.50);
     mixedArray[3] = new Chicken("Kampung Chicken", "Unknown", 32.70);
     mixedArray[4] = new Apple("Washington Apple", false, "Red");
     mixedArray[5] = new Apple("Granny Smith Apple", true, "Green");
     mixedArray[6] = new Strawberry("Camerons Strawberry", true);
     
     printObjects(mixedArray);
  }
  
  public static void printObjects(Object[] array) {
  	for (int i = 0; i < array.length; ++i) {
  		System.out.println(array[i]);
  		if (array[i] instanceof Animal)
  			((Animal)array[i]).sound();
  			
  		if (array[i] instanceof Edible) {
  			System.out.println("Suggested serving methods: " + ((Edible)array[i]).howToEat());
  		}
  	}
  	
  }
}
