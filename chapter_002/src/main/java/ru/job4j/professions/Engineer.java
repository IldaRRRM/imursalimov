package ru.job4j.professions;
/**
 * class product.
 */
class Product {
	/**
	 * field.
	 */
	private String name;
	/**
	 * @param name - name.
	 */
	Product(String name) {
		this.name = name;
	}
	/**
	 *
	 * @return name.
	 */
	public String getName() {
		return this.name;
	}
}
	/**
	*The class engineer inherits data from the class of the professions and describes the behavior of the "Engineer".
	*/
	public class Engineer extends Professions {
	/**
	 *
	 * @param profession -prof.
	 * @param name -name.
	 * @param age - age.
	 * @param education - educ.
	 * @param workDays -workDays in month.
	 * @param rate - rate for hour.
	 */
	Engineer(String profession, String name, int age, String education, int workDays, double rate) {
		super(profession, name, age, education, workDays, rate);
	}

	/**
	 *
	 * @param product - product which engineer is fixing.
	 * @return - result of method fix.
	 */
	public String fix(Product product) {
		String result = (super.getProfession() + " " + super.getName() + " " + "mends" + " " + product.getName());
		return result;
	}
}