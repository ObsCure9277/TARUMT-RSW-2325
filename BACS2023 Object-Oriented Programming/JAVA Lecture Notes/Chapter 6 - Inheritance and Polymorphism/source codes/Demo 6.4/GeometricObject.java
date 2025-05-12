// Demo 7.4: GeometricObject.java
import java.util.Date;
public class GeometricObject {
  private String color = "white";
  private boolean filled;
  private Date dateCreated;
  private static int numObjects=0;
  
  public GeometricObject() {
    dateCreated = new Date();
  }
  
  public GeometricObject(String color, boolean filled) {
  	this.color = color;
  	this.filled = filled;
  	dateCreated = new Date();
  	numObjects++;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean isFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  
  public java.util.Date getDateCreated() {
    return dateCreated;
  }
  
  public String toString() {
  	return "\nColor: " + color + "\nFilled: " + filled + "\nDate created: " + dateCreated;
  }
  public static int getNumObjects(){
       return numObjects;
  }
  public static void displayObj(){
    System.out.println("\nTotal number of Geometric Objects:"+  numObjects);
  }

  
}

