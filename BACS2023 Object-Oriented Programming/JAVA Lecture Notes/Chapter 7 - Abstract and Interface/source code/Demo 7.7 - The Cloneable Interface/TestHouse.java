public class TestHouse {
  public static void main(String[] args) {
   	/** house1 and house2 are two different objects with identical (same) contents. */ 
   	House house1 = new House(1, 1750.50);
   	House house2 = (House)house1.clone();
    	
   	System.out.println("house1 == house2 is " + (house1 == house2));
    	
   	//deep copy: If the field is of a primitive type, its value (contents) is copied.
   	System.out.println("house1.getId()== house2.getId() is " + (house1.getId() == house2.getId()));
   	System.out.println("house1.getArea()== house2.getArea() is " + (house1.getArea() == house2.getArea()));
    	
   	//shallow copy: If the field is of an object, the reference of the field is copied rather than its contents.
   	System.out.println("house1.getWhenBuilt()== house2.getWhenBuilt() is " + (house1.getWhenBuilt() == 
   						house2.getWhenBuilt()));    	
   }   
}