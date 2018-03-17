package com.skilldistillery.gameparticipants.common;

public class Dealer implements Player {
	private Hand dealerHand = new Hand(); 
	private String name = ""; 

	@Override
	public Hand getHand() {
		return dealerHand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
