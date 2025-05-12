public class Circle5 {
	private double radius;
	private static int numberOfObjects = 0;

  public Circle5() {
  	radius = 1.0;
  }

  public Circle5(double radius) {  
  	this.radius = radius;   
  }
  
  public static int getNumberOfObjects() {
  	return numberOfObjects;
  }
  
  public double getRadius() {
  	return radius;
  }
  
  public void setRadius(double radius) { 
  	this.radius = radius;   
  }
   
  double getArea() {    
  	return Math.PI * radius * radius;    
  }
  

}