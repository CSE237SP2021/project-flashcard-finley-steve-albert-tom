package cse237;

import java.util.ArrayList;
import java.util.HashMap;

public class SetManager {

	private ArrayList<StudySet> studySetCollection;

	public SetManager() {
		this.studySetCollection = new ArrayList<StudySet>();

	}

	public void insertStudySet(StudySet setForInsertion) {
		System.out.println("Saving study set...");
		boolean setExist=false;
		for (StudySet s : this.studySetCollection) {
			if(setForInsertion.getName().equals(s.getName())){
				setExist=true;
			}					
		}
		if (checkIfSetExists(setForInsertion)) {
			System.out.println("Error in insertion. Set already exists.");
		}
		else if(setExist) {
			System.out.println("Error in insertion. Study set already exists.");
		}
		else {
			this.studySetCollection.add(setForInsertion);
			System.out.println("Study set successuflly saved.");
		}
	}

	public boolean deleteStudySet(int index) {
		if (index >= this.getNumberOfStudyset()) {
			System.out.println("Please enter a valid index!");
			return false;
		} else {
			System.out.println("Deleting study set...");
			this.studySetCollection.remove(index);
			System.out.println("Study set successfully removed.");
			return true;
		}

	}

	public int viewAllStudySet() {
		if (this.getNumberOfStudyset() == 0) {
			System.out.println("You don't have any study set yet.");
			return 0;
		} else {
			int currentIndex = 1;
			System.out.println("These are the study sets that you've created: ");
			System.out.println();
			for (StudySet set : this.studySetCollection) {
				String currentSetName = set.getName();
				String lineToDisplay = String.valueOf(currentIndex) + ". " + currentSetName;
				System.out.println(lineToDisplay);
				currentIndex++;
			}

			return 1;

		}

	}

	public void openStudySet(int index) {

		if (index >= this.studySetCollection.size()) {
			System.out.println("Failed to open study set. Please enter a valid index.");
		} else {

			int counter = 0;
			for (StudySet set : this.studySetCollection) {
				if (counter == index) {
					set.viewAllTerms();
				}
				counter++;
			}
		}

	}

	

	public void insertTermToStudySet(int index, Term termToInsert) {

		if (index >= this.studySetCollection.size()) {
			System.out.println("Failed to insert term to study set. Please enter a valid index.");
		}
		else {

			int counter = 0;
			for (StudySet set : this.studySetCollection) {
				if (counter == index) {
					set.insertTerm(termToInsert);
				}
				counter++;
			}

		}

	}
	
	// 0=term, 1=definition 
	public int editTermInStudySet(int setIndex,int termIndex, String termOrDefinition, int option) {
		if(setIndex >= this.studySetCollection.size()) {
			System.out.println("Failed to edit study set. Please enter a valid index.");
			return 0; 
		}
		else {
			
			int counter = 0;
			for (StudySet set : this.studySetCollection) {
				if (counter == setIndex && option==0) { //change term
					set.changeTerm(termIndex, termOrDefinition);
				}
				else if(counter==setIndex && option==1) {//change definition 
					set.changeTermDefinition(termIndex, termOrDefinition);
				}
				
				counter++;
			}
		}
		return 1;
	}
	
	public HashMap<String,String> getMapRepresentationOfASet(int setIndex){
		HashMap<String,String> dictionary=new HashMap<String, String>();
		if(setIndex >= this.studySetCollection.size()) {
			System.out.println("Failed to show map representation. Please enter a valid index.");
			 
		}
		else {
			int counter=0;
			for(StudySet set: this.studySetCollection) {
				if(counter==setIndex) {
					dictionary=set.setToHashMap();
				}
				counter++;
			}
		}
		return dictionary;
	}
	
	

	public int getNumberOfStudyset() {
		return this.studySetCollection.size();
	}
	
	public boolean checkIfSetExists(StudySet setForChecking) {
		return this.studySetCollection.contains(setForChecking);
	}

}
