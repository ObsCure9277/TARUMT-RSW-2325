import java.util.Scanner;

public class TestStudent {
  public static void main(String[] args) {
  	Address[] addrArr = new Address[10];
  	int totalAddr = 0;
  	
  	Student[] studArr = new Student[10];
  	int totalStud = 0;
  	
  	Scanner scanner = new Scanner(System.in);
  	char anymore = 'y';
  	
  	do {
  		System.out.print("\nInput first name: ");
  		String firstName = scanner.next();
  		System.out.print("Input last name: ");
  		String lastName = scanner.next(); 
  		scanner.nextLine(); 
  		Name name = new Name(firstName, lastName);
  		
  		int selection = 0;
  		if (totalAddr > 0) {
  			System.out.println("\nList of current addresses: ");
  			for (int i = 0; i < totalAddr; ++i) {
  				System.out.println((i+1) + ". " + addrArr[i]);	
  			}
  			System.out.print("Enter 1" + ".." + totalAddr + " to select address. [-1] to enter new address: ");
  			selection = scanner.nextInt();
  			scanner.nextLine();
  		}
  		
  		Address address;
  		if (selection <= 0) {
  			System.out.println("\nAddress: ");
  			System.out.print("  Input street: ");
  			String street = scanner.nextLine();
  			System.out.print("  Input postcode: ");
  			int postcode = scanner.nextInt();
  			scanner.nextLine();
  			System.out.print("  Input city: ");
  			String city = scanner.nextLine();
  			address = new Address(street, postcode, city);
  			addrArr[totalAddr++] = address;
  		}
  		else {
  			address = addrArr[selection - 1];
  		}
  		
  		System.out.print("\nInput programme code: ");
  		String progCode = scanner.next();
  		scanner.nextLine();
  		
  		studArr[totalStud++] = new Student(name, progCode, address);
  		
  		System.out.print("Anymore(y/n)?");
  		anymore = scanner.next().charAt(0);
  		scanner.nextLine();
  	} while (anymore == 'y' || anymore == 'Y');
  	
  	System.out.println("\n\nStudent List: ");
  	for (int i = 0; i < totalStud; ++i) {
  		System.out.println((i+1) + ". " + studArr[i].toString() + "\n");
  	}
  }
}
