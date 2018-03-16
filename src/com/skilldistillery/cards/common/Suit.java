package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	final private String name;

	Suit(String n) {
		name = n; 
	}
	public String toString() {
		return this.name;
	}
	
}
