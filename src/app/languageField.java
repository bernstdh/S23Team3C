package app;

import java.util.Locale;
import java.util.ResourceBundle;



/**
 * languageField class creates a resourceBundle for
 * language support.
 * @author Julian Barrett
 *
 */
public class languageField
{

  static public ResourceBundle STRINGS = ResourceBundle.getBundle("Strings");

  /**
   * Constructor.
   */
  public languageField()
  {
    if (Locale.getDefault() == Locale.ENGLISH)
    {
      STRINGS = ResourceBundle.getBundle("Strings.properties");
    }
    else if (Locale.getDefault() == Locale.FRENCH)
    {
      STRINGS = ResourceBundle.getBundle("Strings_fr.properties");
    }
    else if (Locale.getDefault() == Locale.GERMAN)
    {
      STRINGS = ResourceBundle.getBundle("Strings_de.properties");
    }
  }


}
