package ru.job4j.professions;
import org.junit.Test;
/**
 * Created by ildar on 05.09.17.
 */

public class ProfessionsTest {
    /**
     * Test add.
     */
    @Test
    public void professionsTest() {
        /**
         * Classes Enginner, Doctor and Teacher.
         */
        Engineer engineer = new Engineer("Adjuster", "Alexandr", 24, "higher education", 23, 2500);
        Doctor doctor = new Doctor("Therapist", "Darya", 32, "higher education", 23, 1500, "heals");
        Teacher teacher = new Teacher("Professor", "Victor Petrovich", 54, "higher education", 15, 3555.5);
        /**
         * Arguments for methods.
         */
        Product product = new Product("TV");
        Pacient pacient = new Pacient("Victor");

        /**
         * methods.
         */
        System.out.println(doctor.heal(pacient));
        System.out.println(teacher.teach(engineer));
        System.out.println(engineer.fix(product));
        System.out.println(doctor.salary());
        System.out.println(teacher.salary());
        System.out.println(engineer.salary());
    }
}
