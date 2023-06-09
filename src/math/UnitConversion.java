package math;
import items.IngredientTable;

/**
 * The Unit Conversions.
 * @author Trace Jones, James Madison Univserity
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 *
 */

public class UnitConversion
{
  private static String cup = "cup";
  private static String dr = "dr";
  private static String floz = "floz";
  private static String g = "g";
  private static String gal = "gal";
  private static String lb = "lb";
  private static String ml = "ml";
  private static String oz = "oz";
  private static String p = "p";
  private static String pt = "pt";
  private static String qt = "qt";
  private static String tbs = "tbs";
  private static String tsp = "tsp";
  private static String ind = "individual";

  /**
   * Performs Unit conversions.
   * @param ingredient - the ingredient
   * @param fromUnit - the current unit
   * @param toUnit - the unit it is switching to
   * @param amount - the amount of the current unit
   * @return a double representing the new amount.
   */
  public static double converter(final String ingredient, final String fromUnit,
      final String toUnit, final Double amount)
  {
    double result = 0.0;
    if (fromUnit.equals(cup)) result = cupConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(dr)) result = dramsConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(floz)) result = flozConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(g)) result = gramsConversions(ingredient, toUnit, amount);
    else if (fromUnit.equals(gal)) result = galConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(lb)) result = lbConversions(ingredient, toUnit, amount);
    else if (fromUnit.equals(ml)) result = mlConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(oz)) result = ozConversions(ingredient, toUnit, amount);
    else if (fromUnit.equals(p)) result = pinchesConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(pt)) result = ptConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(qt)) result = qtConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(tbs)) result = tbsConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(tsp)) result = tspConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(ind)) result = individualConversion(ingredient, toUnit, amount);
    return result;
  }
  
  /**
   * Conversions for cup.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double cupConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = -1.0;
    if (unitType.equals(cup)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 16);
    return value;
  }

  /**
   * Conversions for drams.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double dramsConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    IngredientTable ingredients = IngredientTable.createInstance();
    double gpm = ingredients.fromCode(ingredient).getIndividualGrams();
    double value = 0.0;
    double volume = ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(dr)) value = amount;
    
    else if (unitType.equals(oz)) value = amount / 16;
    
    else if (unitType.equals(lb)) value = amount / 256;
    
    else if (unitType.equals(g)) value = amount * 1.7718452;
    
    else if (unitType.equals(ind)) value = (amount * 1.7718452) / gpm;
    
    else if (unitType.equals(ml))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(p))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(tsp))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(tbs))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(floz))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(cup))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(pt))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(qt))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(gal))
    {
      double grams = amount * 1.7718452;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }   
    return value;
  }
  
  /**
   * Conversions for floz.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double flozConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = 0.0;
    if (unitType.equals(floz)) return amount;
    value = galConversion(ingredient, unitType, amount) / 128;
    return value;
  }
  
  /**
   * Conversions for grams.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double gramsConversions(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    IngredientTable ingredients = IngredientTable.createInstance();
    double gpm = ingredients.fromCode(ingredient).getIndividualGrams();
    double value = 0.0;
    double volume = ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(g)) value = amount;
    else if (unitType.equals(ind)) value = amount / gpm;
    else if (unitType.equals(oz)) value = amount / 28.34952;
    else if (unitType.equals(lb)) value = ((amount / 28.34952) / 16);
    else if (unitType.equals(dr)) value = (amount / 1.7718452);

    else if (unitType.equals(ml)) value = amount / volume;
    else if (unitType.equals(p)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    else if (unitType.equals(tsp)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    else if (unitType.equals(tbs)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    else if (unitType.equals(floz)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    else if (unitType.equals(cup)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    else if (unitType.equals(pt)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    else if (unitType.equals(qt)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    else if (unitType.equals(gal)) value = mlConversion(ingredient, unitType,
        (amount / volume));
    
    return value;
  }
  
  /**
   * Conversions for gal.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double galConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    IngredientTable ingredients = IngredientTable.createInstance();
    double gpm = ingredients.fromCode(ingredient).getIndividualGrams();
    double value = 0.0;
    double volume = ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(gal)) value = amount;
    else if (unitType.equals(lb))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(ingredient, lb, grams);
    }
    else if (unitType.equals(oz))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(ingredient, oz, grams);
    }
    else if (unitType.equals(g))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(ingredient, g, grams);
    }
    else if (unitType.equals(ind))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(ingredient, g, grams) / gpm;
    }
    else if (unitType.equals(dr))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(ingredient, dr, grams);
    }
    
    else if (unitType.equals(p)) value = amount * 12288;
    else if (unitType.equals(tsp)) value = amount * 768;
    else if (unitType.equals(tbs)) value = amount * 256;
    else if (unitType.equals(floz)) value = amount * 128;
    else if (unitType.equals(cup)) value = amount * 16;
    else if (unitType.equals(pt)) value = amount * 8;
    else if (unitType.equals(qt)) value = amount * 4;
    else if (unitType.equals(ml)) value =  amount * 3785.4117888;
    
    return value;
  }
  
  /**
   * Conversions for lb.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double lbConversions(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    IngredientTable ingredients = IngredientTable.createInstance();
    double gpm = ingredients.fromCode(ingredient).getIndividualGrams();
    double value = 0.0;
    double volume = ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(lb)) value = amount;
    else if (unitType.equals(oz)) value = amount * 16;
    else if (unitType.equals(g)) value = (amount * 16) * 28.34952;
    else if (unitType.equals(dr)) value = (amount * 16) * 16;
    else if (unitType.equals(ind)) value = ((amount * 16) * 28.34952) / gpm;

    else if (unitType.equals(ml))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);      
    }
    
    else if (unitType.equals(p))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);   
    }
    
    else if (unitType.equals(tsp))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(tbs))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);  
    }
    
    else if (unitType.equals(floz))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(cup))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(pt))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(qt))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(gal))
    {
      double grams = (amount * 16) * 28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }   
    return value;
  }
  
  /**
   * Conversions for ml.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double mlConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = 0.0;
    if (unitType.equals(ml)) return amount;
    value = galConversion(ingredient, unitType, amount) / 3785.4117888;
    return value;
  }
  
  /**
   * Conversions for oz.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double ozConversions(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    IngredientTable ingredients = IngredientTable.createInstance();
    double gpm = ingredients.fromCode(ingredient).getIndividualGrams();
    double value = 0.0;
    double volume = ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(oz)) value = amount;
    else if (unitType.equals(lb)) value = amount / 16;
    else if (unitType.equals(g)) value = amount *  28.34952;
    else if (unitType.equals(dr)) value = amount * 16;
    else if (unitType.equals(ind)) value = (amount * 28.34952) / gpm;

    else if (unitType.equals(ml))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(p))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(tsp))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(tbs))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(floz))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(cup))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(pt))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(qt))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }
    
    else if (unitType.equals(gal))
    {
      double grams = amount *  28.34952;
      double milli = (grams / volume);
      value = mlConversion(ingredient, unitType, milli);
    }   
    return value;
  }

  /**
   * Conversions for pinches.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double pinchesConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = 0.0;
    if (unitType.equals(p)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 12288);
    return value;
  }
  
  /**
   * Conversions for pt.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double ptConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = 0.0;
    if (unitType.equals(pt)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 8);
    return value;
  }
  
  /**
   * Conversions for qt.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double qtConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = 0.0;
    if (unitType.equals(qt)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 4);
    return value;
  }
  
  /**
   * Conversions for tbs.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double tbsConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = 0.0;
    if (unitType.equals(tbs)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 256);
    return value;
  }
  
  /**
   * Conversions for tsp.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double tspConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    double value = 0.0;
    if (unitType.equals(tsp)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 768);
    return value;
  }
  
  /**
   * individual Conversions.
   * @param ingredient - the ingredient
   * @param unitType - the type of unit being switched to.
   * @param amount - the amount in the current unit
   * @return the amount in new units.
   */
  public static double individualConversion(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return 0.0;
    if (unitType.equals(ind)) return amount;
    double value = 0.0;
    IngredientTable ingredients = IngredientTable.createInstance();
    double gpm = ingredients.fromCode(ingredient).getIndividualGrams();
    double totalGrams = gpm * amount;
    value = gramsConversions(ingredient, unitType, totalGrams);
    return value;
    
  }

}
