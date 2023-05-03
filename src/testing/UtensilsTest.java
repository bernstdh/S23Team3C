package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.Utensils;

class UtensilsTest
{

  @Test
  void utensilsTest()
  {
    Utensils newtensil;
    newtensil = new Utensils("spoon", "big spoon");

    assertEquals("spoon", newtensil.getName());
    assertEquals("big spoon", newtensil.getDetails());
  }
  
  @Test
  void utensilsToStringTest() 
  {
    Utensils newtensil;
    newtensil = new Utensils("spoon", "");
    assertEquals("spoon", newtensil.toString());
    
    newtensil = new Utensils("spoon", "big spoon");
    assertEquals("big spoon spoon", newtensil.toString());
  }

}
