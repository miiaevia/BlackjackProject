package com.skilldistillery.gameparticipants.common;

public class Gambler implements Player {
	private Hand gamblerHand = new Hand(); 

	@Override
	public Hand getHand() {
		return gamblerHand;
	}

}
