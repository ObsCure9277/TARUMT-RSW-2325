public abstract class Fruit implements Edible{
	private String name;
	private boolean seasonal;
	
  public Fruit(String name, boolean seasonal) {
  	this.name = name;
  	this.seasonal = seasonal;
  }
    
  public String toString() {
  	return "\nFruit name: " + name + "\nSeasonal: " + (seasonal? "Yes": "No");
  }  
  
  public abstract String howToEat();
}