package com.skilldistillery.jets.entities;

public class JetImpl extends Jet implements CargoCarrier{

    public JetImpl(String model, double speed, double range, double price) {
        super(model, speed, range, price);
    }

        @Override
        public void loadCargo() {
            
            System.out.println("Loading cargo for JetImpl");
        }
        public void fly() {
        	double time = getRange() / getSpeed();
        	System.out.println(getModel() + " is up, up, and away! And will be flying for: " + time + " hours");
        }
    }



