import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.io.*;


public class SumNumber extends MIDlet implements CommandListener {

	private Display display = null;
	StringItem string_item = null;
	Form ui_holder = null;
	Command ok = null;
	Command quit = null;
	TextField inputtext = null;

	private static final char BLANK = ' '; //Define Blank space

	public SumNumber () {
		display = Display.getDisplay(this);
		ok = new Command("OK", Command.SCREEN,3);
		quit = new Command("Quit", Command.SCREEN,2);

   }

	public void startApp() {
		ui_holder = new Form("Addition of numbers");
		inputtext = new TextField("Enter a string of numbers...", "",50,0);
		string_item = new StringItem("The sum of ","");
		ui_holder.append(inputtext);
		ui_holder.append(string_item);
		ui_holder.addCommand(ok);
		ui_holder.addCommand(quit);
		ui_holder.setCommandListener(this);
		display.setCurrent(ui_holder);
	}

	public void pauseApp() {}

	public void destroyApp(boolean condition){
		string_item = null;
		ui_holder = null;
		inputtext = null;
		notifyDestroyed();
	}

	public void commandAction(Command c, Displayable d){
		if (c==ok){

			int index, noOfChars, beginIdx, endIdx, number, result;
			String word, input_string = inputtext.getString(), number_string;

			noOfChars = input_string.length();
			index = 0;
			result = 0;

			while (index < noOfChars){

				//ignore leading blank spaces
				while(index < noOfChars && input_string.charAt(index) == BLANK) {
					index++;
				}
				beginIdx = index;

				//locate the end of the string
				while(index < noOfChars && input_string.charAt(index) != BLANK) {
					index++;
				}
				endIdx = index;

				if(beginIdx != endIdx) {

					number_string = input_string.substring (beginIdx, endIdx); //get the number_string
					number =Integer.parseInt(number_string); //convert the number_string to number

					result = result + number;
				}
			}
			word = "  is " + result;
			string_item.setText(inputtext.getString() + word);


		} if (c==quit)
				destroyApp(true);
	}
}

