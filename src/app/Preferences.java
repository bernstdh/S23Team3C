package app;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 * Preferences Tab.
 * @author Shaury Gautam
 *
 */
public class Preferences extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JComboBox<String> unitDropdown;
	private JButton saveButton;
	private boolean isMetric;
	private final String metric = "Metric";
	/**
	 * Constructor.
	 */
	public Preferences() 
	{
		super("Preferences");

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		unitDropdown = new JComboBox<String>(new String[]{"US", metric});
		contentPane.add(unitDropdown, BorderLayout.CENTER);

		saveButton = new JButton("Save Preferences");
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(final ActionEvent e)
			{
				savePreferences();
			}
		});
		contentPane.add(saveButton, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,200);
		setResizable(false);
		setVisible(true);
	}
	/**
	 * Save preferences.
	 */
	private void savePreferences()
	{
		String selectedUnit = (String) unitDropdown.getSelectedItem();
		if (selectedUnit.equals(metric)) 
		{
			isMetric = true;
		} else 
		{
			isMetric = false;
		}
	}
	/**
	 * gets Unit.
	 * @return boolean
	 */
	public boolean getUnits() 
	{
		return isMetric;
	}

}
