package ru.job4j.handbksort;

import java.util.*;

/**
 *Class HandBook includes methods, which inputs arrays and outputs sorted Set and List.
 */
public class HandBook {
    /**
     * @param word - word form received String array.
     * @return - Set with index of unic elements from our array.
     */
    public Set<Integer> findIndexOfChar(String word) {
        Set<Integer> result = new TreeSet<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\\') {
                result.add(i);
            }
            result.add(chars.length);
        }
        return result;
    }
    /**
     * @param handbk - received String array.
     * @return - sorted Set from less to high.
     */
    public Set<String> sortFromLessToHigh(String[] handbk) {
        Set<String> result = new TreeSet<>();
        for (String str : handbk) {
            for (int i : findIndexOfChar(str)) {
                result.add(str.substring(0, i));
            }
        }
        return result;
    }

    /**
     * @param strings - received String array.
     * @return - List with elements, which sorted from high to less.
     */
    public Set<String> arraySortFromHighToLess(String[] strings) {
        Set<String> result = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1) == 1 ? -1 : 1;
            }
        });
        result.addAll(sortFromLessToHigh(strings));
       return result;
    }
}
