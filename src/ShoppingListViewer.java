import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ShoppingListViewer extends JFrame implements ActionListener{

	public ShoppingListViewer(final String name) {
		super(name);
		setSize(400, 300);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
