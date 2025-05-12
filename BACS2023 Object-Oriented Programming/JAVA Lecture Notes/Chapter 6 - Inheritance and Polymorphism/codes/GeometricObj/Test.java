
public class Test {
  
    public static void main(String[] args) {
       	
       	Circle c = new Circle(1);
    	System.out.println("Area = "+ c.getArea());
    	System.out.println("Colour is "+  c.getColor());
    	
    	Rectangle r = new Rectangle(2,4);
    	System.out.println("Area = "+ r.getArea());
    	
    	r.setColor("blue");
    	System.out.println("Colour is " + r.getColor());

    }
}
