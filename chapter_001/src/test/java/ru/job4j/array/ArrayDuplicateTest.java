package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Public class ArrayDuplicateTest includes method "whenRemoveDuplicatesThenArrayWithoutDuplicate", which used for testing method "remove" from class ArrayDuplicate.
*/
 public class ArrayDuplicateTest {
 	/**
 	*method "whenRemoveDuplicatesThenArrayWithoutDuplicate" used for testing method remove from class ArrayDuplicate.
 	*/
 	@Test
 	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
 	ArrayDuplicate tst = new ArrayDuplicate();
 	String[] testArr = {"Hello", "Hello", "World", "Super", "World"};
 	String[] resultArr = tst.remove(testArr);
 	String[] expectArr = {"Hello", "World", "Super"};
 	assertThat(resultArr, is(expectArr));
 	} // end of method.
 } // end of class.
