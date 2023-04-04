/**
 * Calorie Calculator.
 * @author Trace Jones
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 *
 */
public class CalorieCalculator
{
  
  private static String g = "g";
  private static String dr = "dr";
  private static String oz = "oz";
  private static String lb = "lb";
  private static String p = "p";
  private static String tsp = "tsp";
  private static String tbs = "tbs";
  private static String floz = "floz";
  private static String cup = "cup";
  private static String pt = "pt";
  private static String qt = "qt";
  private static String gal = "gal";
  private static String ml = "ml";
  /**
   * calculate calorie method.
   * @param ingredient String
   * @param amount double
   * @param unit String
   * @return calories
   */
  public static double calculateCalories(final String ingredient, 
      final double amount, final String unit) 
  {
    if (amount < 0.0) return 0.0;
    double calories = 0.0;
    Ingredients ing = Ingredients.fromCode(ingredient);
    if (unit.equals(g)) calories = amount * ing.getCaloriesPerGram();
    else if (unit.equals(dr)) calories = UnitConversion.dramsConversions(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(oz)) calories = UnitConversion.ozConversions(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(lb)) calories = UnitConversion.lbConversions(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(p)) calories = UnitConversion.pinchesConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(tsp)) calories = UnitConversion.tspConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(tbs)) calories = UnitConversion.tbsConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(floz)) calories = UnitConversion.flozConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(cup)) calories = UnitConversion.cupConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(pt)) calories = UnitConversion.ptConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(qt)) calories = UnitConversion.qtConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(gal)) calories = UnitConversion.galConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    else if (unit.equals(ml)) calories = UnitConversion.mlConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
    return calories;
    
  }

}
