package ru.job4j.collections;



import java.util.*;

/**
 * CollectionsTask includes methods, which used for testing three collections.
 */
public class CollectionsTask {
    /**
     * add method.
     * @param collection - received collection.
     * @param amount - numbers of elements.
     * @return - The time in ms, which elements will add with collections.
     */
    public long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(i));
        }
        return System.currentTimeMillis() - start;
    }

    /**
     * remove method.
     * @param collection - received collections.
     * @param amount - numbers of elements.
     * @return - The time in ms, which elements will add with collections.
     */
    public long delete(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.remove(String.valueOf(i));
        }
        return System.currentTimeMillis() - start;
    }

    /**
     *method with examples.
     */
    public void listsForTest() {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedlList = new LinkedList<>();
        SortedSet<String> sortedSet = new TreeSet<>();

        long arrList = add(arrayList, 100000);
        long link = add(linkedlList, 100000);
        long set = add(sortedSet, 100000);
        long removeArrList = delete(arrayList, 100000);
        long delLink = delete(linkedlList, 100000);
        long devastSet = delete(sortedSet, 100000);

        System.out.println(String.format("Add Method: " + "ArrayList %d ms Linkedlist %d ms Set %d ms",
                arrList, link, set));
        System.out.println(String.format("Remove: " + "ArrayList %d ms Linkedlist %d ms Set %d ms",
                removeArrList, delLink, devastSet));
    }

    /**
     * main.
     * @param args - args.
     */
    public static void main(String[] args) {
        CollectionsTask collectionsTask = new CollectionsTask();
        collectionsTask.listsForTest();
    }
}
