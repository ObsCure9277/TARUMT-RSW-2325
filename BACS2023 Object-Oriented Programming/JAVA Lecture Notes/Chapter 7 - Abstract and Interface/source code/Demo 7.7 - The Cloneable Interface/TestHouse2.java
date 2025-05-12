public class TestHouse2 {
  public static void main(String[] args) {
   	/** house1 and house2 are two different objects with identical (same) contents. */ 
   	House2 h1 = new House2(1, 1750.50);
   	House2 h2 = (House2)h1.clone();
    	
   	System.out.println("h1 == h2 is " + (h1 == h2));
    	
   	// deep copy: If the field is of a primitive type, its value (contents) is copied.
   	System.out.println("h1.getId()== h2.getId() is " + (h1.getId() == h2.getId()));
   	System.out.println("h1.getArea()== h2.getArea() is " + (h1.getArea() == h2.getArea()));
    	
   	// deep copy: The clone method of House2 has been overridden such that a deep copy of the  
   	// whenBuilt field is made, i.e. a separate Date object is created for the whenBuilt field.
   	System.out.println("h1.getWhenBuilt()== h2.getWhenBuilt() is " + (h1.getWhenBuilt() == 
   						h2.getWhenBuilt()));    	
   }   
}