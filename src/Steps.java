import java.io.Serializable;

public class Steps implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String action;
	private Ingredient ingredientSource;
	private Utensils utensilSource = null;
	private Utensils destination = null;
	
	
	public Steps(String action, Utensils source, Utensils destination) {
		this.action = action;
		this.utensilSource = source;
		this.destination = destination;
	}
	
	
	
	public Steps(String action, Ingredient source, Utensils destination) {
		this.action = action;
		this.ingredientSource = source;
		this.destination = destination;
	}
	
	
//	public String toString() {
//		String stepsString;
//		if (this.utensilSource != null) {
//			return String.format(", null)
//		}
//		return String.format(action, null)
//	}

}
