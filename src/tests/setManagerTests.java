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
	
	

}
