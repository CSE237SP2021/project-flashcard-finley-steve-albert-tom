package cse237;

import java.util.Scanner;

public class Menu {

	private Scanner keyboardIn;
	
	

	static SetManager setManager;

	public Menu() {
		keyboardIn = new Scanner(System.in);
		keyboardIn.useDelimiter(System.lineSeparator()); //so that the scanner works properly with multiple inputs. See: https://www.reddit.com/r/javahelp/wiki/scanner 
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
			if (selectedOption==3) { //if the user selected "quit"
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
				openSet(setToOpen);
			}

		}
		// if the user selected "Create set"
		else if (selectedOption == 2) {
			displayCreateSetMenu(flashCardMenu);
			String nameForNewSet = flashCardMenu.getUserInputString();
			createStudySet(flashCardMenu,nameForNewSet);
		}
		// if the user selected "Quit"
		else {
			//flashCardMenu.keyboardIn.close();
			return;
		}

	}

	private static void openSet(int index) {
		System.out.println("Opening set...");
		setManager.openStudySet(index);

	}

	private static void createStudySet(Menu flashCardMenu,String name) {
		System.out.println("Creating study set...");
		StudySet newSet = new StudySet(name);
		
		while(true) {

			System.out.println("Please enter the term: ");
			String term=flashCardMenu.getUserInputString();
			//flashCardMenu.keyboardIn.nextLine();
			//System.out.println(term);
			System.out.println("Please enter the definition: ");
			String definition=flashCardMenu.getUserInputString();
			//flashCardMenu.keyboardIn.nextLine();
			Term termToInsert=new Term(term,definition);
			//System.out.println(definition);
			newSet.insertTerm(termToInsert); 
			System.out.println("Keep adding? Enter yes(1) or no(0) ");
			int continueOrNot=flashCardMenu.getUserInputInt();
			
			if(continueOrNot==0) {
				break;
			}
			
		}
		
		
		
		setManager.insertStudySet(newSet);
	}

	private static void displayCreateSetMenu(Menu flashCardMenu) {

		System.out.println("Name for the new study set?");

	}

	private static int displayOpenSetMenu(Menu flashCardMenu) {
		System.out.println("Here's a list of all the study sets you created: ");
		int viewAllStudySetResult = setManager.viewAllStudySet();
		if (viewAllStudySetResult == 0) { //if there's no study set, return to the main menu 

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
