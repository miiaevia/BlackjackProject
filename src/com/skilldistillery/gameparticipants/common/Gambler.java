package com.skilldistillery.gameparticipants.common;

public class Gambler implements Player {
	private Hand gamblerHand; 

	@Override
	public Hand getHand() {
		return gamblerHand;
	}

}
