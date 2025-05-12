
public class Rectangle extends GeometricObj {

  private double width;
  private double height;
  
  public Rectangle(){
  }
 
  public Rectangle(double width, double height){
  	this.width = width;
  	this.height = height;
  }
  
  public void setWidth(double width){
  	this.width= width;
  }
  
  public double getWidth(){
  	return this.width;
  }
  
  public void setHeight(double height){
  	this.height= height;
  }
  
  public double getHeight(){
  	return this.height;
  }
  
  public double getArea(){
  	return width * height;
  }
    
}