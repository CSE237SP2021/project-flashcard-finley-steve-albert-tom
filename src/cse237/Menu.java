package cse237;

import java.util.Scanner;

public class Menu {

	private Scanner keyboardIn;

	static SetManager setManager;

	public Menu() {
		keyboardIn = new Scanner(System.in);
		keyboardIn.useDelimiter(System.lineSeparator()); // so that the scanner works properly with multiple inputs.
															// See: https://www.reddit.com/r/javahelp/wiki/scanner
	}

	public static void main(String[] args) {
		Menu flashCardMenu = new Menu();
		run(flashCardMenu);
	}

	private static void run(Menu flashCardMenu) {

		setManager = new SetManager();

		// keep the programming running until the user hits "quit"
		while (true) {
			displayMainMenu();
			int selectedOption = flashCardMenu.getUserInputInt();
			if (selectedOption == 3) { // if the user selected "quit"
				System.out.println("Exiting the program...");

				break;
			}
			processMainMenu(flashCardMenu, selectedOption);
		}
		System.out.println("Program terminated!");

	}

	private static void processMainMenu(Menu flashCardMenu, int selectedOption) {

		// if the user selected "Open set"
		if (selectedOption == 1) {
			int displayOpenSetMenuResult = displayOpenSetMenu(flashCardMenu);

			if (displayOpenSetMenuResult == 0) { // if there's no set to open, return to the main menu
				System.out.println();
				return;
			} else { // open a set
				System.out.println("Please specify a set to open (enter a number)");
				int setToOpen = flashCardMenu.getUserInputInt();
				openSet(flashCardMenu, setToOpen);
			}

		}
		// if the user selected "Create set"
		else if (selectedOption == 2) {
			displayCreateSetMenu(flashCardMenu);
			String nameForNewSet = flashCardMenu.getUserInputString();
			createStudySet(flashCardMenu, nameForNewSet);
		}
		// if the user selected "Quit"
		else {
			// flashCardMenu.keyboardIn.close();
			return;
		}

	}

	private static void openSet(Menu flashCardMenu, int index) {
		System.out.println("Opening set...");

		/// display options
		while (true) {
			setManager.openStudySet(index - 1);
			System.out.println("Please select an option");
			System.out.println("1. Edit set");
			System.out.println("2. Study set");
			System.out.println("3. Delete set");
			System.out.println("4. Return to menu");

			int userOptionOpenSet = flashCardMenu.getUserInputInt();
			if (userOptionOpenSet == 4) { // if the user selected return to menu
				return;
			}
			int processResult = processUserInputOpenSet(flashCardMenu, index, userOptionOpenSet);
			if (processResult == 1) { // stay in the loop
				continue;
			} else { // return to menu
				break;
			}

		}

	}

	// Note: return 1 if we want to stay in the loop, 0 if we want to return to the
	// menu
	private static int processUserInputOpenSet(Menu flashCardMenu, int index, int userOptionOpenSet) {
		if (userOptionOpenSet == 1) { // if the user selected edit set
			System.out.println("Please select an option");
			System.out.println("1. Insert new terms");
			System.out.println("2. Edit terms");

			int userOptionEditSet = flashCardMenu.getUserInputInt();
			if (userOptionEditSet == 1) {

				insertTermToExistingStudySet(flashCardMenu, index);
				return 1;
			}

			else if (userOptionEditSet == 2) {
				//System.out.println("Not yet implemented."); 
				
				System.out.println("Please select an entry to edit (enter a number).");
				int userSelectedEntry= flashCardMenu.getUserInputInt();
				//need to add a quit option 
				System.out.println("Please select an option: ");
				System.out.println("1. Edit term");
				System.out.println("2. Edit definition");
				int userEditOption= flashCardMenu.getUserInputInt();
				
				
				
				return 1;
			}
		}

		else if (userOptionOpenSet == 3) { // if the user selected delete set
			System.out.println("Are you sure you want to delete the study set? Enter yes(1) or no(0) ");
			int userConfirmation = flashCardMenu.getUserInputInt();
			if (userConfirmation == 1) {
				setManager.deleteStudySet(index - 1); // be careful: index starts at 0 for delete set
				return 0;
			} else {
				return 1;
			}
		}
		return 1;
	}

	private static void insertTermToExistingStudySet(Menu flashCardMenu, int index) {
		while (true) {

			System.out.println("Please enter the term: ");
			String term = flashCardMenu.getUserInputString();
			// flashCardMenu.keyboardIn.nextLine();
			// System.out.println(term);
			System.out.println("Please enter the definition: ");
			String definition = flashCardMenu.getUserInputString();
			// flashCardMenu.keyboardIn.nextLine();
			Term termToInsert = new Term(term, definition);
			// System.out.println(definition);
			setManager.insertTermToStudySet(index - 1, termToInsert);
			System.out.println("Keep adding? Enter yes(1) or no(0) ");
			int continueOrNot = flashCardMenu.getUserInputInt();

			if (continueOrNot == 0) {
				break;
			}

		}
	}

	private static void createStudySet(Menu flashCardMenu, String name) {
		System.out.println("Creating study set...");
		StudySet newSet = new StudySet(name);

		insertTermsToNewStudyset(flashCardMenu, newSet);

		setManager.insertStudySet(newSet);
	}

	private static void insertTermsToNewStudyset(Menu flashCardMenu, StudySet newSet) {
		while (true) {

			System.out.println("Please enter the term: ");
			String term = flashCardMenu.getUserInputString();
			// flashCardMenu.keyboardIn.nextLine();
			// System.out.println(term);
			System.out.println("Please enter the definition: ");
			String definition = flashCardMenu.getUserInputString();
			// flashCardMenu.keyboardIn.nextLine();
			Term termToInsert = new Term(term, definition);
			// System.out.println(definition);
			newSet.insertTerm(termToInsert);
			System.out.println("Keep adding? Enter yes(1) or no(0) ");
			int continueOrNot = flashCardMenu.getUserInputInt();

			if (continueOrNot == 0) {
				break;
			}

		}
	}

	private static void displayCreateSetMenu(Menu flashCardMenu) {

		System.out.println("Name for the new study set?");

	}

	private static int displayOpenSetMenu(Menu flashCardMenu) {
		System.out.println("Here's a list of all the study sets you created: ");
		int viewAllStudySetResult = setManager.viewAllStudySet();
		if (viewAllStudySetResult == 0) { // if there's no study set, return to the main menu

			System.out.println("Returning to the main menu");
			return 0;

		} else {

			return 1;

		}

	}

	private static void displayMainMenu() {
		System.out.println("\nWelcome to the Flashcard App!"); // need to come up with a better name later :(

		System.out.println("//////////////////////////////////////////////////////");

		System.out.println("Please select an option: ");

		System.out.println("1. Open set");
		System.out.println("2. Create set");
		System.out.println("3. Quit");

	}

	private int getUserInputInt() {
		return keyboardIn.nextInt();
	}

	private String getUserInputString() {
		return keyboardIn.next();
	}

}
