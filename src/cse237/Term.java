package cse237;

public class Term {
	private String question;
	private String correctDefinition;
	
	public Term(String question, String correctDefinition) {
		this.question = question;
		this.correctDefinition = correctDefinition;
	}
	
	/**
	 * Check the correctness of user's input answer
	 * @param inputDefinition the input definition of a term
	 * @return true if the input definition equals the correct definition and false otherwise
	 *
	 */
	public boolean checkAnswer(String inputDefinition) {
		return inputDefinition.equals(this.correctDefinition);
	}
	
	public String getTerm() {
		return this.question;
	}
	
	public String getDefinition() {
		return this.correctDefinition;
	}
}
