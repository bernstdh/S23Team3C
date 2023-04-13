package utensil;
import java.io.Serializable;

public class Utensils implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String details;
	
	
	/**
	 * constructor.
	 * @param name for utensil name.
	 * @param details for description.
	 */
	public Utensils(String name, String details) {
		this.name = name;
		this.details = details;
	}
	
	
	
	/**
	 * gets name.
	 * @return name.
	 */
	public String getName() {
		return this.name;
	}
	
	/** gets details.
	 * @return details.
	 */
	public String getDetails() {
		return this.details;
	}
	
	
	/**
	 * toString method.
	 *@return String.
	 */
	public String toString() {
		  String newString;
		  newString = String.format("%s %s", this.details, this.name);
		  return newString;
	}

}
