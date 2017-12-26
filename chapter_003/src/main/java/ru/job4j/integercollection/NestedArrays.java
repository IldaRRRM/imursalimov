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
     * method
     * @param arrays - received List with arrays.
     * @return - list, includes sorted from less to high arrays.
     */
    public List<Integer[]> sortFromLessToHigh(List<Integer[]> arrays) {
        for (Integer[] arr : arrays) {
            Arrays.sort(arr);
        }
        return arrays;
    }
    /**
     * @param array - received list with arrays.
     * @return - List which includes sorted form high to less arrays.
     */
    public List<Integer[]> fromHighToLessMethod(List<Integer[]> array) {
        for (Integer[] arr : array) {
            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return integer.compareTo(t1) == 1 ? -1 : 1;
                }
            });
        }
        return array;
    }
}
