package com.skilldistillery.gameparticipants.common;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Hand {
	
	List<Card> playerHand = new ArrayList<>();

	public void addCard(Card dealt) {
		playerHand.add(dealt);
		
	} 
	public void showSecondCard() {
		
	}
	public void showHand () {
		for (int i = 0; i < playerHand.size(); i++) {
			Card card = playerHand.get(i); 
			System.out.println(card.toString());
			
		}
	}

}
