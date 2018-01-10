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
     * getter.
     * @return - name.
     */
    public String getName() {
        return name;
    }

    /**
     * getter.
     * @return - age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Override compareTo.
     * @param o - received user.
     * @return - return compare.
     */
    @Override
    public int compareTo(User o) {
        return this.age > o.age ? 1 : -1;
    }
    /**
     * Override toString.
     * @return - String, what we need.
     */

    @Override
    public String toString() {
        return "User: " + name + " Age " + age + System.lineSeparator();
    }

    /**
     *
     * @param o - received obj.
     * @return - equals result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (age != user.age) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }
    /**
     * hashcode.
     * @return - override hashcode.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
