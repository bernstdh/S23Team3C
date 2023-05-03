package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.IngredientTable;

class IngredientTableTest
{

  @Test
  void fromCodeTest()
  {
    IngredientTable ing = IngredientTable.createInstance();
    assertEquals(null, ing.fromCode("Trace"));
  }

}
