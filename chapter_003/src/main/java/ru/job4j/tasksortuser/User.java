package ru.job4j.tasksortuser;

/**
 * Class User.
 */
class User implements Comparable<User> {
    /**
     * name.
     */
    private String name;
    /**
     * age.
     */
    private int age;
    /**
     * Constructor.
     * @param name - name.
     * @param age - age.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * Ovverride compareTo.
     * @param o - received user.
     * @return - return compare.
     */
    @Override
    public int compareTo(User o) {
        Integer integerAge = this.age;
        return integerAge.compareTo(o.age);
    }
    /**
     * Override toString.
     * @return - String, what we need.
     */
    @Override
    public String toString() {
        return "User: " + name + " Age " + age + System.lineSeparator();
    }
}
