package com.skilldistillery.gameparticipants.common;

public class Dealer implements Player {
	private Hand dealerHand = new Hand(); 

	@Override
	public Hand getHand() {
		return dealerHand;
	}

}
