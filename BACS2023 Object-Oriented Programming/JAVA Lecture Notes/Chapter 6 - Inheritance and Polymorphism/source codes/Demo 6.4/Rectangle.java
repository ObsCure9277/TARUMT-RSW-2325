// Demo 7.4: Rectangle.java

public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this("Red", true, width, height);  
  }
  
  public Rectangle(String color, boolean filled, double width, double height) {
  	super(color, filled);		// invokes superclass parameterized constructor
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
  
  public String toString() {
  	return "\nGeometric Object   =  "+ getNumObjects() + "\n\nRectangle object "+super.toString() + "\nWidth: " + width + "\nHeight: " + height;
  }
}
