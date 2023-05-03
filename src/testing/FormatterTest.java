package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.Formatter;

class FormatterTest extends Formatter
{

  @Test
  void test()
  {
    String test = Formatter.INGREDIENT;
    String result = "0.1 t of z r";
    assertEquals(result, String.format(test, 0.1, "t", "z", "r"));
    
  }

}
