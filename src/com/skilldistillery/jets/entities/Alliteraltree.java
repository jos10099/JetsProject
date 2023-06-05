package com.skilldistillery.jets.entities;

public class Alliteraltree extends Jet implements CargoCarrier, CombatReady {

    public Alliteraltree(String model, double speed, double range, double price) {
        super(model, speed, range, price);
    }

    @Override
    public void loadCargo() {
        System.out.println("Little gremlings start loading pinecones into the branches of the tree, this is strange...");
    }

	

	@Override
	public void dogFight() {
		// TODO Auto-generated method stub
		
	}
}
