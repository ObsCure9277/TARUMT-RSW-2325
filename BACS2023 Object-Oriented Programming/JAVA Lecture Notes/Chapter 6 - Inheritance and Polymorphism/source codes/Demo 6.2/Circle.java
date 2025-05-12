// Demo 7.2: Circle.java

public class Circle extends GeometricObject {
  private double radius;

  public Circle() {
  	System.out.println("Invoking Circle's no-arg constructor...");
  }

  public Circle(double radius) {
  	System.out.println("Invoking Circle's constructor with 1 parameter ...");
    this.radius = radius;
  }
  
  public Circle(String color, boolean filled, double radius) {
  	// super(color, filled);		// invokes superclass parameterized constructor
  	System.out.println("Invoking Circle's constructor with 3 parameters ...");
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

  public String toString() {
    return "The circle is created " + getDateCreated() + " and the radius is " + radius;
  }
}
