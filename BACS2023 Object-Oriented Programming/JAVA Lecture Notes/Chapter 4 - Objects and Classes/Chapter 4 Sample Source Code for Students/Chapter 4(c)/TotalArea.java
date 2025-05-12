public class TotalArea {
 
  public static void main(String[] args) {
    // Declare circleArray
    Circle5[] circleArray;

    // Create circleArray
    circleArray = createCircleArray();

    // Print circleArray and total areas of the circles
    printCircleArray(circleArray);
  }

  /** Create an array of Circle objects */
  public static Circle5[] createCircleArray() {
    Circle5[] circleArray = new Circle5[10];

    for (int i = 0; i < circleArray.length; i++) {
      circleArray[i] = new Circle5(Math.random() * 100);
    }

    // Return Circle array
    return circleArray;
  }

  /** Print an array of circles and their total area */
  public static void printCircleArray(Circle5[] circleArray) {
    System.out.println("Radius\t\t\t\t" + "Area");
    for (int i = 0; i < circleArray.length; i++) {
      System.out.print(circleArray[i].getRadius() + "\t\t" +
        circleArray[i].getArea() + '\n');
    }

    System.out.println("-----------------------------------------");

    // Compute and display the result
    System.out.println("The total areas of circles is \t" +
      sum(circleArray));
  }

  /** Add circle areas */
  public static double sum(Circle5[] circleArray) {
    // Initialize sum
    double sum = 0;

    // Add areas to sum
    for (int i = 0; i < circleArray.length; i++)
      sum += circleArray[i].getArea();

    return sum;
  }
}
