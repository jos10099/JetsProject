package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class JetsApp {

	private AirField airField;
	private Scanner scanner;

	public JetsApp() {
		airField = new AirField();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();
	}

	public void run() {
		airField.populateJetsFromFile("jets.txt"); // Replace "jets.txt" with the actual file path

		boolean running = true;
		while (running) {
			displayMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				airField.listFleet();
				break;
			case 2:
				airField.flyAllJets();
				break;
			case 3:
				airField.viewFastestJet();
				break;
			case 4:
				airField.viewLongestRangeJet();
				break;
			case 5:
				airField.loadCargo();
				break;
			case 6:
				airField.dogfight();
				break;
			case 7:
				addJetToFleet();
				break;
			case 8:
				removeJetFromFleet();
				break;
			case 9:
				running = false;
				System.out.println("Exiting the program.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
		scanner.close();
	}

	private void displayMenu() {
		System.out.println("~~~~~~~~ Jets Application Menu ~~~~~~~~");
		System.out.println("1. List fleet: ");
		System.out.println("2. Scramble all Jets: ");
		System.out.println("3. View fastest jet: ");
		System.out.println("4. View jet with longest range: ");
		System.out.println("5. Load all Cargo Jets: ");
		System.out.println("6. Dogfight! (Pew Pew)");
		System.out.println("7. Add a jet to Fleet: ");
		System.out.println("8. Remove a jet from Fleet: ");
		System.out.println("9. Quit");
		System.out.print("Enter your choice: ");
	}

	  private void addJetToFleet() {
	        System.out.println("Enter the specifications of the Jet you wish to create:  ");
	        System.out.print("Model : ");
	        String model = scanner.nextLine();
	        System.out.print("Speed (MPH) : ");
	        double speed = scanner.nextDouble();
	        System.out.print("Range (miles) : ");
	        double range = scanner.nextDouble();
	        System.out.print("Price: ");
	        double price = scanner.nextDouble();

	        Jet jet = new JetImpl(model, speed, range, price);

	        airField.addJet(jet);

	        System.out.println("The jet has been added to the fleet. Do you feel like a God yet?");
	    }

	private void removeJetFromFleet() {
		System.out.println("The user giveth and the user taketh away, the jet has been removed.");
		String model = scanner.nextLine();

		airField.removeJet(model);
	}

}
