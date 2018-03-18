package com.skilldistillery.cards.common;

import java.util.*;

import com.skilldistillery.cards.common.Card;

public class Deck {
	private List<Card> deck =  new ArrayList<>();
	
	//
	//  Public
	//
	
	/**
	 * This is the constructor.
	 */
	public Deck() {
		createDeck();
	}

	/**
	 * This return the number of cards remaining in the deck.
	 * 
	 * @return Size of the deck
	 */ 
	public int deckSize() {
		return deck.size();
	}

	// this shuffles the deck
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	// this removes a card from the deck and returns it
	public Card dealCard() {
		Card card = deck.remove(0);
		return card;

	}
	
	//
	// Private
	//
	
	private void createDeck() {
		for (Suit suit : Suit.values()) {
			addRanks(suit);
		}
	}
	
	private void addRanks(Suit suit) {
		for (Rank rank : Rank.values()) {
			deck.add(new Card(rank, suit));
		}
	}

}
