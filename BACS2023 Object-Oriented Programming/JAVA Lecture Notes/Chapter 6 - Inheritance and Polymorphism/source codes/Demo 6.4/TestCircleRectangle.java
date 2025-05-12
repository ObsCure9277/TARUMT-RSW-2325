// Demo 7.4: TestCircleRectangle.java

public class TestCircleRectangle {
  public static void main(String[] args) {
    Circle c1 = new Circle(1.0);
    System.out.println(c1);
        
    Circle c2 = new Circle("Purple", true, 5);
    System.out.println(c2);
  
  	Rectangle r1 = new Rectangle (4,6);
  	System.out.println(r1);
  
    c2.displayObj();
    System.out.println("\n\nNumber of objects created "+ c1.getNumObjects());
      
  
  }
}
