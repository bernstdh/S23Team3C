package testing;

import javax.swing.JFrame;

import gui.IngredientDialog;

/**
 * Test driver for the ingredient dialog window.
 * @author Beau Mueller
 *
 */
public class IngredientDialogDriver
{
  /**
   * Opens a new ingredient dialog.
   * @param args Not used.
   */
  public static void main(final String[] args)
  {
    JFrame frame = new JFrame("Ingredient Driver");
    new IngredientDialog(frame);
  }
}
