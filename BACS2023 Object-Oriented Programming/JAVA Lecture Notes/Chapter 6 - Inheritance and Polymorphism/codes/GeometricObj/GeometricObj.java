import java.util.Date;

public class GeometricObj {

  private String color = "white";
  private boolean filled;
  private Date dateCreated;
  
  public GeometricObj(){
  	dateCreated = new Date(); 
  }
  
  public String getColor() {
  	return color;
  }
  
  public void setColor(String color){
  	this.color = color;
  }
  
  public boolean isFilled() {
  	return filled;
  }
  
  public void setFilled(boolean filled){
  	this.filled = filled;
  }
  
  public Date getDateCreated() {
  	return dateCreated;
  }
  
  public void setDateCreated(Date dateCreated){
  	this.dateCreated = dateCreated;
  }

    
}