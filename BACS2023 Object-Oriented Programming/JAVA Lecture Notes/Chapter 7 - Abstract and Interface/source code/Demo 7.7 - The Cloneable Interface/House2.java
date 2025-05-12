import java.util.Date;

public class House2 implements Cloneable, Comparable{
	private int id;
	private double area;
	private Date whenBuilt;

  public House2(int id, double area) {
    this.id = id;
    this.area = area;
    whenBuilt = new Date();
  }
    
  public int getId(){
   	return id;
  }
    
  public double getArea(){
   	return area;
  }
    
  public java.util.Date getWhenBuilt(){
   	return whenBuilt;
  }
    
  /** Override the protected clone method defined in the Object class, and 
      strengthen its accessibility */
  public Object clone(){
   	try{
   		Object o = super.clone();
   		((House2)o).whenBuilt = (Date)whenBuilt.clone(); // make a deep copy of the reference-typed field
   		return o;
   	}
   	catch (CloneNotSupportedException ex){
   		return null;
   	}
  }
    
  /** Implement the compareTo method defined in Comparable */
  public int compareTo(Object o){
   	if (area > ((House2)o).area)
   		return 1;
   	else if (area < ((House2)o).area)
   		return -1;
   	else 
    	return 0;	
  }    
}