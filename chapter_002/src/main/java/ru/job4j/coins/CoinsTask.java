package ru.job4j.coins;

/**
 * class coinsTask includes method changes, which used for calculating change.
 */
public class CoinsTask {
    /**
     * @param value - received money.
     * @param price - price of item.
     * @return - array, which includes short change.
     */
    public int[] changes(int value, int price) {
        int money = value - price;
        int kolTen = money / 10;
        int kolFive = (money % 10) / 5;
        int kolTwo = (money % 10 % 5) / 2;
        int kolOne = 0;
        if ((money % 10 % 5) % 2 != 0) {
            kolOne = 1;
        }

        int[] result = new int[kolTen + kolFive + kolTwo + kolOne];

        for (int i = 0; i < result.length; i++) {
            if (i < kolTen) {
                result[i] = 10;
            } else if (i >= kolTen && i < kolTen + kolFive) {
                result[i] = 5;
            } else if (i >= kolTen + kolFive && i < kolFive + kolTen + kolTwo) {
                result[i] = 2;
            } else if (i >= kolTen + kolFive + kolTwo && kolOne > 0) {
                result[i] = 1;
            }
        }
        return result;
    }
}

