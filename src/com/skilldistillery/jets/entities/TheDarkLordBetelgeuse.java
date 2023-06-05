package com.skilldistillery.jets.entities;

public class TheDarkLordBetelgeuse extends JetImpl implements CombatReady {

    public TheDarkLordBetelgeuse(String model, double speed, double range, double price) {
        super(model, speed, range, price);
    }

    @Override
    public void dogFight() {
        System.out.println("The Dark Lord Betelgeuse hungers for battle as she swoops to the skies she eats a dragon leg on a stick. ");
        
    }

}
