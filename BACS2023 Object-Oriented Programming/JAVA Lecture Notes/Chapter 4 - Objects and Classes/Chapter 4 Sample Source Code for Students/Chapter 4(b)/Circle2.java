public class Circle2 {
	double radius;

  Circle2() {
  	radius = 1.0;
  }

  Circle2(double newRadius) {
  	radius = newRadius;
  }
   
  double getArea() {    
  	return Math.PI * radius * radius;    
  }
  

}