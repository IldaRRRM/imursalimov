package ru.job4j.strategy;
/**
*class Square is paintiong Square.
*/
public class Square implements Shape {
    /**
     * method pic creates a square.
     * @return our figure;
     */
    public String pic() {
        StringBuilder red = new StringBuilder();
        red.append("*****" + "\n");
        red.append("*   *" + "\n");
        red.append("*   *" + "\n");
        red.append("*****" + "\n");
        return red.toString();
    }
}