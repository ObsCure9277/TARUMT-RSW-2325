public class TestCircle4 {
  public static void main(String[] args) {
  	System.out.println("Before any circles are created, number of circle objects: " + 
  		Circle4.getNumberOfObjects());
  	
  	// Create a circle object with the default radius
    Circle4 c = new Circle4();
    System.out.println("\nCircle");
    // System.out.println("\tRadius: " + c.radius);  // error because radius has private access
    System.out.println("\tRadius: " + c.getRadius());
    System.out.println("\tArea = " + c.getArea());
    
    // Modify radius to 8.0
    // c.radius = 8.0;  // error because radius has private access
    c.setRadius(8.0);
    System.out.println("\nUpdated Circle");
    System.out.println("\tRadius: " + c.getRadius());
    System.out.println("\tArea = " + c.getArea());
    
    Circle4 c2 = new Circle4(5.0);
    System.out.println("\nCircle");
    // System.out.println("\tRadius: " + c.radius);  // error because radius has private access
    System.out.println("\tRadius: " + c2.getRadius());
    System.out.println("\tArea = " + c2.getArea());
		
		System.out.println("\nCurrent number of circle objects: " + 
  		Circle4.getNumberOfObjects());
  }
}

