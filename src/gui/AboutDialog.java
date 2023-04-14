package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;

/**
 * About Dialog.
 * 
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * About Dialog.
 * 
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * About Dialog.
 * 
 */
public class AboutDialog {
    private String about = " This is the new cutting edge\n revolutionary kitchen software\n"
        + " which will completely change the way you cook!\n Your meals, recipes, ingredients, and\n"
        + " everything else that you could need is all in one\n neat and elegant application. Our application\n"
        + " is completely intuitive and built for all chefs,\n from the minute noodle kings and queens to the Michelin Star\n"
        + " winning kitchens.";

    /**
     * Constructor.
     */
    public AboutDialog() {
        JFrame frame = new JFrame("About Dialog");
        JTextArea text = new JTextArea(about);
        
        frame.setSize(400, 250);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        text.setEditable(false);
        
        frame.add(text);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
