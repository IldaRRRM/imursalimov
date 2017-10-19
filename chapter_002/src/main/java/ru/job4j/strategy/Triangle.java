package ru.job4j.strategy;
/**
 * class Triangle is painting Triangle.
 */
public class Triangle implements Shape {
    /**
     * method pic creates a Triangle.
     * @return our figure.
     */

    public String pic() {
        StringBuilder red = new StringBuilder();
        red.append("*" + "\n");
        red.append("* *" + "\n");
        red.append("*   *" + "\n");
        red.append("*     *" + "\n");
        red.append("*       *" + "\n");
        red.append("*         *" + "\n");
        red.append("* * * * * * *" + "\n");
        return red.toString();
    }
}