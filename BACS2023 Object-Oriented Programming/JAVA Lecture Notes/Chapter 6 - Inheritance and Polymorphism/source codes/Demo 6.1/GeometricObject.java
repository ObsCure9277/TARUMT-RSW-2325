// Demo 6.1: GeometricObject.java
import java.util.Date;

public class GeometricObject {
  private String color = "white";
  private boolean filled;
  private Date dateCreated;
  
  public GeometricObject() {
    dateCreated = new Date();
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
  
  public Date getDateCreated() {
    return dateCreated;
  }
  
}

