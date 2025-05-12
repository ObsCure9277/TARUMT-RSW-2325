// Demo 7.2: Rectangle.java

public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle() {
  	System.out.println("Invoking Rectangle's no-arg constructor...");
  }

  public Rectangle(double width, double height) {
  	System.out.println("Invoking Rectangle's 2-parameter constructor...");
    this.width = width;
    this.height = height;    
  }
  
  public Rectangle(String color, boolean filled, double width, double height) {
  	super(color, filled);		// invokes superclass parameterized constructor
  	System.out.println("Invoking Rectangle's 4-parameter constructor...");
    this.width = width;
    this.height = height;    
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getArea() {
    return width * height;
  }

  public double getPerimeter() {
    return 2 * (width + height);
  }
}
