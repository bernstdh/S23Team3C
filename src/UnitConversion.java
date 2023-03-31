package utilities;

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
  private static String dr = "dr";
  private static String oz = "oz";
  private static String lbs = "lbs";
  private static String g = "g";
//  private static String ind = "individual";
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
   * Conversions for drams.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double dramsConversions(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = 0.0;
    if (unitType.equals(dr)) value = amount;
    
    else if (unitType.equals(oz)) value = amount / 16;
    
    else if (unitType.equals(lbs)) value = amount / 256;
    
    else if (unitType.equals(g)) value = amount * 1.7718452;
    
    else if (unitType.equals(ml))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(p))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(tsp))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(tbs))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(floz))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(cup))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(pt))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(qt))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(gal))
    {
      double grams = gramsConversions(dr, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }   
    return value;
  }
  
  /**
   * Conversions for grams.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double gramsConversions(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = 0.0;
    if (unitType.equals(g)) value = amount;
    else if (unitType.equals(oz)) value = amount / 28.34952;
    else if (unitType.equals(lbs)) value = ((amount / 28.34952) / 16);
    else if (unitType.equals(dr)) value = (amount / 1.7718452);

    else if (unitType.equals(ml)) value = amount / volume;
    else if (unitType.equals(p)) value = mlConversion(unitType, (amount / volume));
    else if (unitType.equals(tsp)) value = mlConversion(unitType, (amount / volume));
    else if (unitType.equals(tbs)) value = mlConversion(unitType, (amount / volume));
    else if (unitType.equals(floz)) value = mlConversion(unitType, (amount / volume));
    else if (unitType.equals(cup)) value = mlConversion(unitType, (amount / volume));
    else if (unitType.equals(pt)) value = mlConversion(unitType, (amount / volume));
    else if (unitType.equals(qt)) value = mlConversion(unitType, (amount / volume));
    else if (unitType.equals(gal)) value = mlConversion(unitType, (amount / volume));
    
    return value;
  }
  
  /**
   * Conversions for lbs.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double lbsConversions(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = 0.0;
    if (unitType.equals(lbs)) value = amount;
    else if (unitType.equals(oz)) value = amount * 16;
    else if (unitType.equals(g)) value = (amount * 16) * 28.34952;
    else if (unitType.equals(dr)) value = (amount * 16) * 16;

    else if (unitType.equals(ml))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(p))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(tsp))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(tbs))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(floz))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(cup))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(pt))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(qt))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(gal))
    {
      double grams = gramsConversions(lbs, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }   
    return value;
  }
  
  /**
   * Conversions for oz.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double ozConversions(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = 0.0;
    if (unitType.equals(oz)) value = amount;
    else if (unitType.equals(lbs)) value = amount / 16;
    else if (unitType.equals(g)) value = amount *  28.34952;
    else if (unitType.equals(dr)) value = amount * 16;

    else if (unitType.equals(ml))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(p))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(tsp))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(tbs))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(floz))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(cup))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(pt))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(qt))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }
    
    else if (unitType.equals(gal))
    {
      double grams = gramsConversions(oz, amount);
      double milli = (grams / volume);
      value = mlConversion(unitType, milli);      
    }   
    return value;
  }

  /**
   * Conversions for pinches.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double pinchesConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(p)) return amount;
    else if (unitType.equals(ml)) value = amount * 0.3080576;
    else if (unitType.equals(tsp)) value = amount / 16;
    else if (unitType.equals(tbs)) value = amount / 48;
    else if (unitType.equals(floz)) value = amount / 96;
    else if (unitType.equals(cup)) value = amount / 768;
    else if (unitType.equals(pt)) value = amount / 1536;
    else if (unitType.equals(qt)) value = amount / 3072;
    else if (unitType.equals(gal)) value = amount / 12288;
    if (value < 0) value = -1.0;
    return value;
  }
  
  /**
   * Conversions for tsp.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double tspConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(tsp)) return amount;
//    else if (unitType.equals(ml)) value = amount * 4.9289216;
//    else if (unitType.equals(p)) value = amount * 16;
//    else if (unitType.equals(tbs)) value = amount / 3;
//    else if (unitType.equals(floz)) value = amount / 6;
//    else if (unitType.equals(cup)) value = amount / 48;
//    else if (unitType.equals(pt)) value = amount / 96;
//    else if (unitType.equals(qt)) value = amount / 192;
//    else if (unitType.equals(gal)) value = amount / 768;
    value = (galConversion(unitType, amount) / 768);
    if (value < 0) value = -1.0;
    return value;
  }
  
  /**
   * Conversions for tbs.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double tbsConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(tbs)) return amount;
//    else if (unitType.equals(ml)) value = amount * 14.7867648;
//    else if (unitType.equals(p)) value = amount * 48;
//    else if (unitType.equals(tsp)) value = amount * 3;
//    else if (unitType.equals(floz)) value = amount / 2;
//    else if (unitType.equals(cup)) value = amount / 16;
//    else if (unitType.equals(pt)) value = amount / 32;
//    else if (unitType.equals(qt)) value = amount / 64;
//    else if (unitType.equals(gal)) value = amount / 256;
    value = (galConversion(unitType, amount) / 256);
    if (value < 0) value = -1.0;
    return value;
  }
  
  /**
   * Conversions for floz.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double flozConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(floz)) return amount;
//    else if (unitType.equals(ml)) value = amount * 29.5735296;
//    else if (unitType.equals(p)) value = amount * 96;
//    else if (unitType.equals(tsp)) value = amount * 6;
//    else if (unitType.equals(tbs)) value = amount * 2;
//    else if (unitType.equals(cup)) value = amount / 8;
//    else if (unitType.equals(pt)) value = amount / 16;
//    else if (unitType.equals(qt)) value = amount / 32;
//    else if (unitType.equals(gal)) value = amount / 128;
    value = galConversion(unitType, amount) / 128;
    if (value < 0) value = -1.0;
    return value;
  }
  
  /**
   * Conversions for cup.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double cupConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(cup)) return amount;
//    else if (unitType.equals(ml)) value = amount * 236.5882368;
//    else if (unitType.equals(p)) value = amount * 768;
//    else if (unitType.equals(tsp)) value = amount * 48;
//    else if (unitType.equals(tbs)) value = amount * 16;
//    else if (unitType.equals(floz)) value = amount * 8;
//    else if (unitType.equals(pt)) value = amount / 2;
//    else if (unitType.equals(qt)) value = amount / 4;
//    else if (unitType.equals(gal)) value = amount / 16;
    value = (galConversion(unitType, amount) / 16);
    if (value < 0) value = -1.0;
    return value;
  }
  
  /**
   * Conversions for pt.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double ptConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(pt)) return amount;
//    else if (unitType.equals(ml)) value = amount * 473.1764736;
//    else if (unitType.equals(p)) value = amount * 1536;
//    else if (unitType.equals(tsp)) value = amount * 96;
//    else if (unitType.equals(tbs)) value = amount * 32;
//    else if (unitType.equals(floz)) value = amount * 16;
//    else if (unitType.equals(cup)) value = amount * 2;
//    else if (unitType.equals(qt)) value = amount / 2;
//    else if (unitType.equals(gal)) value = amount / 8;
    value = (galConversion(unitType, amount) / 8);
    if (value < 0) value = -1.0;
    return value;
  }
  
  /**
   * Conversions for qt.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double qtConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(qt)) return amount;
//    else if (unitType.equals(ml)) value = amount * 946.3529472;
//    else if (unitType.equals(p)) value = amount * 3072;
//    else if (unitType.equals(tsp)) value = amount * 192;
//    else if (unitType.equals(tbs)) value = amount * 64;
//    else if (unitType.equals(floz)) value = amount * 32;
//    else if (unitType.equals(cup)) value = amount * 4;
//    else if (unitType.equals(pt)) value = amount * 2;
//    else if (unitType.equals(gal)) value = amount / 4;
    value = (galConversion(unitType, amount) / 4);
    if (value < 0) value = -1.0;
    return value;
  }
  
  /**
   * Conversions for gal.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double galConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    double volume = 0.0;
    if (unitType.equals(gal)) value = amount;
    else if (unitType.equals(lbs))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(lbs, grams);
    }
    else if (unitType.equals(oz))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(oz, grams);
    }
    else if (unitType.equals(g))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(g, grams);
    }
    else if (unitType.equals(dr))
    {
      double milli = amount * 3785.4117888;
      double grams = milli * volume;
      value = gramsConversions(dr, grams);
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
   * Conversions for ml.
   * @param unitType - the type of unit it is switching to
   * @param amount - the amount of the current unit
   * @return the amount in the new units
   */
  public static double mlConversion(final String unitType, final Double amount)
  {
    if (amount < 0) return -1.0;
    double value = -1.0;
    if (unitType.equals(ml)) return amount;
    value = galConversion(unitType, amount) / 3785.4117888;
    if (value < 0) value = -1.0;
    return value;
  }

}
