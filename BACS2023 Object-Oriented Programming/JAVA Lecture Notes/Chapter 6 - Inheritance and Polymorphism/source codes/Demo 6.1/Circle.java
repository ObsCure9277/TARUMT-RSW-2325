// Demo 6.1: Circle.java

public class Circle extends GeometricObject {
  private double radius;

  public Circle() {
  	this(1.0);
  }

  public Circle(double radius) {
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
