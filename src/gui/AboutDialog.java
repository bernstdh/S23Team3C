package gui;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Font;
import java.net.URL;

/**
 * About Dialog.
 * 
 */


/**
 * About Dialog.
 * 
 */

/**
 * About Dialog.
 * 
 */
public class AboutDialog
{
	private String about = " This is the new cutting edge\n revolutionary kitchen software\n"
			+ " which will completely change the way you "
			+ "cook!\n Your meals, recipes, ingredients, and\n"
			+ " everything else that you could need is all "
			+ "in one\n neat and elegant application. Our application\n"
			+ " is completely intuitive and built for all"
			+ " chefs,\n from the minute noodle kings and queens to the Michelin Star\n"
			+ " winning kitchens.";
	private JLabel pic;
	/**
	 * Constructor.
	 */
	public AboutDialog() 
	{
		JFrame frame = new JFrame("About Dialog");
		JTextArea text = new JTextArea(about);

		frame.setSize(400, 250);
		text.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		text.setEditable(false);


		pic = new JLabel(loadImageIcon("ram.png"));

	//	frame.add(pic, BorderLayout.EAST);
		frame.add(text);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}

	private ImageIcon loadImageIcon(final String name)
	{
		URL url = this.getClass().getResource("/icons/"+ name);
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

}
