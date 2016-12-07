/*Name: Taha Rangwala
 * Date: December 5, 2016
 * Purpose: The purpose of this class is to give the user a friendly interface that allows
 * the user to use the program. This gives the user buttons, input and output fields, and more 
 * so that he or she can use the program.
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//GUI class header
public class GUI extends GBFrame{

	//Declaring static variables
	public static int Size;//Size is for the array size
	//Declaring private instance variables
	private StackADT stackObj;//Object of interface
	private JLabel numberLabel, binaryLabel, octaLabel;
	private IntegerField numberField;
	private JTextField binaryField, octalField;
	private JButton convertWithArray, convertWithLinked, Exit;
	
	//GUI constructor for initializing variables and window objects
	public GUI(){
		Size = -1;
		numberLabel = addLabel("Base 10 Number",1,1,1,1);
		numberField = addIntegerField(0,1,2,1,1);
		binaryLabel = addLabel("Binary",2,1,1,1);
		binaryField = addTextField("",2,2,1,1);
		octaLabel = addLabel("Octal",3,1,1,1);
		octalField = addTextField("",3,2,1,1);
		convertWithArray = addButton("Convert With Array",4,1,1,1);
		convertWithLinked = addButton("Convert With Linked List",4,2,1,1);
		Exit = addButton("Exit",5,2,1,1);
		binaryField.setEditable(false);
		octalField.setEditable(false);
		SizeGUI sizeGUI = new SizeGUI(this);
		sizeGUI.setVisible(true);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the user wants
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == convertWithArray){
			if(checkNumber()){
				try{
					errorCheckNumber(numberField.getNumber());
					if(Size == -1)
						stackObj = new Array();
					else stackObj = new Array(Size);
					binaryField.setText(convertToBinary());
					if(Size == -1)
						stackObj = new Array();
					else stackObj = new Array(Size);
					octalField.setText(convertToOctal());
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure Numbers Are Valid", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == convertWithLinked){
			if(checkNumber()){
				try{
					errorCheckNumber(numberField.getNumber());
					stackObj = new LinkedList();
					binaryField.setText(convertToBinary());
					stackObj = new LinkedList();
					octalField.setText(convertToOctal());
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure Numbers Are Valid", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else
			this.dispose();
		
	}
	
	/*Purpose: This checks to make sure the base 10 number is a valid number
	 * @return This returns a boolean value denoting if the base 10 number is valid or not
	 */
	public boolean checkNumber(){
		return numberField.isValidNumber();
	}
	
	/*Purpose: This converts the base 10 number to binary 
	 * @return This returns a String of binary conversion
	 */
	private String convertToBinary(){
		int Quotient = numberField.getNumber(), Remainder = 0;
		while(Quotient != 0){
			Remainder = Quotient % 2;
			Quotient = Quotient / 2;
			stackObj.push(Remainder);
		}
		return stackObj.toString();
	}
	
	/*Purpose: This converts the base 10 number to octal
	 * @return This returns a String of octal conversion
	 */
	private String convertToOctal(){
		int Quotient = numberField.getNumber(), Remainder = 0;
		while(Quotient != 0){
			Remainder = Quotient % 8;
			Quotient = Quotient / 8;
			stackObj.push(Remainder);
		}
		return stackObj.toString();
	}
	
	/*Purpose: This error checks the base 10 number or the size
	 * @param Number This is the number being checked
	 */
	public static void errorCheckNumber(int Number){
		if(Number <= 0)
			throw new IllegalArgumentException("The Number Needs To Be Greater Than 0!");
	}
	
	//Main method to set up the GUI
	public static void main (String [] args){
		GUI theMainGUI = new GUI();//GUI object
		theMainGUI.setSize(380,300);//size of the GUI interface
		theMainGUI.setTitle("Taha's Binary and Octal Conversion Program");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		//theMainGUI.setLookAndFeel("MOTIF");//This changes the look of the GUI interface
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
