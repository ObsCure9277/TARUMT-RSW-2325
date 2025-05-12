public abstract class Animal {
	private String name;
	private String origin;
		
	protected Animal(String name, String origin) {
		this.name = name;
		this.origin = origin;
	}
	
	public String toString() {
		return "\nAnimal name: " + name + "\nOrigin: " + origin;
	}
	
	public abstract void sound();
	
}