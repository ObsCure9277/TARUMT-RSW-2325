public class TestCircle1 {
  public static void main(String[] args) {
    
    // Create a circle with radius 1.0
    Circle1 yourCircle = new Circle1();
    System.out.println("The area of the circle of radius "
      + yourCircle.radius + " is " + yourCircle.getArea());

    // Modify circle radius
    yourCircle.radius = 100;
    System.out.println("The area of the circle of radius "
      + yourCircle.radius + " is " + yourCircle.getArea());
  }
}

