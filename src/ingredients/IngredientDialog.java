package ingredients;

import javax.swing.*;
import java.awt.*;

public class IngredientDialog extends JDialog {

    private static final long serialVersionUID = 1L;
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

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(inputPanel, BorderLayout.CENTER);

        JLabel ingredientLabel = new JLabel("Ingredient:");
        ingredientField = new JTextField();
        inputPanel.add(ingredientLabel);
        inputPanel.add(ingredientField);

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        JLabel caloriesLabel = new JLabel("Calories:");
        caloriesField = new JTextField();
        inputPanel.add(caloriesLabel);
        inputPanel.add(caloriesField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            ingredient = ingredientField.getText();
            amount = amountField.getText();
            calories = caloriesField.getText();
            dispose();
        });
        buttonPanel.add(okButton);
        add(buttonPanel, BorderLayout.SOUTH);

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
