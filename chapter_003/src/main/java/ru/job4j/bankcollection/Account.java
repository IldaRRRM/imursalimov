package ru.job4j.bankcollection;

public class Account {
    /**
     * value of money.
     */
    private double value;
    /**
     * requisites of user.
     */
    private int requisites;

    /**
     *
     * @param value - value of money.
     * @param requisites - requisites of user.
     */
    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     * @return
     */
    public int getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites;
        return result;
    }
}
