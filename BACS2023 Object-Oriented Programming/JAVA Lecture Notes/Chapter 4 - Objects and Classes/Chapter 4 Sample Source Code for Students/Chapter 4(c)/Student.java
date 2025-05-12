public class Student {
	private Name name;
	private String programme;
	private Address address;
		
  public Student(Name name, String programme, Address address) {
  	this.name = name;
  	this.address = address;
  	this.programme = programme;
  }
    
  public String toString() {
  	return name + "\n" + programme + "\n" + address;
  }  
}