package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.UnitConversion;

class UnitConversionTest
{

  private String dr = "dr";
  private String oz = "oz";
  private String lbs = "lbs";
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
    assertEquals(4.328, UnitConversion.dramsConversions(dr, drams));
    
    drams = 17.45;
    assertEquals(30.91869874, UnitConversion.dramsConversions(g, drams));
    
    drams = 578.564;
    assertEquals(2.260015625, UnitConversion.dramsConversions(lbs, drams));
    
    drams = 3746.0;
    assertEquals(234.125, UnitConversion.dramsConversions(oz, drams), 0.01);
    
    drams = -1645.8;
    assertEquals(-1.0, UnitConversion.dramsConversions(dr, drams));
    
    drams = 0.0;
    assertEquals(-1.0, UnitConversion.dramsConversions("Trace", drams));
    
    //Test for p, ml, tsp, tbs, floz, cup, pt, qt, gal
    
  }
  
  @Test
  void gramsTest()
  {
    double grams = 94836.563;
    assertEquals(94836.563, UnitConversion.gramsConversions(g, grams));
    
    grams = 57.2;
    assertEquals(32.28272989085051, UnitConversion.gramsConversions(dr, grams));
    
    grams = 2600.89836288;
    assertEquals(5.734, UnitConversion.gramsConversions(lbs, grams), 0.01);
    
    grams = 12;
    assertEquals(.42328759, UnitConversion.gramsConversions(oz, grams), 0.01);
    
    grams = -46382.0;
    assertEquals(-1.0, UnitConversion.gramsConversions(g, grams));
    
    grams = 564382.1;
    assertEquals(-1.0, UnitConversion.gramsConversions("MAX", grams));
  }
  
  @Test
  void lbsTest()
  {
    double pound = 21.2;
    assertEquals(21.2, UnitConversion.lbsConversions(lbs, pound));
    
    pound = 0.2;
    assertEquals(3.2, UnitConversion.lbsConversions(oz, pound));
    
    pound = 0.0;
    assertEquals(0.0, UnitConversion.lbsConversions(g, pound));
    
    pound = -10;
    assertEquals(-1, UnitConversion.lbsConversions(p, pound));
    
    pound = 93.27;
    assertEquals(-1.0, UnitConversion.lbsConversions("GEE", pound));
    
    pound = 34.2;
    assertEquals(8755.2, UnitConversion.lbsConversions(dr, pound));
    
    pound = 3827.4;
    assertEquals(1736079.25, UnitConversion.lbsConversions(g, pound), .01);
    
  }
  
  @Test
  void ozTest()
  {
    double ounce = 846.23;
    assertEquals(846.23, UnitConversion.ozConversions(oz, ounce));
    
    ounce = -3672.5;
    assertEquals(-1.0, UnitConversion.ozConversions(p, ounce));
    
    ounce = 84.2;
    assertEquals(-1.0, UnitConversion.ozConversions("JMU", ounce));
    
    assertEquals(5.2625, UnitConversion.ozConversions(lbs, ounce));
    
    ounce = 46572.495;
    assertEquals(745159.92, UnitConversion.ozConversions(dr, ounce));
    
    ounce = 215.2;
    assertEquals(6100.8167, UnitConversion.ozConversions(g, ounce), 0.01);
    
  }
  
  @Test
  void pTest()
  {
    double pinch = 46372.0;
    assertEquals(46372.0, UnitConversion.pinchesConversion(p, pinch));
    
    assertEquals(-1.0, UnitConversion.pinchesConversion("Negative", pinch));
    
    pinch = -453.1;
    assertEquals(-1.0, UnitConversion.pinchesConversion(p, pinch));
    
    pinch = 23.1;
    assertEquals(1.44375, UnitConversion.pinchesConversion(tsp, pinch));
    
    pinch = 4575.67;
    assertEquals(95.3264583, UnitConversion.pinchesConversion(tbs, pinch), 0.01);
    
    pinch = 6727.1;
    assertEquals(70.0739583, UnitConversion.pinchesConversion(floz, pinch), 0.001);
    
    pinch = 846283.564;
    assertEquals(1101.93172, UnitConversion.pinchesConversion(cup, pinch), 0.001);
    
    pinch = 534.24;
    assertEquals(0.347813, UnitConversion.pinchesConversion(pt, pinch), 0.01);
    
    pinch = 78930.2;
    assertEquals(25.69342, UnitConversion.pinchesConversion(qt, pinch), 0.01);
    
    pinch = 1325.32;
    assertEquals(0.107855, UnitConversion.pinchesConversion(gal, pinch), 0.001);
    
    pinch = 5039.23;
    assertEquals(1552.373099648, UnitConversion.pinchesConversion(ml, pinch), 0.01);
  }
  
  @Test
  void tspTest()
  {
    double tea = 364.2;
    assertEquals(364.2, UnitConversion.tspConversion(tsp, tea));
    
    assertEquals(-1.0, UnitConversion.tspConversion("CS", tea));
    
    tea = -0.01;
    assertEquals(-1.0, UnitConversion.tspConversion(gal, tea));
    
    tea = 64.2;
    assertEquals(1027.2, UnitConversion.tspConversion(p, tea));
    
    tea = 333.5;
    assertEquals(111.1666, UnitConversion.tspConversion(tbs, tea), 0.01);
    
    tea = 8463.29;
    assertEquals(1410.547877, UnitConversion.tspConversion(floz, tea), 0.01);
    
    tea = 4532.54;
    assertEquals(94.427916, UnitConversion.tspConversion(cup, tea), 0.01);
    
    tea = 9564.2;
    assertEquals(99.6270511, UnitConversion.tspConversion(pt, tea), 0.01);
    
    tea = 5638284.27;
    assertEquals(29366.054410833, UnitConversion.tspConversion(qt, tea), 0.01);
    
    tea = 94623.5637;
    assertEquals(123.2077253956, UnitConversion.tspConversion(gal, tea), 0.01);
    
    tea = 467.32;
    assertEquals(2303.383642112, UnitConversion.tspConversion(ml, tea), 0.01);
    
  }
  
  @Test
  void tbsTest()
  {
    double table = 562.6;
    assertEquals(562.6, UnitConversion.tbsConversion(tbs, table));
    
    assertEquals(-1.0, UnitConversion.tbsConversion("Cole", table));
    
    table = -85736.46;
    assertEquals(-1.0, UnitConversion.tbsConversion(gal, table));
    
    table = 34.2;
    assertEquals(1641.6, UnitConversion.tbsConversion(p, table), 0.01);
    
    table = 675.2;
    assertEquals(2025.6, UnitConversion.tbsConversion(tsp, table), 0.01);
    
    table = 7463.96;
    assertEquals(3731.98, UnitConversion.tbsConversion(floz, table), 0.01);
    
    table = 56.2;
    assertEquals(3.5125, UnitConversion.tbsConversion(cup, table), 0.01);
    
    table = 674898.23;
    assertEquals(21090.56969, UnitConversion.tbsConversion(pt, table), 0.01);
    
    table = 75392.5;
    assertEquals(1178.00781, UnitConversion.tbsConversion(qt, table), 0.01);
    
    table = 5847.1;
    assertEquals(22.840234375, UnitConversion.tbsConversion(gal, table), 0.01);
    
    table = 4635.1;
    assertEquals(68538.13352448, UnitConversion.tbsConversion(ml, table), 0.01);
  }
  
  @Test
  void flozTest()
  {
    double fluid = 6748.2;
    assertEquals(6748.2, UnitConversion.flozConversion(floz, fluid));
    
    assertEquals(-1.0, UnitConversion.flozConversion("Jeff", fluid));
    
    fluid = -100.2;
    assertEquals(-1.0, UnitConversion.flozConversion(gal, fluid));
    
    fluid = 56.4;
    assertEquals(5414.4, UnitConversion.flozConversion(p, fluid), 0.01);
    
    fluid = 98732.4;
    assertEquals(592394.4, UnitConversion.flozConversion(tsp, fluid), 0.01);
    
    fluid = 846.9;
    assertEquals(1693.8, UnitConversion.flozConversion(tbs, fluid), 0.01);
    
    fluid = 906392.24;
    assertEquals(113299.03, UnitConversion.flozConversion(cup, fluid), 0.01);
    
    fluid = 574.2;
    assertEquals(35.8875, UnitConversion.flozConversion(pt, fluid), 0.01);
    
    fluid = 985360.2;
    assertEquals(30792.50625, UnitConversion.flozConversion(qt, fluid), 0.01);
    
    fluid = 637.0;
    assertEquals(4.9765625, UnitConversion.flozConversion(gal, fluid), 0.01);
    
    fluid = 6.1;
    assertEquals(180.39853056, UnitConversion.flozConversion(ml, fluid), 0.01);
  }
  
  @Test
  void cupTest()
  {
    double cp = 5.1;
    assertEquals(5.1, UnitConversion.cupConversion(cup, cp));
    
    assertEquals(-1.0, UnitConversion.cupConversion("Bruce", cp));
    
    cp = -9463.2;
    assertEquals(-1.0, UnitConversion.cupConversion(gal, cp));
    
    cp = 46437.1;
    assertEquals(35663692.8, UnitConversion.cupConversion(p, cp), 0.01);
    
    cp = 479480.2;
    assertEquals(23015049.6, UnitConversion.cupConversion(tsp, cp), 0.01);
    
    cp = 4630.45;
    assertEquals(74087.2, UnitConversion.cupConversion(tbs, cp), 0.01);
    
    cp = 574.9;
    assertEquals(4599.2, UnitConversion.cupConversion(floz, cp), 0.01);
    
    cp = 1.2;
    assertEquals(0.6, UnitConversion.cupConversion(pt, cp), 0.01);
    
    cp = 95746.3;
    assertEquals(23936.575, UnitConversion.cupConversion(qt, cp), 0.01);
    
    cp = 5748.2;
    assertEquals(359.2625, UnitConversion.cupConversion(gal, cp), 0.01);
    
    cp = 6857.3;
    assertEquals(1622356.51620864, UnitConversion.cupConversion(ml, cp), 0.01);
  }
  
  @Test
  void ptTest()
  {
    double pint = .01;
    assertEquals(.01, UnitConversion.ptConversion(pt, pint));
    
    assertEquals(-1.0, UnitConversion.ptConversion("Steven", pint));
    
    pint = -20.2;
    assertEquals(-1.0, UnitConversion.ptConversion(gal, pint));
    
    pint = 1.2;
    assertEquals(1843.2, UnitConversion.ptConversion(p, pint), 0.01);
    
    pint = 34.9;
    assertEquals(3350.4, UnitConversion.ptConversion(tsp, pint), 0.01);
    
    pint = 739.43;
    assertEquals(23661.76, UnitConversion.ptConversion(tbs, pint), 0.01);
    
    pint = 99.9;
    assertEquals(1598.4, UnitConversion.ptConversion(floz, pint), 0.01);
    
    pint = 9674.2;
    assertEquals(19348.4, UnitConversion.ptConversion(cup, pint), 0.01);
    
    pint = 78.1;
    assertEquals(39.05, UnitConversion.ptConversion(qt, pint), 0.01);
    
    pint = 19852.1;
    assertEquals(2481.5125, UnitConversion.ptConversion(gal, pint), 0.01);
    
    pint = 89.2;
    assertEquals(42207.34144512, UnitConversion.ptConversion(ml, pint), 0.01);
  }
  
  @Test
  void qtTest()
  {
    double quart = 19968.56;
    assertEquals(19968.56, UnitConversion.qtConversion(qt, quart));
    
    assertEquals(-1.0, UnitConversion.qtConversion("Quart", quart));
    
    quart = -6553.29;
    assertEquals(-1.0, UnitConversion.qtConversion(gal, quart));
    
    quart = 392.56;
    assertEquals(1205944.32, UnitConversion.qtConversion(p, quart), 0.01);
    
    quart = 21.3;
    assertEquals(4089.6, UnitConversion.qtConversion(tsp, quart), 0.01);
    
    quart = 724.92;
    assertEquals(46394.88, UnitConversion.qtConversion(tbs, quart), 0.01);
    
    quart = 462891.2973;
    assertEquals(14812521.5136, UnitConversion.qtConversion(floz, quart), 0.01);
    
    quart = 186927.465;
    assertEquals(747709.86, UnitConversion.qtConversion(cup, quart), 0.01);
    
    quart = 98215.34;
    assertEquals(196430.68, UnitConversion.qtConversion(pt, quart), 0.01);
    
    quart = 7563.2;
    assertEquals(1890.8, UnitConversion.qtConversion(gal, quart), 0.01);
    
    quart = 15.7;
    assertEquals(14857.74127104, UnitConversion.qtConversion(ml, quart), 0.01);
  }
  
  @Test
  void galTest()
  {
    double gallon = 756.24;
    assertEquals(756.24, UnitConversion.galConversion(gal, gallon));
    
    assertEquals(-1.0, UnitConversion.galConversion("gallon", gallon));
    
    gallon = -0.0001;
    assertEquals(-1.0, UnitConversion.galConversion(gal, gallon));
    
    gallon = 968.1;
    assertEquals(11896012.8, UnitConversion.galConversion(p, gallon), 0.01);
    
    gallon = 78.4;
    assertEquals(60211.2, UnitConversion.galConversion(tsp, gallon), 0.01);
    
    gallon = 42890.3;
    assertEquals(10979916.8, UnitConversion.galConversion(tbs, gallon), 0.01);
    
    gallon = 6830.46;
    assertEquals(874298.88, UnitConversion.galConversion(floz, gallon), 0.01);
    
    gallon = 94268.01;
    assertEquals(1508288.16, UnitConversion.galConversion(cup, gallon), 0.01);
    
    gallon = 120583.01;
    assertEquals(964664.08, UnitConversion.galConversion(pt, gallon), 0.01);
    
    gallon = 739286.4927;
    assertEquals(2957145.9708, UnitConversion.galConversion(qt, gallon), 0.01);
    
    gallon = 2.9;
    assertEquals(10977.69418752, UnitConversion.galConversion(ml, gallon), 0.01);
  }
  
  @Test
  void mlTest()
  {
    double milli = 97.4;
    assertEquals(97.4, UnitConversion.mlConversion(ml, milli));
    
    assertEquals(-1.0, UnitConversion.mlConversion("liters", milli));
    
    milli = -5.75;
    assertEquals(-1.0, UnitConversion.mlConversion(gal, milli));
    
    milli = 4167.37;
    assertEquals(13527.89219, UnitConversion.mlConversion(p, milli), 0.01);
    
    milli = 20.6;
    assertEquals(4.17941, UnitConversion.mlConversion(tsp, milli), 0.01);
    
    milli = 52197.62;
    assertEquals(3530.02301, UnitConversion.mlConversion(tbs, milli), 0.01);
    
    milli = 8273416.81;
    assertEquals(279757.50348, UnitConversion.mlConversion(floz, milli), 0.01);
    
    milli = 3826719.8;
    assertEquals(16174.59875, UnitConversion.mlConversion(cup, milli), 0.01);
    
    milli = 609284.105;
    assertEquals(1287.64666, UnitConversion.mlConversion(pt, milli), 0.01);
    
    milli = 194625.03;
    assertEquals(205.65797, UnitConversion.mlConversion(qt, milli), 0.01);
    
    milli = 9362719.34;
    assertEquals(2473.36878, UnitConversion.mlConversion(gal, milli), 0.01);
  }

}
