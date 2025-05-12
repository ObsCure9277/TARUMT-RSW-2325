
public class Circle extends GeometricObj {

  private double radius;
  
  public Circle() {
  }
  
  public Circle(double radius){
  	this.radius = radius;
  }
  
  public void setRadius(double radius){
  	this.radius = radius;
  }
  
  public double getRadius(){
  	return this.radius;
  }
  
  public double getArea() {
  	return radius * radius * Math.PI;
  }

  public double getDiameter(){
  	return 2 * Math.PI * radius;
  }
    
}