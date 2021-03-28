package cse237;

import java.util.Scanner;

public class Menu {

	private Scanner keyboardIn;
	
	static SetManager setManager;
	
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Menu flashCardMenu = new Menu();
		run(flashCardMenu);
	}

	private static void run(Menu flashCardMenu) {
		displayMainMenu();
		setManager = new SetManager();
		int selectedOption = flashCardMenu.getUserInputInt();
		processMainMenu(flashCardMenu, selectedOption);
		flashCardMenu.keyboardIn.close();
	}

	private static void processMainMenu(Menu flashCardMenu, int selectedOption) {
		if (selectedOption == 1) {
			displayOpenSetMenu(flashCardMenu);
			String setToOpen = flashCardMenu.getUserInputString();
			openSet(setToOpen);
		} else {
			displayCreateSetMenu(flashCardMenu);
//			String nameForNewSet = flashCardMenu.getUserInputString();
			Scanner inputString = new Scanner(System.in);
			String nameForNewSet = inputString.nextLine();
			createStudySet(nameForNewSet);
		}
	}
	private static void openSet(String name) {
		System.out.println("Opening set...");
		setManager.viewAllStudySet();
	}

	private static void createStudySet(String name) {
		System.out.println("Creating study set...");
		StudySet newSetName= new StudySet(name);
		setManager.insertStudySet(newSetName);
	}

	private static void displayCreateSetMenu(Menu flashCardMenu) {
//		StudySet studyset = new StudySet("Test1");
//		if (result.(studyset.getName())) {
//			System.out.println("Success");
//		}else {
//		}
		System.out.println("Name for the new study set?");
//		Scanner inputString = new Scanner(System.in);
//		String result = inputString.nextLine();
	}

	private static void displayOpenSetMenu(Menu flashCardMenu) {
		System.out.println("Please specify which study set to open.");

	}

	private static void displayMainMenu() {
		System.out.println("Welcome to the Flashcard App!");
		System.out.println("Here's a list of all the study sets you created: ");
		System.out.println("1. test1");
		System.out.println("2. test2");
		System.out.println("3. test3");
		System.out.println("//////////////////////////////////////////////////////");

		System.out.println("Please select an option: ");

		System.out.println("1. Open set");
		System.out.println("2. Create set");
	}

	private int getUserInputInt() {
		return keyboardIn.nextInt();
	}

	private String getUserInputString() {
		return keyboardIn.nextLine();
	}

}
