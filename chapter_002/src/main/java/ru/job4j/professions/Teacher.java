package ru.job4j.professions;

/**
*public class Teacher describes the attributes of teacher.
*/
public class Teacher extends Professions {
    /**
     * class field.
     */
    private boolean strongNerves;
    /**
     *
     * @param profession - prof.
     * @param name - name.
     * @param age - age.
     * @param education - educ.
     * @param workDays - workDays in month.
     * @param rate - rate for one hour.
     */
    Teacher(String profession, String name, int age, String education, int workDays, double rate) {
        super(profession, name, age, education, workDays, rate);
    }

    /**
     *
     * @param engineer - man who heals teaches by Teacher.
     * @return - result of method teach.
     */
    public String teach(Engineer engineer) {
        String result = (super.getProfession() + " " + super.getName() + " " + "teaches" + " " + engineer.getName());
        return result;
    }
}