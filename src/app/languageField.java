package app;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.filechooser.FileNameExtensionFilter;

public class languageField
{
  
  static public ResourceBundle STRINGS = ResourceBundle.getBundle("Strings");
  
  public languageField() {
  if (Locale.getDefault() == Locale.ENGLISH) {
    STRINGS =  ResourceBundle.getBundle("Strings_english.properties");
  } else if (Locale.getDefault() == Locale.FRENCH) {
    STRINGS = ResourceBundle.getBundle("Strings_french.properties");

  } else if (Locale.getDefault() == Locale.GERMAN) {
    STRINGS = ResourceBundle.getBundle("Strings_german.properties");
  }
  String step;
  }
  
  
//  FileNameExtensionFilter stringFilter;
//  stringFilter = new FileNameExtensionFilter(STRINGS.getString("DATA_FILES"), "tax");
  
}
