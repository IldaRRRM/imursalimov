package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Public class TurnTest used for testing method back from class Turn.
*/
public class TurnTest {
	/**
	*Method whenTurnArrayWithEvenAmountOfElementsThenTurnedArray used for testing method back with array {2,6,1,4}.
	*/
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
    	Turn ar = new Turn();
    	int[] testAr = {2, 6, 1, 4};
    	int[] expectArray = {4, 1, 6, 2};
    	int[] resultArray = ar.back(testAr);
    	assertThat(resultArray, is(expectArray));
    }
    /**
	*Method whenTurnArrayWithOddAmountOfElementsThenTurnedArray used for testing method back with array {1,2,3,4,5}.
	*/
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn ar1 = new Turn();
    	int[] testAr = {1, 2, 3, 4, 5};
    	int[] expectArray = {5, 4, 3, 2, 1};
    	int[] resultArray = ar1.back(testAr);
    	assertThat(resultArray, is(expectArray));
    }
}

