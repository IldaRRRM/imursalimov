package ru.job4j.professions;
/**
 * class Pacient who heals by Doctor.
 */
class Pacient {
    /**
     *Construсtor and field.
     */
    private String name;
    /**
     * @param name - getter for name.
     */
    Pacient(String name) {
        this.name = name;
    }
    /**
     * @return name.
     */
    public String getName() {
        return this.name;
    }
}
/**
*The class Doctor inherits data from the class of the professions and describes the behavior of the "Doctor".
*/
public class Doctor extends Professions {
    /**
     * @param profession - prof.
     * @param name - name.
     * @param age - age.
     * @param education - educ.
     * @param workDays - wrkd.
     * @param rate - rate.
     * @param heal - heal.
     */
	Doctor(String profession, String name, int age, String education, int workDays, double rate, String heal) {
		super(profession, name, age, education, workDays, rate);
	}
    /**
     * @return result of method heal.
     * @param pacient received param.
     */
    public String heal(Pacient pacient) {
        String result = (super.getProfession() + " " + super.getName() + " " + "heals" + " " + pacient.getName());
        return result;
    }
}