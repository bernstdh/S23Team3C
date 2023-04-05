/**
 * Formats information according to the InteractionDesignDocument.
 * @author beaumueller
 *
 */
public class Formatter
{
  /*
   * <amount> <unit> of <details> <name>
   * 3.42 grams of raw eggs
   */
  public static final String INGREDIENT = "%.2f %s of %s %s";
  
  /*
   * <action> the <ingredient> in the <utensil> <details>
   * Pour the mixed eggs in the bowl slowly
   */
  public static final String STEP_INGREDIENT = "%s the %s in the %s %s";
  
  /*
   * <details> <name>
   * 4x4 frying pan
   */ 
  public static final String UTENSIL = "%s %s";
  
  /*
   * <action> the contents of the <utensil> <details>
   * Mix the contents of the bowl until the mixture is one color
   */
  public static final String STEP_SINGLE = "%s the contents of the %s %s";
  
  /*
   * <action> the contents of the <sourceutensil> in the <destinationutensil> <details>
   * Put the contents of the strainer in the 1-quart casserole
   */
  public static final String STEP_MUL = "%s the contents of the %s in the %s %s";
}

