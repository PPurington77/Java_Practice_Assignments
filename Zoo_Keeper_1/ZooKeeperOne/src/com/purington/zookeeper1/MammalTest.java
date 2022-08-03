package com.purington.zookeeper1;

public class MammalTest {

	public static void main(String[] args) {

		Mammal m1 = new Mammal();
		System.out.println(m1.getEnergyLevel());
		Gorilla g1 = new Gorilla();
		System.out.println(g1.getEnergyLevel());
		
		//Gorilla test below-----------//
		
		g1.throwThings();
		g1.throwThings();
		g1.throwThings();
		System.out.println(g1.getEnergyLevel());
		System.out.println("--------------------");
		g1.eatBanana();
		g1.eatBanana();
		System.out.println(g1.getEnergyLevel());
		System.out.println("--------------------");
		g1.climb();
		System.out.println(g1.getEnergyLevel());
	}

}
