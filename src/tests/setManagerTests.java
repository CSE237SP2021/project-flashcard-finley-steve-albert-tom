package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.SetManager;
import cse237.StudySet;
import cse237.Term;

class setManagerTests {

	@Test
	void testNormalInsertionandDeletion() {
		
		System.out.println("\nTesting inserting and deleting study sets from the set manager: ");
		SetManager setManager1=new SetManager();
		StudySet studySet1 = new StudySet("test1");
		setManager1.insertStudySet(studySet1);
		assertEquals(setManager1.getNumberOfStudyset(),1);
		
		StudySet studySet2=new StudySet("test2");
		setManager1.insertStudySet(studySet2);
		assertEquals(setManager1.getNumberOfStudyset(),2);
		
		setManager1.deleteStudySet(0);
		assertEquals(setManager1.getNumberOfStudyset(),1);
		
		setManager1.deleteStudySet(0);
		assertEquals(setManager1.getNumberOfStudyset(),0);
		
	}
	
	@Test
	void testDeletingNonExistingItem() {
		System.out.println("\nTesting deleting an non-existing item from the set manager: "); 
		SetManager setManager1=new SetManager();
		StudySet studySet1 = new StudySet("test1");
		setManager1.insertStudySet(studySet1);
		boolean deletionResult1=setManager1.deleteStudySet(1);
		assertTrue(!deletionResult1);
		
		StudySet studySet2=new StudySet("test2");
		setManager1.insertStudySet(studySet2);
		boolean deletionResult2=setManager1.deleteStudySet(4);
		assertTrue(!deletionResult2);		
	}
	
	@Test
	void testInsertingTermToStudySet() {
		System.out.println("\nTesting inserting term to study sets: ");
		SetManager setManager1=new SetManager();
		StudySet studySet1 = new StudySet("test1");
		Term term1=new Term("What's 1+1?", "2");
		Term term2= new Term("What's 1+1?", "2");
		studySet1.insertTerm(term1);
		studySet1.insertTerm(term2);
		setManager1.insertStudySet(studySet1);
		System.out.println("\nDisplaying the terms before the insertion: ");
		setManager1.openStudySet(0);
		setManager1.insertTermToStudySet(0, new Term("new term","new term"));
		System.out.println("\n Displaying the terms after the insertion: ");
		setManager1.openStudySet(0);
	}
	
	@Test 
	void testEditingTermAndDefinition() {
		System.out.println("\nTesting editing terms and definitions of study sets: ");
		SetManager setManager1=new SetManager();
		StudySet studySet1 = new StudySet("test1");
		Term term1=new Term("What's 1+1?", "2");
		Term term2= new Term("What's 1+3?", "4");
		studySet1.insertTerm(term1);
		studySet1.insertTerm(term2);
		setManager1.insertStudySet(studySet1);
		System.out.println("\nDisplaying the terms before the edit: ");
		setManager1.openStudySet(0);
		
		setManager1.editTermInStudySet(0, 0, "New term", 0);
		setManager1.editTermInStudySet(0, 1, "New definition", 1);
		System.out.println("\n Displaying the terms after the edit: ");
		setManager1.openStudySet(0);
	}
	
	@Test
	void testOpenExistingSet() {
		
		System.out.println("\nTesting opening existing study set from the set manager: ");
		SetManager setManager1=new SetManager();
		StudySet studySet1 = new StudySet("test1");
		setManager1.insertStudySet(studySet1);
		setManager1.openStudySet(0);
	
		assertTrue(setManager1.openStudySet(0));
	}

	@Test
	void testOpenNonExistingSet() {
		
		System.out.println("\nTesting opening non-existing study set from the set manager: ");
		SetManager setManager1=new SetManager();
		assertTrue(!setManager1.openStudySet(0));
	}
	
	

}
