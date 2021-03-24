package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.Term;

class termTests {

	@Test
	void testCorrectness() {
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		assertTrue(termForTesting.checkAnswer("2")); // check correct answer
	}

	@Test
	void testIncorrectness() {
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		assertFalse(termForTesting.checkAnswer("3")); // check incorrect answer
	}
}
