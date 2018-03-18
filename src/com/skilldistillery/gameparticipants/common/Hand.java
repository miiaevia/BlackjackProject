package com.skilldistillery.gameparticipants.common;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Hand {
	
	List<Card> playerHand = new ArrayList<>();

	public void addCard(Card dealt) {
		playerHand.add(dealt);
	}
	
	public void showHand () {
		for (int i = 0; i < playerHand.size(); i++) {
			Card card = playerHand.get(i); 
			System.out.println(card.toString());
			
		}
	}
	
	public int getHandValue() {
		int result = 0; 
		for (Card card : playerHand) {
			result+= card.getvalue(); 
		}
		if (result > 21) {
			for (int i = 0; i < getNumAces(); i++) {
				result = result - 10; 
				if (result <= 21) {
					break;					
				}
			}
		}
		return result;
	}
	
	private int getNumAces() {
		int result = 0; 
		for ( Card card : playerHand ) {
			if (card.isAce()) {
				result ++; 
			}
		}
		return result;
	}

	public void removeCards() {
		playerHand.clear();
		
	}
}
