public class Chicken extends Animal implements Edible{
	private double price;

  public Chicken(String name, String origin, double price) {
  	super(name, origin);
  	this.price = price;
  }
  
  public String toString() {
		return super.toString() + String.format("\nAverage price: RM%.2f", price);
	}
  
  public void sound() {		// implementing abstract method from abstract class Animal
  	System.out.println("I cluck or crow.");
  };  
  	
  public String howToEat() {  // implementing abstract method from interface Edible
  	return "Fry it, steam it or barbeque it.";
  }
    
}