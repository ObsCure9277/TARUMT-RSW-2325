// Demo 7.4: Circle.java

public class Circle extends GeometricObject {
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }
  
  public Circle(String color, boolean filled, double radius) {
  	super(color, filled);		// invokes superclass parameterized constructor
  	this.radius = radius;
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
  
  public double getDiameter() {
    return 2 * radius;
  }
  
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated() +
      " and the radius is " + radius);
  }
  
  public String toString() {
  	return super.toString() + "\nRadius: " + radius;
  }
}
