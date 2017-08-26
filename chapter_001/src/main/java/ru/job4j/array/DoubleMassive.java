package ru.job4j.array;

/**
 * Created by ildar on 26.08.17.
 * Public class DoubleMassive includes method "association" which using for association of two ordered arrays.
 */
public class DoubleMassive {
    /**
     * method "association" associations two ordered arrays.
     *
     * @param first  - first ordered array.
     * @param second - second ordered array.
     * @return - return association array.
     */
    public int[] association(int[] first, int[] second) {
        int leftIndex = 0;
        int rightIndex = 0;
        int[] summ = new int[first.length + second.length];
        int i = 0;
        while (i < summ.length) {
            if (first[leftIndex] < second[rightIndex]) {
                summ[i] = first[leftIndex++];
            } else {
                summ[i] = second[rightIndex++];
            }
            if (leftIndex == first.length) {
                System.arraycopy(second, rightIndex, summ, ++i, second.length - rightIndex);
                break;
            }
            if (rightIndex == second.length) {
                System.arraycopy(first, leftIndex, summ, ++i, first.length - leftIndex);
                break;
            }
            i++;
        }
        return summ;
    }
}