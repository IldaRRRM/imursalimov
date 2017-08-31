package ru.job4j.professions;
/**
*The Professions class is a genitive class for classes Engineer, Doctor and Teacher.
*/
public class Professions {
	/**
	 * profession - prof.
	 */
	private String profession;
	/**
	 * name.
	 */
	private String name;
	/**
	 * age.
	 */
	private int age;
	/**
	 * education.
	 */
	private String education;
	/**
	 * workDays in the month.
	 */
	private int workDays;
	/**
	 * rate for one hour.
	 */
	private double rate;
	/**
	 * @param profession prof.
	 * @param name - name.
	 * @param age - age.
	 * @param education - education.
	 * @param workDays - workdays.
	 * @param rate - rate.
	 */
	Professions(String profession, String name, int age, String education, int workDays, double rate) {
		this.profession = profession;
		this.name = name;
		this.age = age;
		this.education = education;
		this.workDays = workDays;
		this.rate = rate;
	}

	/**
	 * @return profession.
	 */
	public String getProfession() {
		return this.profession;
	}

	/**
	 * @return name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @return Age.
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * @return education.
	 */
	public String getEducation() {
		return this.education;
	}
	/**
	 * @return workdays.
	 */
	public int getWorkDays() {
		return this.workDays;
	}
	/**
	 * @return rate.
	 */
	public double getRate() {
		return this.rate;
	}

	/**
	 * @return result of salary.
	 */
	public String salary() {
		String result = this.profession + " " + this.name +  " " + " receives per month: " + String.valueOf(this.workDays * this.rate);
		return result;
	}
}