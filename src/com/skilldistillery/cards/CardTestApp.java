package com.skilldistillery.cards;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CardTestApp {
	static Scanner kb = new Scanner(System.in); 
	static Deck deck = new Deck();

	public static void main(String[] args) {
		run();

	}
	private static void run() {
		deck.shuffleDeck();
		int numCards = 0;
		System.out.print("How many cards would you like? ");
		try {
			numCards = kb.nextInt();
		}
		catch (InputMismatchException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("That's not a number.");
		}
		if (numCards > 52) {
			System.out.println("Not enough cards in the deck.");
			return;
		}
		for (int i = 0; i < numCards; i++) {
			Card card = deck.dealCard();
			System.out.println(card);
		}
		
	}

}
