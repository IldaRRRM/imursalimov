package ru.job4j.nonblockingalgoritm;

public class Base {
    private final int id;
    private final int version;

    public Base(int id, int version) {
        this.id = id;
        this.version = version;
    }


    public int getId() {
        return this.id;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return String.format("Id is = %s, version is = %s", getId(), getVersion());
    }
}
