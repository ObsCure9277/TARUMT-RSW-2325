public class TestPolymorphicVariables {
  public static void main(String[] args) {
    GeometricObject[] geometricObjectArray = new GeometricObject[5];
    
    geometricObjectArray[0] = new Circle(1);
    geometricObjectArray[1] = new Rectangle(3, 5);
    geometricObjectArray[2] = new Rectangle(8, 10);
    geometricObjectArray[3] = new Circle(5);
    geometricObjectArray[4] = new Rectangle(12, 16);

	System.out.println("Geometric Objects");
	System.out.println("-----------------");
    for (int i = 0; i < geometricObjectArray.length; ++i) {
    	System.out.println(geometricObjectArray[i]);
    }
  }
}
