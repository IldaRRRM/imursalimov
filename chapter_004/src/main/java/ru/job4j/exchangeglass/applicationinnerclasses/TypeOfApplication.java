package ru.job4j.exchangeglass.applicationinnerclasses;

/**
 *
 */
public class TypeOfApplication {

    private boolean add;

    private boolean delete;

    public TypeOfApplication(String addOrDelete) {
        if (addOrDelete.toLowerCase().equals("add")) {
            add = true;
        } else if (addOrDelete.toLowerCase().equals("delete")) {
            delete = true;
        }
    }

    public boolean isAdd() {
        return add;
    }

    public boolean isDelete() {
        return delete;
    }
}
