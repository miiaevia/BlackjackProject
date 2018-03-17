package com.skilldistillery.gameparticipants.common;

public abstract class Player {
	private Hand hand = new Hand(); 
	private String name;
	
	Player(String name) {
		this.name = name;
	}
	
	public final Hand getHand() {
		return hand;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
