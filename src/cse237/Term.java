package cse237;

public class Term {
	private String term;
	private String definition;

	public Term(String term, String definition) {
		this.term = term;
		this.definition = definition;
	}

	/**
	 * Check the correctness of user's input answer
	 * 
	 * @param inputDefinition the input definition of a term
	 * @return true if the input definition equals the correct definition and false
	 *         otherwise
	 *
	 */
	public boolean checkAnswer(String inputDefinition) {
		return inputDefinition.equals(this.definition);
	}

	public String getTerm() {
		return this.term;
	}

	public String getDefinition() {
		return this.definition;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
}
