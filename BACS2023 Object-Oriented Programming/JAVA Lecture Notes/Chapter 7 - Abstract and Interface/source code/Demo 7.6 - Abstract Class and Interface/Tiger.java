public class Tiger extends Animal{
	private long population;

  public Tiger(String name, String origin, int population) {
  	super(name, origin);
  	this.population = population;
  }
  
  public String toString() {
		return super.toString() + "\nCurrent population in the world: " + population;
	}
  
  public void sound() {
  	System.out.println("I roar!");
  };  
    
}