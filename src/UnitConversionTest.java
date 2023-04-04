

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
    
    drams = 54.3;
    assertEquals(743.6085728309065, UnitConversion.dramsConversions("Bread", p, drams));
    
    drams = 163.2;
    assertEquals(222.43472049230766, UnitConversion.dramsConversions("Lamb", ml, drams));
    
    drams = 21.1;
    assertEquals(5.056675239738716, UnitConversion.dramsConversions("Honey", tsp, drams));
    
    drams = 99.2;
    assertEquals(15.437378709364207, UnitConversion.dramsConversions("Lemon", tbs, drams), 0.01);
    
    drams = 276.94;
    assertEquals(21.00299419421141, UnitConversion.dramsConversions("Kidney bean", floz, drams));
    
    drams = 963.78;
    assertEquals(5.509843238481082, UnitConversion.dramsConversions("Pasta", cup, drams));
    
    drams = 5945.352;
    assertEquals(185.52351309446, UnitConversion.dramsConversions("Cornflake", pt, drams));
    
    drams = 16382.956;
    assertEquals(90.21650225524553, UnitConversion.dramsConversions("Cheddar cheese", qt, drams));
    
    drams = 5648362.54;
    assertEquals(7145.514192262774, UnitConversion.dramsConversions("Broccoli", gal, drams));
    
    
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
    
    grams = 475.3;
    assertEquals(2410.7707454709766, UnitConversion.gramsConversions("Carrot", p, grams));
    
    grams = 27.29;
    assertEquals(26.240384615384613, UnitConversion.gramsConversions("Apple juice", ml, grams));
    
    grams = 2014.3;
    assertEquals(609.9545000772097, UnitConversion.gramsConversions("Cucumber", tsp, grams));
    
    grams = 83.67;
    assertEquals(4.041741822679544, UnitConversion.gramsConversions("Ham", tbs, grams), 0.01);
    
    grams = 9563.2;
    assertEquals(718.6005810938292, UnitConversion.gramsConversions("Flour", floz, grams));
    
    grams = 3709.1;
    assertEquals(26.129081550910534, UnitConversion.gramsConversions("Egg", cup, grams));
    
    grams = 57694.325;
    assertEquals(154.34155164903044, UnitConversion.gramsConversions("Rum", pt, grams));
    
    grams = 94723.346;
    assertEquals(101.10408358513483, UnitConversion.gramsConversions("Wine", qt, grams));
    
    grams = 76849.21;
    assertEquals(23.069788070522304, UnitConversion.gramsConversions("Oil", gal, grams));
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

    pound = 7.3;
    assertEquals(17620.84740209538, UnitConversion.lbConversions("Pear", p, pound));
    
    pound = 19.673;
    assertEquals(16836.833417660375, UnitConversion.lbConversions("Peanut", ml, pound));
    
    pound = 90.368;
    assertEquals(14338.392332898247, UnitConversion.lbConversions("Salmon", tsp, pound));
    
    pound = 67.215;
    assertEquals(2786.294456761473, UnitConversion.lbConversions("Onion", tbs, pound), 0.01);
    
    pound = 957.35;
    assertEquals(11208.873761330091, UnitConversion.lbConversions("Macaroni", floz, pound));
    
    pound = 2743.52;
    assertEquals(9563.52474814627, UnitConversion.lbConversions("Ice cream", cup, pound));
    
    pound = 96754.34;
    assertEquals(89182.50459164254, UnitConversion.lbConversions("Milk", pt, pound));
    
    pound = 30563.45;
    assertEquals(25257.300769891284, UnitConversion.lbConversions("Haddock", qt, pound));
    
    pound = 1.2;
    assertEquals(0.2357240930288872, UnitConversion.lbConversions("Crab", gal, pound));
    
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
    
    ounce = .56;
    assertEquals(88.85335192128872, UnitConversion.ozConversions("Cod", p, ounce));
    
    ounce = 25.67;
    assertEquals(1617.1826186666665, UnitConversion.ozConversions("Cinnamon", ml, ounce));
    
    ounce = 43.692;
    assertEquals(188.94877636983654, UnitConversion.ozConversions("Chocolate", tsp, ounce));
    
    ounce = 253.47;
    assertEquals(1518.6200572758144, UnitConversion.ozConversions("Garlic", tbs, ounce), 0.01);
    
    ounce = 724.36;
    assertEquals(2104.1808779011494, UnitConversion.ozConversions("Grapefruit", floz, ounce));
    
    ounce = 904.8345;
    assertEquals(1807.051222649798, UnitConversion.ozConversions("Lettuce", cup, ounce));
    
    ounce = 756.436;
    assertEquals(74.29591251433307, UnitConversion.ozConversions("Celery", pt, ounce));
    
    ounce = 70485.43;
    assertEquals(4223.0081565357, UnitConversion.ozConversions("Cashew", qt, ounce));
    
    ounce = 385563.5736;
    assertEquals(3173.125025871127, UnitConversion.ozConversions("Butter", gal, ounce));
    
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
    
    pinch = 12.43;
    assertEquals(5.743733952, UnitConversion.pinchesConversion("Brown sugar", g, pinch));
    
    pinch = 7543.58;
    assertEquals(695.119579075102, UnitConversion.pinchesConversion("Blackberry", dr, pinch));
    
    pinch = 3547.23;
    assertEquals(29.68016366926001, UnitConversion.pinchesConversion("Bean", oz, pinch));
    
    pinch = 59473.45;
    assertEquals(42.41101499305808, UnitConversion.pinchesConversion("Beef", lb, pinch));
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
    
    tea = 5743.32;
    assertEquals(15003.438221967363, UnitConversion.tspConversion("Green bean", g, tea));
    
    tea = 47353.49;
    assertEquals(60594.88394377604, UnitConversion.tspConversion("Almond", dr, tea));
    
    tea = 570.436;
    assertEquals(103.14459273703064, UnitConversion.tspConversion("Chicken", oz, tea));
    
    tea = 95740.33;
    assertEquals(1061.1610711104868, UnitConversion.tspConversion("Cherry", lb, tea));
    
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
    
    table = 56436.32;
    assertEquals(851200.8018178866, UnitConversion.tbsConversion("Cherry", g, table));
    
    table = 38201.245;
    assertEquals(306052.6460702599, UnitConversion.tbsConversion("Cottage cheese", dr, table));
    
    table = 90.3027;
    assertEquals(26.376442352278904, UnitConversion.tbsConversion("Apple", oz, table));
    
    table = 56436.32;
    assertEquals(846.2993187540445, UnitConversion.tbsConversion("Thyme", lb, table));
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
    
    fluid = 27.34;
    assertEquals(371.92853766144003, UnitConversion.flozConversion("Thyme", g, fluid));
    
    fluid = 382.493;
    assertEquals(4468.882292936742, UnitConversion.flozConversion("Pork", dr, fluid));
    
    fluid = 5853.568;
    assertEquals(4091.2208236372467, UnitConversion.flozConversion("Tomato", oz, fluid));
    
    fluid = 39673.4836;
    assertEquals(1500.2574693421495, UnitConversion.flozConversion("Plum", lb, fluid));
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
    
    cp = 17.54638;
    assertEquals(3030.4249876886324, UnitConversion.cupConversion("Peas", g, cp));
    
    cp = 9483.5362;
    assertEquals(683803.6857965725, UnitConversion.cupConversion("Pineapple", dr, cp));
    
    cp = 28402.3451;
    assertEquals(327100.1354699439, UnitConversion.cupConversion("Syrup", oz, cp));
    
    cp = 4839.42;
    assertEquals(2145.5552161783903, UnitConversion.cupConversion("Lentil", lb, cp));
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
    
    pint = 203.284;
    assertEquals(7695.136500744193, UnitConversion.ptConversion("Spinach", g, pint));
    
    pint = 3857.36101;
    assertEquals(442951.43077340606, UnitConversion.ptConversion("Saltine crackers", dr, pint));
    
    pint = 49032.40146;
    assertEquals(1072091.5997035154, UnitConversion.ptConversion("Spaghetti", oz, pint));
    
    pint = 13.28;
    assertEquals(8.034956302295065, UnitConversion.ptConversion("Strawberries", lb, pint));
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
    
    quart = 7.23;
    assertEquals(4447.3856753664, UnitConversion.qtConversion("Sweet potato", g, quart));
    
    quart = 732.36;
    assertEquals(254252.56047616625, UnitConversion.qtConversion("Olive", dr, quart));
    
    quart = 4638.2901;
    assertEquals(181155.36425806122, UnitConversion.qtConversion("Mushroom", oz, quart));
    
    quart = 8323.1039;
    System.out.println(UnitConversion.qtConversion("Peach", lb, quart));
    assertEquals(10592.600603172155, UnitConversion.qtConversion("Peach", lb, quart));
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
    
    gallon = 8323.1039;
    System.out.println(UnitConversion.galConversion("Peach", g, gallon));
    assertEquals(10592.600603172155, UnitConversion.galConversion("Peach", g, gallon));
    
    gallon = 8323.1039;
    System.out.println(UnitConversion.galConversion("Peach", dr, gallon));
    assertEquals(10592.600603172155, UnitConversion.galConversion("Peach", dr, gallon));
    
    gallon = 8323.1039;
    System.out.println(UnitConversion.galConversion("Peach", oz, gallon));
    assertEquals(10592.600603172155, UnitConversion.galConversion("Peach", oz, gallon));
    
    gallon = 8323.1039;
    System.out.println(UnitConversion.galConversion("Peach", lb, gallon));
    assertEquals(10592.600603172155, UnitConversion.galConversion("Peach", lb, gallon));
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
