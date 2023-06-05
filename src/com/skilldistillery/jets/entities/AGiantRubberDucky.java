package com.skilldistillery.jets.entities;

public class AGiantRubberDucky extends Jet implements CargoCarrier, CombatReady {

    public AGiantRubberDucky(String model, double speed, double range, double price) {
        super(model, speed, range, price);
    }

    public void loadCargo() {
        System.out.println("The rubber ducky squeaks happily as you put cargo on its back.");
    }

	@Override
	public void dogFight() {
		System.out.println("The rubber ducky puts on war paint...THIS IS FOR ERNIE!!");
		
	}

}
