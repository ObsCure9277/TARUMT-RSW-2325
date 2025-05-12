public class Circle3 {
	double radius;
	static int numberOfObjects = 0;

  Circle3() {
  	radius = 1.0;
  	numberOfObjects++;
  }

  Circle3(double newRadius) {
  	radius = newRadius;
  	numberOfObjects++;
  }
  
  static int getNumberOfObjects() {
  	return numberOfObjects;
  }
   
  double getArea() {    
  	return Math.PI * radius * radius;    
  }
  

}