public class TestCircle3 {
  public static void main(String[] args) {
  	System.out.println("Before creating objects");
  	System.out.println("The number of Circle objects is " + Circle3.numberOfObjects);
  	
  	// Create the first circle object
    Circle3 c1 = new Circle3();
    System.out.println("\nCircle c1");
    System.out.println("\tRadius: " + c1.radius + ", Area = " + c1.getArea());
    System.out.println("***After creating c1");
  	System.out.println("\tThe number of Circle objects is " + Circle3.numberOfObjects);
    
    // Create another circle object with radius = 5.0
   	Circle3 c2 = new Circle3(5.0);
    System.out.println("\nCircle c2");
    System.out.println("\tRadius: " + c2.radius + ", Area = " + c2.getArea());
    System.out.println("***After creating c2");
  	System.out.println("\tThe number of Circle objects is " + Circle3.numberOfObjects);
  	
  	// Create another circle object with radius = 8.0
   	Circle3 c3 = new Circle3(8.0);
    System.out.println("\nCircle c3");
    System.out.println("\tRadius: " + c3.radius + ", Area = " + c3.getArea());
    System.out.println("***After creating c3");
  	System.out.println("\tThe number of Circle objects is " + Circle3.getNumberOfObjects());
  }
}

