// Demo 7.4: Circle.java

public class Circle extends GeometricObject {
  private double radius;
  private static int circleObjectCnt=0;
  public Circle() {
  }

  public Circle(double radius) {
  	this("Blue", true, radius);
  }
  
  public Circle(String color, boolean filled, double radius) {
  	super(color, filled);		// invokes superclass parameterized constructor
  	this.radius = radius;
  	circleObjectCnt++;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public double getArea() {
    return radius * radius * Math.PI;
  }
  
 public static int getCircleObjectCnt(){
 	return circleObjectCnt;
 }
 public String toString() {
  	return "\nGeometric Object   =  "+ getNumObjects() + "\n\nCircle object "+super.toString() + "\nRadius: " + radius ;
  }
  public static void displayObj(){
    GeometricObject.displayObj();
    System.out.println("\nTotal Number of Circle objects : "+getCircleObjectCnt());
  }

}
