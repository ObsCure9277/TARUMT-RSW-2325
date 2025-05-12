public class TestCircle2 {
  public static void main(String[] args) {
  	// Create a circle object with the default radius
    Circle2 c = new Circle2();
    System.out.println("Circle");
    System.out.println("\tRadius: " + c.radius + ", Area = " + c.getArea());
    
    // Create another circle object with radius = 5.0
    c = new Circle2(5.0);
    System.out.println("\nNew circle");
    System.out.println("\tRadius: " + c.radius + ", Area = " + c.getArea());
  }
}

