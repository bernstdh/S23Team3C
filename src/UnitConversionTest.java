

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitConversionTest
{

  private String dr = "dr";
  private String oz = "oz";
  private String lb = "lb";
  private String g = "g";
//  private String ind = "individual";
  private String p = "p";
  private String tsp = "tsp";
  private String tbs = "tbs";
  private String floz = "floz";
  private String cup = "cup";
  private String pt = "pt";
  private String qt = "qt";
  private String gal = "gal";
  private String ml = "ml";
  @Test
  void dramsTest()
  {
    double drams = 4.328;
    assertEquals(4.328, UnitConversion.dramsConversions("Alcohol", dr, drams));
    
    drams = 17.45;
    assertEquals(30.91869874, UnitConversion.dramsConversions("Alcohol", g, drams));
    
    drams = 578.564;
    assertEquals(2.260015625, UnitConversion.dramsConversions("Alcohol", lb, drams));
    
    drams = 3746.0;
    assertEquals(234.125, UnitConversion.dramsConversions("Alcohol", oz, drams), 0.01);
    
    drams = -1645.8;
    assertEquals(-1.0, UnitConversion.dramsConversions("Alcohol", dr, drams));
    
    drams = 0.0;
    assertEquals(-1.0, UnitConversion.dramsConversions("Alcohol", "Trace", drams));
    
    //Test for p, ml, tsp, tbs, floz, cup, pt, qt, gal
    
  }
  
  @Test
  void gramsTest()
  {
    double grams = 94836.563;
    assertEquals(94836.563, UnitConversion.gramsConversions("Alcohol", g, grams));
    
    grams = 57.2;
    assertEquals(32.28272989085051, UnitConversion.gramsConversions("Alcohol", dr, grams));
    
    grams = 2600.89836288;
    assertEquals(5.734, UnitConversion.gramsConversions("Alcohol", lb, grams), 0.01);
    
    grams = 12;
    assertEquals(.42328759, UnitConversion.gramsConversions("Alcohol", oz, grams), 0.01);
    
    grams = -46382.0;
    assertEquals(-1.0, UnitConversion.gramsConversions("Alcohol", g, grams));
    
    grams = 564382.1;
    assertEquals(-1.0, UnitConversion.gramsConversions("Alcohol", "MAX", grams));
  }
  
  @Test
  void lbTest()
  {
    double pound = 21.2;
    assertEquals(21.2, UnitConversion.lbConversions("Alcohol", lb, pound));
    
    pound = 0.2;
    assertEquals(3.2, UnitConversion.lbConversions("Alcohol", oz, pound));
    
    pound = 0.0;
    assertEquals(0.0, UnitConversion.lbConversions("Alcohol", g, pound));
    
    pound = -10;
    assertEquals(-1, UnitConversion.lbConversions("Alcohol", p, pound));
    
    pound = 93.27;
    assertEquals(-1.0, UnitConversion.lbConversions("Alcohol", "GEE", pound));
    
    pound = 34.2;
    assertEquals(8755.2, UnitConversion.lbConversions("Alcohol", dr, pound));
    
    pound = 3827.4;
    assertEquals(1736079.25, UnitConversion.lbConversions("Alcohol", g, pound), .01);
    
  }
  
  @Test
  void ozTest()
  {
    double ounce = 846.23;
    assertEquals(846.23, UnitConversion.ozConversions("Alcohol", oz, ounce));
    
    ounce = -3672.5;
    assertEquals(-1.0, UnitConversion.ozConversions("Alcohol", p, ounce));
    
    ounce = 84.2;
    assertEquals(-1.0, UnitConversion.ozConversions("Alcohol", "JMU", ounce));
    
    assertEquals(5.2625, UnitConversion.ozConversions("Alcohol", lb, ounce));
    
    ounce = 46572.495;
    assertEquals(745159.92, UnitConversion.ozConversions("Alcohol", dr, ounce));
    
    ounce = 215.2;
    assertEquals(6100.8167, UnitConversion.ozConversions("Alcohol", g, ounce), 0.01);
    
  }
  
  @Test
  void pTest()
  {
    double pinch = 46372.0;
    assertEquals(46372.0, UnitConversion.pinchesConversion("Alcohol", p, pinch));
    
    assertEquals(-1.0, UnitConversion.pinchesConversion("Alcohol", "Negative", pinch));
    
    pinch = -453.1;
    assertEquals(-1.0, UnitConversion.pinchesConversion("Alcohol", p, pinch));
    
    pinch = 23.1;
    assertEquals(1.44375, UnitConversion.pinchesConversion("Alcohol", tsp, pinch), 0.01);
    
    pinch = 4575.67;
    assertEquals(95.3264583, UnitConversion.pinchesConversion("Alcohol", tbs, pinch), 0.01);
    
    pinch = 6727.1;
    assertEquals(70.0739583, UnitConversion.pinchesConversion("Alcohol", floz, pinch), 0.001);
    
    pinch = 846283.564;
    assertEquals(1101.93172, UnitConversion.pinchesConversion("Alcohol", cup, pinch), 0.001);
    
    pinch = 534.24;
    assertEquals(0.347813, UnitConversion.pinchesConversion("Alcohol", pt, pinch), 0.01);
    
    pinch = 78930.2;
    assertEquals(25.69342, UnitConversion.pinchesConversion("Alcohol", qt, pinch), 0.01);
    
    pinch = 1325.32;
    assertEquals(0.107855, UnitConversion.pinchesConversion("Alcohol", gal, pinch), 0.001);
    
    pinch = 5039.23;
    assertEquals(1552.373099648, UnitConversion.pinchesConversion("Alcohol", ml, pinch), 0.01);
  }
  
  @Test
  void tspTest()
  {
    double tea = 364.2;
    assertEquals(364.2, UnitConversion.tspConversion("Alcohol", tsp, tea));
    
    assertEquals(-1.0, UnitConversion.tspConversion("Alcohol", "CS", tea));
    
    tea = -0.01;
    assertEquals(-1.0, UnitConversion.tspConversion("Alcohol", gal, tea));
    
    tea = 64.2;
    assertEquals(1027.2, UnitConversion.tspConversion("Alcohol", p, tea));
    
    tea = 333.5;
    assertEquals(111.1666, UnitConversion.tspConversion("Alcohol", tbs, tea), 0.01);
    
    tea = 8463.29;
    assertEquals(1410.547877, UnitConversion.tspConversion("Alcohol", floz, tea), 0.01);
    
    tea = 4532.54;
    assertEquals(94.427916, UnitConversion.tspConversion("Alcohol",cup, tea), 0.01);
    
    tea = 9564.2;
    assertEquals(99.6270511, UnitConversion.tspConversion("Alcohol", pt, tea), 0.01);
    
    tea = 5638284.27;
    assertEquals(29366.054410833, UnitConversion.tspConversion("Alcohol", qt, tea), 0.01);
    
    tea = 94623.5637;
    assertEquals(123.2077253956, UnitConversion.tspConversion("Alcohol", gal, tea), 0.01);
    
    tea = 467.32;
    assertEquals(2303.383642112, UnitConversion.tspConversion("Alcohol", ml, tea), 0.01);
    
  }
  
  @Test
  void tbsTest()
  {
    double table = 562.6;
    assertEquals(562.6, UnitConversion.tbsConversion("Alcohol", tbs, table));
    
    assertEquals(-1.0, UnitConversion.tbsConversion("Alcohol", "Cole", table));
    
    table = -85736.46;
    assertEquals(-1.0, UnitConversion.tbsConversion("Alcohol", gal, table));
    
    table = 34.2;
    assertEquals(1641.6, UnitConversion.tbsConversion("Alcohol", p, table), 0.01);
    
    table = 675.2;
    assertEquals(2025.6, UnitConversion.tbsConversion("Alcohol", tsp, table), 0.01);
    
    table = 7463.96;
    assertEquals(3731.98, UnitConversion.tbsConversion("Alcohol", floz, table), 0.01);
    
    table = 56.2;
    assertEquals(3.5125, UnitConversion.tbsConversion("Alcohol", cup, table), 0.01);
    
    table = 674898.23;
    assertEquals(21090.56969, UnitConversion.tbsConversion("Alcohol", pt, table), 0.01);
    
    table = 75392.5;
    assertEquals(1178.00781, UnitConversion.tbsConversion("Alcohol", qt, table), 0.01);
    
    table = 5847.1;
    assertEquals(22.840234375, UnitConversion.tbsConversion("Alcohol", gal, table), 0.01);
    
    table = 4635.1;
    assertEquals(68538.13352448, UnitConversion.tbsConversion("Alcohol", ml, table), 0.01);
  }
  
  @Test
  void flozTest()
  {
    double fluid = 6748.2;
    assertEquals(6748.2, UnitConversion.flozConversion("Alcohol", floz, fluid));
    
    assertEquals(-1.0, UnitConversion.flozConversion("Alcohol", "Jeff", fluid));
    
    fluid = -100.2;
    assertEquals(-1.0, UnitConversion.flozConversion("Alcohol", gal, fluid));
    
    fluid = 56.4;
    assertEquals(5414.4, UnitConversion.flozConversion("Alcohol", p, fluid), 0.01);
    
    fluid = 98732.4;
    assertEquals(592394.4, UnitConversion.flozConversion("Alcohol", tsp, fluid), 0.01);
    
    fluid = 846.9;
    assertEquals(1693.8, UnitConversion.flozConversion("Alcohol", tbs, fluid), 0.01);
    
    fluid = 906392.24;
    assertEquals(113299.03, UnitConversion.flozConversion("Alcohol", cup, fluid), 0.01);
    
    fluid = 574.2;
    assertEquals(35.8875, UnitConversion.flozConversion("Alcohol", pt, fluid), 0.01);
    
    fluid = 985360.2;
    assertEquals(30792.50625, UnitConversion.flozConversion("Alcohol", qt, fluid), 0.01);
    
    fluid = 637.0;
    assertEquals(4.9765625, UnitConversion.flozConversion("Alcohol", gal, fluid), 0.01);
    
    fluid = 6.1;
    assertEquals(180.39853056, UnitConversion.flozConversion("Alcohol", ml, fluid), 0.01);
  }
  
  @Test
  void cupTest()
  {
    double cp = 5.1;
    assertEquals(5.1, UnitConversion.cupConversion("Alcohol", cup, cp));
    
    assertEquals(-1.0, UnitConversion.cupConversion("Alcohol", "Bruce", cp));
    
    cp = -9463.2;
    assertEquals(-1.0, UnitConversion.cupConversion("Alcohol", gal, cp));
    
    cp = 46437.1;
    assertEquals(35663692.8, UnitConversion.cupConversion("Alcohol", p, cp), 0.01);
    
    cp = 479480.2;
    assertEquals(23015049.6, UnitConversion.cupConversion("Alcohol", tsp, cp), 0.01);
    
    cp = 4630.45;
    assertEquals(74087.2, UnitConversion.cupConversion("Alcohol", tbs, cp), 0.01);
    
    cp = 574.9;
    assertEquals(4599.2, UnitConversion.cupConversion("Alcohol", floz, cp), 0.01);
    
    cp = 1.2;
    assertEquals(0.6, UnitConversion.cupConversion("Alcohol", pt, cp), 0.01);
    
    cp = 95746.3;
    assertEquals(23936.575, UnitConversion.cupConversion("Alcohol", qt, cp), 0.01);
    
    cp = 5748.2;
    assertEquals(359.2625, UnitConversion.cupConversion("Alcohol", gal, cp), 0.01);
    
    cp = 6857.3;
    assertEquals(1622356.51620864, UnitConversion.cupConversion("Alcohol", ml, cp), 0.01);
  }
  
  @Test
  void ptTest()
  {
    double pint = .01;
    assertEquals(.01, UnitConversion.ptConversion("Alcohol", pt, pint));
    
    assertEquals(-1.0, UnitConversion.ptConversion("Alcohol", "Steven", pint));
    
    pint = -20.2;
    assertEquals(-1.0, UnitConversion.ptConversion("Alcohol", gal, pint));
    
    pint = 1.2;
    assertEquals(1843.2, UnitConversion.ptConversion("Alcohol", p, pint), 0.01);
    
    pint = 34.9;
    assertEquals(3350.4, UnitConversion.ptConversion("Alcohol", tsp, pint), 0.01);
    
    pint = 739.43;
    assertEquals(23661.76, UnitConversion.ptConversion("Alcohol", tbs, pint), 0.01);
    
    pint = 99.9;
    assertEquals(1598.4, UnitConversion.ptConversion("Alcohol", floz, pint), 0.01);
    
    pint = 9674.2;
    assertEquals(19348.4, UnitConversion.ptConversion("Alcohol", cup, pint), 0.01);
    
    pint = 78.1;
    assertEquals(39.05, UnitConversion.ptConversion("Alcohol", qt, pint), 0.01);
    
    pint = 19852.1;
    assertEquals(2481.5125, UnitConversion.ptConversion("Alcohol", gal, pint), 0.01);
    
    pint = 89.2;
    assertEquals(42207.34144512, UnitConversion.ptConversion("Alcohol", ml, pint), 0.01);
  }
  
  @Test
  void qtTest()
  {
    double quart = 19968.56;
    assertEquals(19968.56, UnitConversion.qtConversion("Alcohol", qt, quart));
    
    assertEquals(-1.0, UnitConversion.qtConversion("Alcohol", "Quart", quart));
    
    quart = -6553.29;
    assertEquals(-1.0, UnitConversion.qtConversion("Alcohol", gal, quart));
    
    quart = 392.56;
    assertEquals(1205944.32, UnitConversion.qtConversion("Alcohol", p, quart), 0.01);
    
    quart = 21.3;
    assertEquals(4089.6, UnitConversion.qtConversion("Alcohol", tsp, quart), 0.01);
    
    quart = 724.92;
    assertEquals(46394.88, UnitConversion.qtConversion("Alcohol", tbs, quart), 0.01);
    
    quart = 462891.2973;
    assertEquals(14812521.5136, UnitConversion.qtConversion("Alcohol", floz, quart), 0.01);
    
    quart = 186927.465;
    assertEquals(747709.86, UnitConversion.qtConversion("Alcohol", cup, quart), 0.01);
    
    quart = 98215.34;
    assertEquals(196430.68, UnitConversion.qtConversion("Alcohol", pt, quart), 0.01);
    
    quart = 7563.2;
    assertEquals(1890.8, UnitConversion.qtConversion("Alcohol", gal, quart), 0.01);
    
    quart = 15.7;
    assertEquals(14857.74127104, UnitConversion.qtConversion("Alcohol", ml, quart), 0.01);
  }
  
  @Test
  void galTest()
  {
    double gallon = 756.24;
    assertEquals(756.24, UnitConversion.galConversion("Alcohol", gal, gallon));
    
    assertEquals(-1.0, UnitConversion.galConversion("Alcohol", "gallon", gallon));
    
    gallon = -0.0001;
    assertEquals(-1.0, UnitConversion.galConversion("Alcohol", gal, gallon));
    
    gallon = 968.1;
    assertEquals(11896012.8, UnitConversion.galConversion("Alcohol", p, gallon), 0.01);
    
    gallon = 78.4;
    assertEquals(60211.2, UnitConversion.galConversion("Alcohol", tsp, gallon), 0.01);
    
    gallon = 42890.3;
    assertEquals(10979916.8, UnitConversion.galConversion("Alcohol", tbs, gallon), 0.01);
    
    gallon = 6830.46;
    assertEquals(874298.88, UnitConversion.galConversion("Alcohol", floz, gallon), 0.01);
    
    gallon = 94268.01;
    assertEquals(1508288.16, UnitConversion.galConversion("Alcohol", cup, gallon), 0.01);
    
    gallon = 120583.01;
    assertEquals(964664.08, UnitConversion.galConversion("Alcohol", pt, gallon), 0.01);
    
    gallon = 739286.4927;
    assertEquals(2957145.9708, UnitConversion.galConversion("Alcohol", qt, gallon), 0.01);
    
    gallon = 2.9;
    assertEquals(10977.69418752, UnitConversion.galConversion("Alcohol", ml, gallon), 0.01);
  }
  
  @Test
  void mlTest()
  {
    double milli = 97.4;
    assertEquals(97.4, UnitConversion.mlConversion("Alcohol", ml, milli));
    
    assertEquals(-1.0, UnitConversion.mlConversion("Alcohol", "liters", milli));
    
    milli = -5.75;
    assertEquals(-1.0, UnitConversion.mlConversion("Alcohol", gal, milli));
    
    milli = 4167.37;
    assertEquals(13527.89219, UnitConversion.mlConversion("Alcohol", p, milli), 0.01);
    
    milli = 20.6;
    assertEquals(4.17941, UnitConversion.mlConversion("Alcohol", tsp, milli), 0.01);
    
    milli = 52197.62;
    assertEquals(3530.02301, UnitConversion.mlConversion("Alcohol", tbs, milli), 0.01);
    
    milli = 8273416.81;
    assertEquals(279757.50348, UnitConversion.mlConversion("Alcohol", floz, milli), 0.01);
    
    milli = 3826719.8;
    assertEquals(16174.59875, UnitConversion.mlConversion("Alcohol", cup, milli), 0.01);
    
    milli = 609284.105;
    assertEquals(1287.64666, UnitConversion.mlConversion("Alcohol", pt, milli), 0.01);
    
    milli = 194625.03;
    assertEquals(205.65797, UnitConversion.mlConversion("Alcohol", qt, milli), 0.01);
    
    milli = 9362719.34;
    assertEquals(2473.36878, UnitConversion.mlConversion("Alcohol", gal, milli), 0.01);
  }

}
