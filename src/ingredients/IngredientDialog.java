package ingredients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngredientDialog extends JDialog {

    private JTextField ingredientField;
    private JTextField amountField;
    private JTextField caloriesField;
    private String ingredient;
    private String amount;
    private String calories;

    public IngredientDialog(JFrame parent) {
        super(parent, "Add Ingredient", true);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new GridLayout(3, 2));

        JLabel ingredientLabel = new JLabel("Ingredient:");
        ingredientField = new JTextField();
        add(ingredientLabel);
        add(ingredientField);

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        add(amountLabel);
        add(amountField);

        JLabel caloriesLabel = new JLabel("Calories:");
        caloriesField = new JTextField();
        add(caloriesLabel);
        add(caloriesField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingredient = ingredientField.getText();
                amount = amountField.getText();
                calories = caloriesField.getText();
                dispose();
            }
        });
        buttonPanel.add(okButton);
        add(buttonPanel);

        setVisible(true);
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getAmount() {
        return amount;
    }

    public String getCalories() {
        return calories;
    }

}
