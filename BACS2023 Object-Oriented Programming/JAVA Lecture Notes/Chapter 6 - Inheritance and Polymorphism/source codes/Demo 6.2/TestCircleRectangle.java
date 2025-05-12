// Demo 7.2: TestCircleRectangle.java

public class TestCircleRectangle {
  public static void main(String[] args) {
    System.out.println("Circle c1");
    Circle c1 = new Circle(1);
    System.out.println("Color: " + c1.getColor());
    System.out.println("Filled: " + c1.isFilled());
    System.out.println("The radius is " + c1.getRadius());
    System.out.println("The area is " + c1.getArea());
    System.out.println("The diameter is " + c1.getDiameter());
    
    System.out.println("\nCircle c2");
    Circle c2 = new Circle("Purple", true, 5);
    System.out.println("Color: " + c2.getColor());
    System.out.println("Filled: " + c2.isFilled());
    System.out.println("The radius is " + c2.getRadius());
    System.out.println("The area is " + c2.getArea());
    System.out.println("The diameter is " + c2.getDiameter());
    
    System.out.println("\nRectangle r1");
    Rectangle r1 = new Rectangle(2, 4);
    System.out.println("Color: " + r1.getColor());
    System.out.println("Filled: " + r1.isFilled());
    System.out.println("The area is " + r1.getArea());
    System.out.println("The perimeter is " + r1.getPerimeter());
    
    System.out.println("\nRectangle r2");
    Rectangle r2 = new Rectangle("Yellow", false, 10, 20);
    System.out.println("Color: " + r2.getColor());
    System.out.println("Filled: " + r2.isFilled());
    System.out.println("The area is " + r2.getArea());
    System.out.println("The perimeter is " + r2.getPerimeter());
  }
}
