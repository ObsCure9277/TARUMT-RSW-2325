// Demo 6.1: TestCircleRectangle.java

public class TestCircleRectangle {
  public static void main(String[] args) {
    
    Circle circle = new Circle(1);
    System.out.println("A circle ");
    
    // calls to methods inherited from superclass Geometric
    System.out.println("Color: " + circle.getColor());
    System.out.println("Filled: " + circle.isFilled());
    System.out.println("Date created: " + circle.getDateCreated());
    
     // calls to additional methods defined in Circle class
    System.out.println("The radius is " + circle.getRadius());
    System.out.println("The area is " + circle.getArea());
    System.out.println("The diameter is " + circle.getDiameter());
    
    Rectangle rectangle = new Rectangle(2, 4);
    System.out.println("\nA rectangle");
    
    // calls to methods inherited from superclass Geometric
    System.out.println("Color: " + rectangle.getColor());
    System.out.println("Filled: " + rectangle.isFilled());
    System.out.println("Date created: " + rectangle.getDateCreated());
    
    // calls to additional methods defined in Rectangle class
    System.out.println("The area is " + rectangle.getArea());
    System.out.println("The perimeter is " + rectangle.getPerimeter());
  }
}
