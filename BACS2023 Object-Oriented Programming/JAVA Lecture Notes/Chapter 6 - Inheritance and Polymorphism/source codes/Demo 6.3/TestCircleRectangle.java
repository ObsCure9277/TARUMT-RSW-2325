// Demo 7.3: TestCircleRectangle.java

public class TestCircleRectangle {
  public static void main(String[] args) {
    Circle c1 = new Circle(1);
    System.out.print("Circle c1");
    c1.display();
    System.out.println("The area is " + c1.getArea());
    System.out.println("The diameter is " + c1.getDiameter());
    
    Circle c2 = new Circle("Purple", true, 5);
    System.out.print("\nCircle c2");
    c2.display();
    System.out.println("The area is " + c2.getArea());
    System.out.println("The diameter is " + c2.getDiameter());
    
    Rectangle r1 = new Rectangle(2, 4);
    System.out.print("\nRectangle r1");
    r1.display();
    System.out.println("The area is " + r1.getArea());
    System.out.println("The perimeter is " + r1.getPerimeter());
    
    Rectangle r2 = new Rectangle("Yellow", false, 10, 20);
    System.out.print("\nRectangle r2");
    r2.display();
    System.out.println("The area is " + r2.getArea());
    System.out.println("The perimeter is " + r2.getPerimeter());
  }
}
