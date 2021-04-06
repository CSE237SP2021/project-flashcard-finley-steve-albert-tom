package cse237;

import java.util.HashSet;
import java.util.Set;

public class StudySet {
	private Set<Term> studySetCollection;
	private String studySetName;

	public StudySet(String name) {
		this.studySetCollection = new HashSet<Term>();
		this.studySetName = name;
	}

	public boolean insertTerm(Term termForInsertion) {
		if (checkIfTermExists(termForInsertion)) {
			System.out.println("Error in insertion. Term already exists.");
			return false;
		} else {
			this.studySetCollection.add(termForInsertion);
			System.out.println("Term successfully inserted.");
			return true;
		}
	}

	public boolean deleteTerm(Term termForDeletion) {
		if (checkIfTermExists(termForDeletion)) {
			this.studySetCollection.remove(termForDeletion);
			System.out.println("Term successfully deleted.");
			return true;
		} else {
			System.out.println("Error in deletion. Term does not exist.");
			return false;
		}
	}

//	// TODO: change user message
//	public boolean changeTermDefinition(Term termForModification, String newDefinition) {
//		String existingTerm = termForModification.getTerm();
//		
//		//NEED TO CHANGE THIS 
//		if (this.deleteTerm(termForModification)) {
//			Term newTerm = new Term(existingTerm, newDefinition);  // new term to be inserted into studySet
//			return this.insertTerm(newTerm);
//		}
//		return false; // error in deleting the term
//	}

	public boolean changeTermDefinition(int index, String newDefinition) {
		if (index > this.studySetCollection.size() - 1) {
			System.out.println("Operation failed! Please make sure you enter a valid index!");
			return false;
		} else {
			int counter = 0;

			for (Term term : studySetCollection) {
				if (counter == index) {
					term.setDefinition(newDefinition);
					System.out.println("Definition successfully changed!");
					break;
				}

			}

			return true;
		}

	}

	public boolean changeTerm(int index, String newTermName) {

		if (index > this.studySetCollection.size() - 1) {
			System.out.println("Operation failed! Please make sure you enter a valid index!");
			return false;
		} else {
			int counter = 0;

			for (Term term : studySetCollection) {
				if (counter == index) {
					term.setTerm(newTermName);
					System.out.println("Term successfully changed!");
					break;
				}

			}

			return true;
		}

	}

	public void changeStudySetName(String newName) {
		System.out.println("Changing study set name to " + newName + "...");
		this.studySetName = newName;
		System.out.println("Name successfully changed to " + newName + "!");
	}
	
	

	public void viewAllTerms() {
		String studySetName = this.studySetName;
		System.out.println("////////////////////////////////////////////");
		System.out.println("These are all the terms in " + studySetName + ": ");
		System.out.println();

		int currentIndex = 1;

		for (Term currentTerm : this.studySetCollection) {
			String termName = currentTerm.getTerm();
			String termDefinition = currentTerm.getDefinition();
			String lineToBeDisplayed = String.valueOf(currentIndex) + ". " + termName + " || " + termDefinition;
			System.out.println(lineToBeDisplayed);
			currentIndex++;

		}

		System.out.println("////////////////////////////////////////////");

	}
	

	public boolean checkIfTermExists(Term termForChecking) {
		return this.studySetCollection.contains(termForChecking);
	}

	public int getSize() {
		return studySetCollection.size();
	}

	public String getName() {
		return this.studySetName;
	}

	
}
