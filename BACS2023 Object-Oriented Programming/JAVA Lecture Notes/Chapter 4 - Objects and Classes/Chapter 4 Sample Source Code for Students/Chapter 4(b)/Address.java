public class Address {
	private String street;
	private int postcode;
	private String city;
	
	
  public Address(String street, int postcode, String city) {
  	this.street = street;
  	this.postcode = postcode;
  	this.city = city;
  }
    
  public String toString() {
  	return street + ", " + postcode + ", " + city;
  }
  
}