package com.skilldistillery.cards.common;

import java.util.*;

import com.skilldistillery.cards.common.Card;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck= createDeck();
	}
	


	private List<Card> createDeck() {
	    deck = new ArrayList<>();
		for (Suit mySuit : Suit.values()) {
			for (Rank myRank : Rank.values()) {
				deck.add(new Card(myRank, mySuit));
			}
		}
		return deck;
	}
	// this should return the number of cards remaining in the deck
	public int checkDeckSize() {
		return  deck.size();
	}
	// this shuffles the deck
	void shuffleDeck() {
		Collections.shuffle(deck);
	}
	// this removes a card from the deck and returns it
	public Card dealCard() {
		Card card = deck.remove(0); 
		return card; 
		
	}

}
