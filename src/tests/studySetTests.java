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
		StudySet studySet = new StudySet("test1");
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
		StudySet studySet = new StudySet("test1");
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		boolean ifInsert1 = studySet.insertTerm(termForTesting);
		boolean ifInsertAnother1 = studySet.insertTerm(termForTesting); // should return false
		boolean ifSizeIs1 = studySet.getSize() == 1;
		assertTrue(ifInsert1 && (!ifInsertAnother1) && ifSizeIs1);
	}

	@Test
	void testDeletingExistingTermInStudySet() {
		System.out.println("\nTest deleting existing term in StudySet:");
		StudySet studySet = new StudySet("test1");
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		boolean ifInsert = studySet.insertTerm(termForTesting);
		boolean ifDelete = studySet.deleteTerm(termForTesting);
		boolean ifSizeIs0 = studySet.getSize() == 0;
		assertTrue(ifInsert && ifDelete && ifSizeIs0);
	}

	@Test
	void testDeletingNonexistingTermInStudySet() {
		System.out.println("\nTest deleting non-existing term in StudySet:");
		StudySet studySet = new StudySet("test1");
		Term termForTesting = new Term("What is 1+1 equal to?", "2");
		boolean ifDelete = studySet.deleteTerm(termForTesting); // should return false
		boolean ifSizeIs0 = studySet.getSize() == 0;
		assertTrue((!ifDelete) && ifSizeIs0);
		
	}

	@Test
	void testGettingStudySetName() {
		System.out.println("\nTest getting the name of the study set:");
		String name = "test1";
		StudySet studySet = new StudySet(name);
		String studySetName = studySet.getName();
		boolean ifNamesEqual = name.equals(studySetName);
		assertTrue(ifNamesEqual);
	}

	@Test
	void testChangingStudySetName() {
		System.out.println("\nTest changing the name of the study set:");
		StudySet studySet = new StudySet("test1");
		assertEquals(studySet.getName(), "test1");
		studySet.changeStudySetName("new name");
		assertEquals(studySet.getName(), "new name");

	}
	
	@Test
	void testViewingAllTerms() {
		System.out.println("\nTest viewing all the terms in the study set. Please check the console for output.");  
		StudySet studySet = new StudySet("test1");
		Term term1=new Term("Do you like CSE 237?","Yes");
		Term term2=new Term("What's your favorite class?","CSE 237");
		Term term3=new Term("Piazza or Discord?","Discord");
		studySet.insertTerm(term1);
		studySet.insertTerm(term2);
		studySet.insertTerm(term3);
		
		studySet.viewAllTerms();
		
		System.out.println("Now deleting the term 'Do you like CSE 237' ");
		studySet.deleteTerm(term1);
		studySet.viewAllTerms();
		
	
	}

}
