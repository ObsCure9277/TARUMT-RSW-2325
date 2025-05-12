// Demo 7.2: GeometricObject.java

public class GeometricObject {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;
  
  public GeometricObject() {
  	System.out.println("Invoking GeometricObject's no-arg constructor...");
    dateCreated = new java.util.Date();
  }
  
  public GeometricObject(String color, boolean filled) {
  	System.out.println("Invoking GeometricObject's 2-parameter constructor...");
  	this.color = color;
  	this.filled = filled;
  	dateCreated = new java.util.Date();
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
  
}

