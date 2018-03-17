package com.skilldistillery.gameparticipants.common;

public class Gambler implements Player {
	private Hand gamblerHand = new Hand(); 
	private String name = ""; 

	@Override
	public Hand getHand() {
		return gamblerHand;
	}

	public void setGamblerHand(Hand gamblerHand) {
		this.gamblerHand = gamblerHand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Hand getHand() {
//		return null;
//	}

	

}
