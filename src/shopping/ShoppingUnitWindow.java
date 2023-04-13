package shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShoppingUnitWindow extends JDialog {
    private static final long serialVersionUID = 1L;
	private JComboBox<String> unitsComboBox;
    private JButton applyButton;
    private JLabel unitLabel;
    private ShoppingListViewer parent;

    public ShoppingUnitWindow(ShoppingListViewer parent, ArrayList<String> repeat) {
        super(parent, "Change Units", true);

        this.parent = parent;
        Set<String> uniqueUnits = new HashSet<>(repeat);
        unitsComboBox = new JComboBox<>(uniqueUnits.toArray(new String[0]));
        unitLabel = new JLabel("Select unit:");
        applyButton = new JButton("Apply");

        setLayout(new FlowLayout());
        add(unitLabel);
        add(unitsComboBox);
        add(applyButton);

        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
