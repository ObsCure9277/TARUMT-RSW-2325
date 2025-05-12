public class Apple extends Fruit {
	public String colour;
	
  public Apple(String name, boolean seasonal, String colour) {
  	super(name, seasonal);
  	this.colour = colour;
  }
    
  public String toString() {
  	return super.toString() + "\nColour: " + colour;
  }  
  	
  public String howToEat() {
  	String outputStr = "Eat fresh or ";
  	
  	if ((colour.toUpperCase()).equals("RED"))
  		outputStr += "make apple pie.";
  	else
  		outputStr += "juice with carrots.";
  	
  	return outputStr;
  }
}