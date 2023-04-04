import java.io.Serializable;

public class Utensils implements Serializable {
	
	private String name;
	private String details;
	
	
	public Utensils(String name, String details) {
		this.name = name;
		this.details = details;
	}
	
	
	
	public String getName() {
		return this.name;
	}
	
	public String getDetails() {
		return this.details;
	}

}
