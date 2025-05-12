import javax.swing.JOptionPane;

public class TestJOptionPane {
    public static void main(String[] args) {
        // Using the showInputDialog method with only 1 argument
        String inputStr = JOptionPane.showInputDialog("Enter an integer: ");
        int intValue = Integer.parseInt(inputStr);
        System.out.println("You entered the integer " + intValue);
        
        // Using the showInputDialog method with 4 arguments
        inputStr = JOptionPane.showInputDialog(null, "Enter a double value: ",
        							"TestJOptionPane", JOptionPane.INFORMATION_MESSAGE);
        double doubleValue = Double.parseDouble(inputStr);
        System.out.println("You entered the double value " + doubleValue);
        
        
        inputStr = JOptionPane.showInputDialog("Enter a string without space: ");
        String outputStr = "You entered the string " + inputStr;
        // Using the showMessageDialog method to display output
        JOptionPane.showMessageDialog(null, outputStr);
    }

}
