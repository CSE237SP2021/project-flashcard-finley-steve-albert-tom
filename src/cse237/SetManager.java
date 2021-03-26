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
			this.studySetCollection.remove(index);
			System.out.println("Study set successfully removed.");
			return true;
		}
		
	}
	
	public void viewAllStudySet() {
		if(this.getNumberOfStudyset()==0) {
			System.out.println("You don't have any study set yet.");
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
			
		}
		
	}
	
	
	
	public int getNumberOfStudyset() {
		return this.studySetCollection.size();
	}
	
	
	
	
}
