package ru.job4j.convert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ConvertList {
    /**
     * @param array - received array.
     * @return - List with elements.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> integerList = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                integerList.add(j);
            }
        }
        return integerList;
    }

    /**
     * @param array - received array.
     * @param rows  - rows.
     * @return - new multiArray.
     */
    public int[][] toArray(List<Integer> array, int rows) {
        int columns = 0;
        if (array.size() % rows != 0) {
            int count = array.size();
            boolean m = false;
            while (!m) {
                count++;
                if (count % rows == 0) {
                    m = true;
                }
            }
            columns = count / rows;
        } else {
            columns = array.size() / rows;
        }
        //array, which will be returned.
        int[][] returnArr = new int[rows][columns];
        int columnCount = 0;
        int arrIndex = 0;
        for (int[] i : returnArr) {
            for (int j : i) {
                if (arrIndex == array.size()) {
                    break;
                }
                i[columnCount++] = array.get(arrIndex++);
                if (columnCount == columns) {
                    columnCount = 0;
                    break;
                }
            }
        }
        return returnArr;
    }

    /**
     * received List, which includes int arrays.
     * @param list - received list with int arrays.
     * @return - IntegerList.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> resultList = new ArrayList<>();
        for (int[] i : list) {
            for (int j : i) {
                resultList.add(j);
            }
        }
        return resultList;
    }
}
