package items;

import java.io.Serializable;

/**
 * utensils class.
 * @author Julian Barrett
 *
 */
public class Utensils implements Serializable
{

  private static final long serialVersionUID = 1L;
  private String name;
  private String details;

  /**
   * constructor.
   * 
   * @param name
   *          for utensil name.
   * @param details
   *          for description.
   */
  public Utensils(final String name, final String details)
  {
    this.name = name;
    this.details = details;
  }

  /**
   * gets name.
   * 
   * @return name.
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * gets details.
   * 
   * @return details.
   */
  public String getDetails()
  {
    return this.details;
  }

  /**
   * toString method.
   * 
   * @return String.
   */
  public String toString()
  {
    String newString;
    if(details.equals("")) newString = String.format("%s",this.name);
    else                   newString = String.format("%s %s", this.details, this.name);
    return newString;
  }

}
