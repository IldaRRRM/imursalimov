package ru.job4j.set.hashset;


/**
 * @param <E> - generic.
 */
class DataItem<E> {
    private E model;

    /**
     * Constructor.
     * @param model - received model.
     */
    DataItem(E model) {
        this.model = model;
    }

    /**
     * getModel.
     * @return - model.
     */
    public E getModel() {
        return model;
    }
}

/**
 * Simple Set on HashTable.
 * @param <E> - generic.
 */
public class SetOnHashTable<E> {

    private int arrSize;

    private DataItem[] hashArray;

    private int valueOfFreeCell;

    /**
     * Constructor.
     * @param size - size.
     */
    public SetOnHashTable(int size) {
        arrSize = size;
        hashArray = new DataItem[arrSize];
        valueOfFreeCell = arrSize;
    }

    /**
     * @param key - key.
     * @return - hashFunc for current array.
     */
    public int hashFunc(int key) {
        return Math.abs(key % arrSize);
    }

    /**
     * Element add for add element to hashtable.
     * @param element - element, which will be added.
     * @return - boolean result.
     */
    public boolean add(DataItem<E> element) {
        if (!contains(element)) {
            E key = element.getModel();
            int hashValue = hashFunc(key.hashCode());
            hashArray[hashValue] = element;
            valueOfFreeCell--;
            checkFreeCells();
            return true;
        }
        return false;
    }

    /**
     * method remove is used for removing element from hashtable.
     * @param element - element, which will be removed.
     * @return - boolean result.
     */
    public boolean remove(DataItem<E> element) {
        if (contains(element)) {
            E key = element.getModel();
            int hashValue = hashFunc(key.hashCode());
            hashArray[hashValue] = null;
            valueOfFreeCell++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method contains used for checking an element in hashSet.
     * @param element - received element.
     * @return - boolean result.
     */
    public boolean contains(DataItem<E> element) {
        E key = element.getModel();
        int hashValue = hashFunc(key.hashCode());
        return hashArray[hashValue] != null
                && hashArray[hashValue].getModel() == element.getModel();
    }

    /**
     * GetterForTest.
     * @return - arrSize.
     */
    public void checkFreeCells() {
        if (this.valueOfFreeCell == 0) {
            SetOnHashTable<E> set = new SetOnHashTable<>(arrSize * 2);
            for (DataItem dataItem : hashArray) {
                if (dataItem != null) {
                    set.add(dataItem);
                }
            }
            this.hashArray = set.hashArray;
            this.valueOfFreeCell = set.valueOfFreeCell;
            this.arrSize = set.arrSize;
        }
    }

    /**
     * Getter.
     * @return - arrSize.
     */
    public int getArrSize() {
        return arrSize;
    }
}
