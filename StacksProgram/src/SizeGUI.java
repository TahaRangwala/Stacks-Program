
/*Name: Taha Rangwala
 * Date: December 5, 2016
 * Purpose: The purpose of this dialog box class is to allow the user to choose the sort type at the beginning of the program
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//SortGUI class header
public class SizeGUI extends GBDialog {

	// Declaring window objects
	private JLabel sizeLabel;
	private IntegerField sizeField;
	private JButton customSize, Exit;

	/*
	 * Purpose: This is the constructor method of the dialog box class param F
	 * This is the JFrame settings needed for the super class
	 */
	public SizeGUI(JFrame F) {
		super(F);
		sizeLabel = addLabel("Size", 1, 1, 1, 1);
		sizeField = addIntegerField(0, 1, 2, 1, 1);
		customSize = addButton("Custom Size", 2, 1, 1, 1);
		Exit = addButton("Exit", 2, 2, 1, 1);
		setSize(300, 150);
		setTitle("Choose the Size");
		setLocationRelativeTo(null);// Location is in center of screen
		getContentPane().setBackground(new Color(169, 229, 255));// background
																	// of GUI is
																	// light
																	// blue
	}

	/*
	 * Purpose: The purpose of this method is to perform certain tasks according
	 * to which button the user clicks
	 * 
	 * @param buttonObj This is the button object which allows the program to
	 * tell which button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj) {

		if (buttonObj == customSize) {
			if (checkSize()) {
				try {
					GUI.errorCheckNumber(sizeField.getNumber());
					GUI.Size = sizeField.getNumber();
				} catch (Exception E) {
					JOptionPane.showMessageDialog(new JFrame(), E.getLocalizedMessage(), "Error Message",
							JOptionPane.ERROR_MESSAGE);
				}
			} else
				JOptionPane.showMessageDialog(new JFrame(), "Make Sure Numbers Are Valid", "Error Message",
						JOptionPane.ERROR_MESSAGE);
		} else
			setVisible(false);

	}

	/*
	 * Purpose: This checks to make sure the size is a valid number
	 * 
	 * @return This returns a boolean value denoting if the size is valid or not
	 */
	private boolean checkSize() {
		return sizeField.isValidNumber();
	}

}
