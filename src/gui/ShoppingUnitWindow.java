package gui;

import javax.swing.*;

import app.languageField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * Swap units.
 * @author Shaury Gautam
 *
 */
public class ShoppingUnitWindow extends JDialog
{
	private static final long serialVersionUID = 1L;
	private JComboBox<String> unitsComboBox;
	private JButton applyButton;
	private JLabel unitLabel;
	
	/**
	 * Constructor.
	 * @param parent ShoppingListViewer
	 * @param repeat 
	 */
	public ShoppingUnitWindow(final ShoppingListViewer parent,
			final ArrayList<String> repeat) 
	{
		super(parent, languageField.STRINGS.getString("Change_Units"), true);

		Set<String> uniqueUnits = new HashSet<>(repeat);
		unitsComboBox = new JComboBox<>(uniqueUnits.toArray(new String[0]));
		unitLabel = new JLabel(languageField.STRINGS.getString("Select"));
		applyButton = new JButton(languageField.STRINGS.getString("Apply"));

		setLayout(new FlowLayout());
		add(unitLabel);
		add(unitsComboBox);
		add(applyButton);
		
		applyButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(final ActionEvent e)
			{
				String selectedUnit = (String) unitsComboBox.getSelectedItem();
				parent.convertUnits(selectedUnit);
				setVisible(false);
			}
		});

		setSize(300, 100);
		setLocationRelativeTo(parent);
		setResizable(false);
		setVisible(true);
	}
}
