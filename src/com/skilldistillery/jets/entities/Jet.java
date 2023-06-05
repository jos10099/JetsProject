package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speed;
	private double range;
	private double price;

	public Jet(String model, double speed, double range, double price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;

	}

	public void fly() {
		double flightTime = range / speed;

		System.out.println("Model: " + model);
		System.out.println("Speed: " + speed + " MPH ");
		System.out.println("Range: " + range + " miles");
		System.out.println("Price: $" + price);
		System.out.println("Flight Time: " + flightTime + " hours");

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet: Model = " + model + ", Speed = " + speed + ", Range = " + range + ", Price = " + price;
	}

}
