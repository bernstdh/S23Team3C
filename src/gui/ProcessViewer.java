package gui;
import javax.swing.*;
import java.awt.*;
/**
 * Process Viewer.
 * @author Shaury Gautam
 *
 */

public class ProcessViewer extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextArea utensilBox;
	private JTextArea stepsBox;
	/**
	 * Process viewer constructor.
	 */
	public ProcessViewer(String name) 
	{
		super("KiLowBites Process Viewer\t" + name);

		JLabel lblUtensils = new JLabel("Utensils");
		utensilBox = new JTextArea(10, 30);
		utensilBox.setEditable(false);
		utensilBox.setLineWrap(true);
		utensilBox.setWrapStyleWord(true);
		JScrollPane utensilScroll = new JScrollPane(utensilBox,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JLabel lblSteps = new JLabel("Steps");
		stepsBox = new JTextArea(20, 30);
		stepsBox.setEditable(false);
		stepsBox.setLineWrap(true);
		stepsBox.setWrapStyleWord(true);
		JScrollPane stepsScroll = new JScrollPane(stepsBox,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(lblUtensils, BorderLayout.NORTH);
		topPanel.add(utensilScroll, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);

		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(lblSteps, BorderLayout.NORTH);
		bottomPanel.add(stepsScroll, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		setResizable(false); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		
	}

	
	/**
	 * setter.
	 * @param s string
	 */
	public void setUtensils(final String s) 
	{
		utensilBox.setText(s);
	}
	
	/**
	 * setter.
	 * @param s string
	 */
	public void setSteps(final String s) 
	{
		stepsBox.setText(s);
	}

}

