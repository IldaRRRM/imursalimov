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

    /**
     * Override equals.
     * @param obj - received object (User).
     * @return - boolean value.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;
        return name != null ? name.equals(user.name) && age == user.age : user.name == null;
    }
}
