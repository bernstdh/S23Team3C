
public class Ingredient {

	private String name;
	private String details;
	private double amount;
	private String unit;
	private double caloriesPerg;

	/**
	 * @param name for name of ingredient.
	 * @param details for ingredient description.
	 * @param amount for ingredient amount.
	 * @param unit amount in units.
	 * @param caloriesPerg for calories per gram.
	 */
	public Ingredient(String name, String details, double amount, String unit, double caloriesPerg) {
		this.name = name;
		this.details = details;
		this.amount = amount;
		this.unit = unit;
		this.caloriesPerg = caloriesPerg;
	}

	/**
	 * returns name.
	 * @return this.name;
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * returns details.
	 * @return details.
	 */
	public String getDetails() {
		return this.details;
	}

	/**
	 * returns amount.
	 * @return amount.
	 */
	public double getAmount() {
		return this.amount;
	}

	/**
	 * method returns unit.
	 * @return unit.
	 */
	public String getUnit() {
		return this.unit;
	}

}
