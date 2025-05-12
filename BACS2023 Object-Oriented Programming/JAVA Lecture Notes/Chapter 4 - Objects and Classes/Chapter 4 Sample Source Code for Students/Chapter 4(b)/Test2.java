public class Test2 {
  public static void main(String[] args) {
  	Student student = new Student();
  	System.out.println("name? " + student.name);
  	
  	
  	student = null; 
  	System.out.println("\nname? " + student.name);  // this statement will cause a runtime
  																									// NullPointerException error
  	  	
  	student = new Student();
  	student.name = "Jack Sparrow";
  	System.out.println("\nname? " + student.name);
  	
  }
}
