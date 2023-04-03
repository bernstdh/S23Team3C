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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(cup)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 16);
    if (value < 0) value = -1.0;
    return value;
  }

  /**
   * Conversions for drams.
   * @param ingredient - the ingredient being used.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double dramsConversions(final String ingredient, final String unitType,
      final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = Ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(dr)) value = amount;
    
    else if (unitType.equals(oz)) value = amount / 16;
    
    else if (unitType.equals(lb)) value = amount / 256;
    
    else if (unitType.equals(g)) value = amount * 1.7718452;
    
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(floz)) return amount;
    value = galConversion(ingredient, unitType, amount) / 128;
    if (value < 0) value = -1.0;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = Ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(g)) value = amount;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = Ingredients.fromCode(ingredient).getGramsPerMillileter();
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
    
    if (value < 0) value = -1.0;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = Ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(lb)) value = amount;
    else if (unitType.equals(oz)) value = amount * 16;
    else if (unitType.equals(g)) value = (amount * 16) * 28.34952;
    else if (unitType.equals(dr)) value = (amount * 16) * 16;

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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(ml)) return amount;
    value = galConversion(ingredient, unitType, amount) / 3785.4117888;
    if (value < 0) value = -1.0;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = Ingredients.fromCode(ingredient).getGramsPerMillileter();
    if (unitType.equals(oz)) value = amount;
    else if (unitType.equals(lb)) value = amount / 16;
    else if (unitType.equals(g)) value = amount *  28.34952;
    else if (unitType.equals(dr)) value = amount * 16;

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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(p)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 12288);
    if (value < 0) value = -1.0;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(pt)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 8);
    if (value < 0) value = -1.0;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(qt)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 4);
    if (value < 0) value = -1.0;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(tbs)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 256);
    if (value < 0) value = -1.0;
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
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(tsp)) return amount;
    value = (galConversion(ingredient, unitType, amount) / 768);
    if (value < 0) value = -1.0;
    return value;
  }

}
