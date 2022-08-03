package com.purington.zookeeper1;

public class Bat extends Mammal {
	
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void batFly() {
		System.out.println("Wooooooosh");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("Yum Yum taste great");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Oh no the town is fire....");
		this.energyLevel -= 100;
	}
	
}
