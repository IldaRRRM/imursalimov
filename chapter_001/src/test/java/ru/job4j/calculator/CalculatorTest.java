
package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class CalculatorTest is for test class Calculator.
*/

public class CalculatorTest {
    /**
    *method whenAddOnePlusOneThenTwo shows that the summ of 2 arg is correct.
    */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
     /**
    *method whenAddOneSubtractThenTwo shows that the subtract of 2 arg is correct.
    */
     @Test
 	public void whenAddOneSubtractThenTwo() {
        Calculator calc1 = new Calculator();
        calc1.subtract(1D, 1D);
        double result = calc1.getResult();
        double expected = 1D - 1D;
        assertThat(result, is(expected));
    }
     /**
    *method whenAddOneDivThenTwo shows that the div of 2 arg is correct.
    */
     @Test
 	public void whenAddOneDivThenTwo() {
        Calculator calc2 = new Calculator();
        calc2.div(1D, 1D);
        double result = calc2.getResult();
        double expected = 1D / 1D;
        assertThat(result, is(expected));
    }
    /**
    *method whenAddOneMultiplyThenTwo shows that the multiply of 2 arg is correct.
    */
    @Test
    public void whenAddOneMultiplyThenTwo() {
        Calculator calc3 = new Calculator();
        calc3.multiply(1D, 1D);
        double result = calc3.getResult();
        double expected = 1D * 1D;
        assertThat(result, is(expected));
    }
}

