package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet;

	public AirField() {
		fleet = new ArrayList<>();

	}

	public void populateJetsFromFile(String fileName) {
		List<Jet> jets = readJets(fileName);
		fleet.addAll(jets);
	}
	public void loadCargo() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
			
		}
	}

	private List<Jet> readJets(String fileName) {
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetRecord = line.split(",");

				if (jetRecord.length == 5) {
					String model = jetRecord[0].trim();
					double speed = Double.parseDouble(jetRecord[1].trim());
					double range = Double.parseDouble(jetRecord[2].trim());
					double price = Double.parseDouble(jetRecord[3].trim());

					Jet jet = createJet(model, speed, range, price);
					jets.add(jet);

				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}
	public void dogFight() {
	    for (Jet jet : fleet) {
	        if (jet instanceof CombatReady) {
	            ((CombatReady) jet).dogFight();
	        }
	    }
	}
	
	


	private Jet createJet(String model, double speed, double range, double price) {
		return new JetImpl(model, speed, range, price);
	}

	public List<Jet> listFleet() {
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
		return fleet;
	}

	public void flyAllJets() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	public void viewFastestJet() {
		Jet fastestJet = null;
		double maxSpeed = Double.MIN_VALUE;
		for (Jet jet : fleet) {
			if (jet.getSpeed() > maxSpeed) {
				fastestJet = jet;
				maxSpeed = jet.getSpeed();
			}
		}

		if (fastestJet != null) {
			System.out.println("Fastest Jet:");
			System.out.println(fastestJet);
		} else {
			System.out.println("No jets available.");
		}
	}

	public void viewLongestRangeJet() {
		Jet longestRangeJet = null;
		double maxRange = 0.0;
		for (Jet jet : fleet) {
			if (jet.getRange() > maxRange) {
				longestRangeJet = jet;
				maxRange = jet.getRange();
			}
		}

		if (longestRangeJet != null) {
			System.out.println("Jet with Longest Range:");
			System.out.println(longestRangeJet);
		} else {
			System.out.println("No jets available.");
		}
	}


	public void dogfight() {
		for (Jet jet : fleet) {
			if (jet instanceof CombatReady) {
				CombatReady combatJet = (CombatReady) jet;
				System.out.println("Its war time!");
				combatJet.dogFight();
			}
		}
	}

	public boolean removeJet(String j) {
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			if (jet.getModel().equalsIgnoreCase(j)) {
				fleet.remove(i);
				return true;
			}
		}
		return false;
	}

	public void addJet(Jet jet) {
		fleet.add(jet);
		System.out.println("Jet added to the fleet.");
	}

	public void removeJet1(String model) {
		Jet jetToRemove = null;
		for (Jet jet : fleet) {
			if (jet.getModel().equalsIgnoreCase(model)) {
				jetToRemove = jet;
				break;
			}
		}

		if (jetToRemove != null) {
			fleet.remove(jetToRemove);
			System.out.println("Jet removed from the fleet.");
		} else {
			System.out.println("Jet not found in the fleet.");
		}
	}

	public void listFleet1() {
		if (fleet.isEmpty()) {
			System.out.println("No jets available.");
		} else {
			for (Jet jet : fleet) {
				System.out.println(jet);
			}
		}
	}

}
