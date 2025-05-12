public class Circle4 {
	private double radius;
	private static int numberOfObjects = 0;

  public Circle4() {
  	radius = 1.0;
  	numberOfObjects++;
  }

  public Circle4(double newRadius) {
  	radius = newRadius;
  	numberOfObjects++;
  }
  
  public static int getNumberOfObjects() {
  	return numberOfObjects;
  }
  
  public double getRadius() {
  	return radius;
  }
  
  public void setRadius(double newRadius) {
  	radius = newRadius;
  }
   
  double getArea() {    
  	return Math.PI * radius * radius;    
  }
  

}