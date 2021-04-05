package cse237;

import java.util.ArrayList;

public class SetManager {

	private ArrayList<StudySet> studySetCollection; 
	
	
	public SetManager () {
		this.studySetCollection=new ArrayList<StudySet>();
		
	}
	
	public void insertStudySet(StudySet setForInsertion) {
		System.out.println("Saving study set...");
		this.studySetCollection.add(setForInsertion);
		System.out.println("Study set successuflly saved.");
		
	}
	
	public boolean deleteStudySet(int index) {
		if(index >=this.getNumberOfStudyset()) {
			System.out.println("Please enter a valid index!");
			return false;
		}
		else {
			System.out.println("Deleting study set...");
			this.studySetCollection.remove(index);
			System.out.println("Study set successfully removed.");
			return true;
		}
		
	}
	
	public int viewAllStudySet() {
		if(this.getNumberOfStudyset()==0) {
			System.out.println("You don't have any study set yet.");
			return 0;
		}
		else {
			int currentIndex=1;
			System.out.println("These are the study sets that you've created: ");
			System.out.println();
			for (StudySet set:this.studySetCollection) {
				String currentSetName=set.getName();
				String lineToDisplay=String.valueOf(currentIndex)+". "+currentSetName; 
				System.out.println(lineToDisplay);
				currentIndex++;
			}
			
			return 1;
			
		}
		
	}
	
	public void openStudySet(int index) {
		int counter=1;
		for (StudySet set: this.studySetCollection) {
			if(counter==index) {
				set.viewAllTerms();
			}
		}
	}
	
	public void insertTermToStudySet(int index, Term termToInsert) {
		int counter=1;
		for (StudySet set: this.studySetCollection) {
			if(counter==index) {
				set.insertTerm(termToInsert);
			}
		}
		
		
	}
	
	
	
	public int getNumberOfStudyset() {
		return this.studySetCollection.size();
	}
	
	
	
	
}
