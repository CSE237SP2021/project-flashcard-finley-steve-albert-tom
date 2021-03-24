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
