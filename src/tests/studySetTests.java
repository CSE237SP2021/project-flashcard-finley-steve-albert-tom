package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import cse237.StudySet;
import cse237.Term;

class studySetTests {

	@Test
	void testInsertingDifferentTermsIntoStudySet() {
		System.out.println("Test inserting different terms into StudySet:");
		StudySet studySet = new StudySet();
		Term termForTesting1 = new Term("What is 1+1 equal to?", "2");
		Term termForTesting2 = new Term("What is your favorite class?", "CSE 237");
		boolean ifInsert1 = studySet.insertTerm(termForTesting1);
		boolean ifInsert2 = studySet.insertTerm(termForTesting2);
		boolean ifSizeIs2 = studySet.getSize() == 2;
		assertTrue(ifInsert1 && ifInsert2 && ifSizeIs2);
	}
	
	@Test
	void testInsertingSameTermIntoStudySet() {
		System.out.println("\nTest inserting same term into StudySet:");
		StudySet studySet = new StudySet();
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		boolean ifInsert1 = studySet.insertTerm(termForTesting);
		boolean ifInsertAnother1 = studySet.insertTerm(termForTesting); // should return false
		boolean ifSizeIs1 = studySet.getSize() == 1;
		assertTrue(ifInsert1 && (!ifInsertAnother1) && ifSizeIs1);
	}
	
	@Test
	void testDeletingExistingTermInStudySet() {
		System.out.println("\nTest deleting existing term in StudySet:");
		StudySet studySet = new StudySet();
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		boolean ifInsert = studySet.insertTerm(termForTesting);
		boolean ifDelete = studySet.deleteTerm(termForTesting);
		boolean ifSizeIs0 = studySet.getSize() == 0;
		assertTrue(ifInsert && ifDelete && ifSizeIs0);
	}
	
	@Test
	void testDeletingNonexistingTermInStudySet() {
		System.out.println("\nTest deleting non-existing term in StudySet:");
		StudySet studySet = new StudySet();
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		boolean ifDelete = studySet.deleteTerm(termForTesting); // should return false
		boolean ifSizeIs0 = studySet.getSize() == 0;
		assertTrue((!ifDelete) && ifSizeIs0);
	}
	

}
