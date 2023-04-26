package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.Utensils;

class UtensilsTest
{

  @Test
  void ingredientTest()
  {
    Utensils newtensil;
    newtensil = new Utensils("spoon", "big spoon");

    assertEquals("spoon", newtensil.getName());
    assertEquals("big spoon", newtensil.getDetails());

  }

}
