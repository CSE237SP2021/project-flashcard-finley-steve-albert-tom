package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.Term;

class termTests {

	@Test
	void testCorrectness() {
		System.out.println("\nTesting correct answer");
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		assertTrue(termForTesting.checkAnswer("2")); // check correct answer
	}

	@Test
	void testIncorrectness() {
		System.out.println("\nTesting incorrect answer");
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		assertFalse(termForTesting.checkAnswer("3")); // check incorrect answer
	}

	@Test
	void testRetrievingTermName() {
		System.out.println("\nTesting retrieving the term");
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		assertEquals(termForTesting.getTerm(), "What is 1+1 equal to?");

	}
	
	@Test
	void testRetrievingDefinition() {
		System.out.println("\nTesting retrieving the definition");
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		assertEquals(termForTesting.getDefinition(),"2");
	}
}
