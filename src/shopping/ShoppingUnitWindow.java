package shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingUnitWindow extends JFrame {

    private static final long serialVersionUID = 1L;
	private JComboBox<String> unitComboBox;
    private String unit;

    public ShoppingUnitWindow() {
        super("Unit Chooser");

        unitComboBox = new JComboBox<>(new String[]{"US", "Metric"});
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveUnit());

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(unitComboBox);
        panel.add(saveButton);

        getContentPane().add(panel);

        setSize(300, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void saveUnit() {
        unit = (String) unitComboBox.getSelectedItem();
    }

    public String getUnit() {
        return unit;
    }


}
