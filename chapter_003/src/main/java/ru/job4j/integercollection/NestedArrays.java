package ru.job4j.integercollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ildar on 17.12.17.
 */
public class NestedArrays {
    /**
     * method sortFromLessToHigh sorted Integers arrays from less to high.
     * @param arrays - received List with arrays.
     * @return - list, includes sorted from less to high arrays.
     */
    public List<Integer[]> sortFromLessToHigh(List<Integer[]> arrays) {
        Comparator<Integer[]> qwe = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int result = 0;
                int i = 0;
                boolean endOfWhile = false;
                while (!endOfWhile) {
                    if (i == o1.length - 1 || i == o2.length - 1) {
                        endOfWhile = true;
                    }
                    result = o1[i].compareTo(o2[i]);
                    if (result == -1) {
                        endOfWhile = true;
                    }
                    i++;
                }
                return result;
            }
        };
        arrays.sort(qwe);
        return arrays;
    }

    /**
     * @param array - received list with arrays.
     * @return - List which includes sorted form high to less arrays.
     */
    public List<Integer[]> fromHighToLessMethod(List<Integer[]> array) {
        Comparator<Integer[]> qwe = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int result = 0;
                int i = 0;
                boolean endOfWhile = false;
                while (!endOfWhile) {
                    if (i == o1.length - 1 || i == o2.length - 1) {
                        endOfWhile = true;
                    }
                    result = o2[i].compareTo(o1[i]);
                    if (result == 1) {
                        endOfWhile = true;
                    }
                    i++;
                }
                return result;
            }
        };
        array.sort(qwe);
        return array;
    }
}
