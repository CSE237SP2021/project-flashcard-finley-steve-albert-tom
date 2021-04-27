package cse237;

import java.util.HashMap;
import java.util.Map;
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
			processMenu(flashCardMenu, selectedOption);
		}
		System.out.println("Program terminated!");

	}

	private static void processMenu(Menu flashCardMenu, int selectedOption) {

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
			displaySetMenu(flashCardMenu);
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
			int processResult = processInputOpenSet(flashCardMenu, index, userOptionOpenSet);
			if (processResult == 1) { // stay in the loop
				continue;
			} else { // return to menu
				break;
			}

		}

	}

	// Note: return 1 if we want to stay in the loop, 0 if we want to return to the
	// menu
	private static int processInputOpenSet(Menu flashCardMenu, int index, int userOptionOpenSet) {
		if (userOptionOpenSet == 1) { // if the user selected edit set
			System.out.println("Please select an option");
			System.out.println("1. Insert new terms");
			System.out.println("2. Edit terms");

			int userOptionEditSet = flashCardMenu.getUserInputInt();
			if (userOptionEditSet == 1) {

				insertTermToStudySet(flashCardMenu, index);
				return 1;
			}

			else if (userOptionEditSet == 2) {

				return editTermFromStudySet(flashCardMenu, index);
			}
		}

		else if (userOptionOpenSet == 3) { // if the user selected delete set
			System.out.println("Are you sure you want to delete the study set? Enter yes(1) or no(0) ");
			int userConfirmation = flashCardMenu.getUserInputInt();
			if (userConfirmation == 1) {
				setManager.deleteStudySet(index - 1); // be careful: index starts at 0 for delete set
				return 0; // return to menu
			} else {
				return 1;
			}
		} else if (userOptionOpenSet == 2) { // if the user selected study set
			return studySet(flashCardMenu, index); 
		}
		return 1;
	}

	private static int studySet(Menu flashCardMenu, int index) {
		System.out.println("Entering study mode...");
		System.out.println("Please select an option (enter a number): ");
		System.out.println("1. Show terms");
		System.out.println("2. Show definitions");
		int userOptionStudyMode1 = flashCardMenu.getUserInputInt();
		while(true) {
			HashMap<String, String> dictionary = setManager.getMapRepresentationOfASet(index-1);
			System.out.println("Learning started!");
			int learningCounter=1;
			for (Map.Entry<String, String> entry : dictionary.entrySet()) {
				String term = entry.getKey();
				String definition = entry.getValue();
				
				if (userOptionStudyMode1 == 1) {// if the user selected show terms
					displayTerm(flashCardMenu, learningCounter, term, definition);
				} else {// if the user selected show definitions
					displayDefinition(flashCardMenu, learningCounter, term, definition);

				}
				learningCounter++;
			}
			System.out.println("Congratulations! You've learned everything in the study set!");
			System.out.println("Please select an option: \n");
			System.out.println("1. Start over");
			System.out.println("2. Exit study mode");
			int userOptionStudyMode3=flashCardMenu.getUserInputInt();
			if(userOptionStudyMode3==2) {//if the user selected exit
				System.out.println("Exiting study mode...");
				break;
			}
			else {//if the user selected start over
				System.out.println("Starting over...");
			}
			
		}
		
		return 1;
	}

	private static void displayDefinition(Menu flashCardMenu, int learningCounter, String term,
			String definition) {
		System.out.println();
		System.out.println("////////////////////////////////////");
		System.out.println("Displaying definition no."+learningCounter+"\n" );
		System.out.println("Definition: "+definition);
		System.out.println("\n Options: \n");
		System.out.println("1. Check Term");
		System.out.println("2. Skip");
		int userOptionStudyMode2 = flashCardMenu.getUserInputInt();

		if (userOptionStudyMode2 == 1) {
			System.out.println("Here's the definition for the term: \n");
			System.out.println(term+"\n");
		} else {
			System.out.println();
			System.out.println("Skipping to the next definition... \n");
		}
	}

	private static void displayTerm(Menu flashCardMenu, int learningCounter, String term, String definition) {
		System.out.println();
		System.out.println("////////////////////////////////////");
		System.out.println("Displaying term no. "+learningCounter+"\n");
		
		
		System.out.println("Term: "+term);
		System.out.println();
		System.out.println("Options: \n");
		System.out.println("1. Check Definition");
		System.out.println("2. Skip");
		int userOptionStudyMode2 = flashCardMenu.getUserInputInt();

		if (userOptionStudyMode2 == 1) {
			System.out.println("Here's the term for the definition: \n");
			System.out.println(definition+"\n");
		} else {
			System.out.println("Skipping to the next term... \n");
		}
	}

	private static int editTermFromStudySet(Menu flashCardMenu, int index) {
		setManager.openStudySet(index - 1); // display all the terms and definitions again
		System.out.println();
		System.out.println("Please select an entry to edit (enter a number).");
		int userSelectedEntry = flashCardMenu.getUserInputInt();
		// need to add a quit option
		System.out.println("Please select an option: ");
		System.out.println("1. Edit term");
		System.out.println("2. Edit definition");
		int userEditOption = flashCardMenu.getUserInputInt();
		int editResult = 0;
		if (userEditOption == 1) {
			System.out.println("Please enter the new term: ");
			String userEnteredTerm = flashCardMenu.getUserInputString();
			editResult = setManager.editTermInStudySet(index - 1, userSelectedEntry - 1, userEnteredTerm, 0);
			if (editResult == 1) {
				System.out.println("Edit successful.");
			}

		} else if (userEditOption == 2) {
			System.out.println("Please enter the new definition: ");
			String userEnteredDefinition = flashCardMenu.getUserInputString();
			editResult = setManager.editTermInStudySet(index - 1, userSelectedEntry - 1, userEnteredDefinition, 1);

			if (editResult == 1) {
				System.out.println("Edit sucessful");
			}
		}

		return 1; // stay in the loop
	}

	private static void insertTermToStudySet(Menu flashCardMenu, int index) {
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
			System.out.println("Keep adding? Enter 1(yes) or 0(no) ");
			int continueOrNot = flashCardMenu.getUserInputInt();

			if (continueOrNot == 1) {
				continue;
			} else {
				break;
			}

		}
	}

	private static void createStudySet(Menu flashCardMenu, String name) {
		System.out.println("Creating study set...");
		StudySet newSet = new StudySet(name);
		insertTermsToStudyset(flashCardMenu, newSet);

		setManager.insertStudySet(newSet);
	}

	private static void insertTermsToStudyset(Menu flashCardMenu, StudySet newSet) {
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
			System.out.println("Keep adding? Enter 1(yes) or 0(no) ");

			int continueOrNot = flashCardMenu.getUserInputInt();
			if (continueOrNot == 1) {
				continue;
			} else {
				break;
			}

		}
	}

	private static void displaySetMenu(Menu flashCardMenu) {

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
		while (!keyboardIn.hasNextInt()) { // hasNextInt keeps the input in the buffer
			System.out.println("Please enter a valid integer.");
			keyboardIn.next(); // if input not int, consume and discard the input from the buffer
		}
		return keyboardIn.nextInt(); // if input is int, consume and return the input from the buffer
	}

	private String getUserInputString() {
		return keyboardIn.next();
	}

}
