package com.purington.zookeeper1;

public class Gorilla extends Mammal {

	public Gorilla() {
		super();
	}
	
	public int getEnergyLevel() {
		return super.getEnergyLevel();
	}
	
	public void throwThings() {
		System.out.println("Throwing that thing");
		this.energyLevel -= 5;
	}
	
	public void eatBanana() {
		System.out.println("Eating a bananan...gaining power!!!");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Climbing up that hill...I mean tree");
		this.energyLevel -= 10;
	}
}
