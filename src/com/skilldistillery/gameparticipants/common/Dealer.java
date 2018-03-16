package com.skilldistillery.gameparticipants.common;

public class Dealer implements Player {
	private Hand dealerHand; 

	@Override
	public Hand getHand() {
		return dealerHand;
	}

}
