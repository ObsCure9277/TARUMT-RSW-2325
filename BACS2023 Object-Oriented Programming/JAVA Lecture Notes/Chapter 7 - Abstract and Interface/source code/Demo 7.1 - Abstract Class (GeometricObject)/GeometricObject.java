import java.util.Date;

public abstract class GeometricObject {
  private String color = "white";
  private boolean filled;
  private Date dateCreated;

  protected GeometricObject(){
  	dateCreated = new Date();
  }

  protected GeometricObject(String color) {
    dateCreated = new Date();
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
     so, the get method name is isFilled */
  public boolean isFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  /** Return a string representation of this object */
  public String toString() {
    return "\nObject created on " + dateCreated + "\ncolor: " + color +
      " and filled: " + filled;
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
}
