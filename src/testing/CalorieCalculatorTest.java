package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculators.CalorieCalculator;

/**
 * CalorieCalculatorTest.
 * @author Trace Jones, James Madison University
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 *
 */
class CalorieCalculatorTest
{

  @Test
  void calculateCaloriesTest()
  {
    String ingredient = "Alcohol";
    double amount = 100;
    String unit = "g";
    assertEquals(275.0, CalorieCalculator.calculateCalories(ingredient, amount, unit));
    
    amount = -1.0;
    assertEquals(0.0, CalorieCalculator.calculateCalories(ingredient, amount, unit));
    
    ingredient = "Almond";
    amount = 452.38;
    unit = "dr";
    assertEquals(4817.29, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Apple";
    amount = 32.9;
    unit = "oz";
    assertEquals(410.39, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Banana";
    amount = 203.908;
    unit = "lb";
    assertEquals(60119.22, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Crab";
    amount = 16743.29;
    unit = "p";
    assertEquals(3460.95, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Ham";
    amount = 8946.091;
    unit = "tsp";
    assertEquals(148157.79, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Chicken";
    amount = 99.8;
    unit = "tbs";
    assertEquals(3069.5, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Wine";
    amount = 473.39;
    unit = "floz";
    assertEquals(11503.65, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Spinach";
    amount = 9063.52;
    unit = "cup";
    assertEquals(13723.66, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Sweet potato";
    amount = 157.093;
    unit = "pt";
    assertEquals(41551.99, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Peas";
    amount = 37.29;
    unit = "qt";
    assertEquals(38126.78, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Milk";
    amount = 83.8772;
    unit = "gal";
    assertEquals(231147.09, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Egg";
    amount = 79275.30958;
    unit = "ml";
    assertEquals(71347.78, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
    ingredient = "Thyme";
    amount = 79275.30958;
    unit = "Trace";
    assertEquals(0.0, CalorieCalculator.calculateCalories(ingredient, amount, unit), 0.01);
    
  }

}
