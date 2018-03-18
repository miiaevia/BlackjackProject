package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.gameapp.common.Game;
import com.skilldistillery.gameparticipants.common.Dealer;
import com.skilldistillery.gameparticipants.common.Gambler;
import com.skilldistillery.gameparticipants.common.Hand;

public class BlackJackGame extends Game {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		// start new blackjack game
		BlackJackGame bjg = new BlackJackGame();
		// create a new dealer
		Dealer dealer = new Dealer("Megan");
		// get a list of gamblers
		// hardcoded but can be expanded for user to enter a list
		List<Gambler> newGamblers = bjg.getGamblers();
		// start game passes dealers and players to game method
		bjg.startGame(dealer, newGamblers);
	}

	public List<Gambler> getGamblers() {
		List<Gambler> gamblers = new ArrayList<>();
		// System.out.print("How many players are there? ");
		// int numPlayers = kb.nextInt();
		Gambler ron = new Gambler("Ron");
		gamblers.add(ron);
		return gamblers;
	}

	public void startGame(Dealer dealer, List<Gambler> newGamblers) {
		// future: wrap in do-while loop to give option to deal more decks once
		// deck is empty
		// for now: loop to deal initial hands to all players (including dealer)
		// initial hand needs 2 rounds to deal 1 card at a time,
		// first to gamblers, then to dealer
		// second dealer card needs to be shown to players
		// FUTURE: add "deal card" method and refactor
		// List<Player> players = new ArrayList<>();
		// for (int i = 0; i < newGamblers.size(); i++) {
		// players.add(newGamblers.get(i));
		// }
		// players.add(dealer);
		startRound(newGamblers, dealer);
	}

	public void startRound(List<Gambler> gamblers, Dealer dealer) {
		Deck deck = new Deck();
		deck.shuffleDeck();
		for (int i = 0; i < gamblers.size(); i++) {
			Gambler gambler = gamblers.get(i);
			Card dealt = deck.dealCard();
			Card dealt2 = deck.dealCard();
			Hand playerHand = gambler.getHand();
			playerHand.addCard(dealt);
			playerHand.addCard(dealt2);
			String playerCards = gambler + ", your cards are: \n" + "\t1. " + dealt + "\n" + "\t2. " + dealt2;
			System.out.println(playerCards);
			// Sysout to test that 2 cards were dealt
			// System.out.println(dealt);
		}
		Hand dealerHand = dealer.getHand();
		Card dealerCard1 = deck.dealCard();
		Card dealerCard2 = deck.dealCard();
		dealerHand.addCard(dealerCard1);
		dealerHand.addCard(dealerCard2);

		String dealerCardsInitial = "Dealer's cards are: \n\t1. Facedown\n\t2. " +
		 dealerCard2.toString();
		// show both cards to debug
		// String dealerCardsInitial = "Dealer's cards are: \n\t1. Facedown (" +
		// dealerCard1.toString() + ")\n\t2. "
		// + dealerCard2.toString();
				System.out.println(dealerCardsInitial);

		List<Gambler> under21Gamblers = new ArrayList<>();
		// iterate over players so each can choose to hit or stand
		for (int i = 0; i < gamblers.size(); i++) {
			Gambler gambler = gamblers.get(i);
			// somehow I need to make loop that lets players hit as much as they want, up to
			// 22+
			// and then move onto either the dealer or the next player
			// do-while loop to draw card, show new player deck and same dealer cards, and
			// ask user to hit/stand again
			while (true) {
				// break if already 21
				if (gambler.getHand().getHandValue() == 21) {
					System.out.println(gambler + ", you win!");
					break;
				}
				System.out.println("Would you like to hit or stand(1 or 2)? ");
				System.out.println("1. Hit");
				System.out.println("2. Stand");
				int nextMove = kb.nextInt();
				if (nextMove == 1) {
					Card dealt = deck.dealCard();
					gambler.getHand().addCard(dealt);
					System.out.println("" + gambler + ", your cards are now: ");
					gambler.getHand().showHand();
					if (gambler.getHand().getHandValue() > 21) {
						System.out.println(gambler + ", you bust");
						// break if bust
						break;
					}

				}
				else if (nextMove == 2) {
					under21Gamblers.add(gambler);
					break;
				}
			}
		}

		// All players with 21 or bust, stop
		// Any players under 21, dealer continues
		if (under21Gamblers.size() > 0) {
			System.out.println(
					dealer + "'s hand is: " + "\n\t1." + dealerCard1.toString() + "\n\t2." + dealerCard2.toString());
			while (dealerHand.getHandValue() < 17) {
				Card dealerCard = deck.dealCard();
				dealerHand.addCard(dealerCard);
				System.out.println(dealer + " drew a " + dealerCard.toString());
			}
			if (dealerHand.getHandValue() > 21) {
				System.out.println("Dealer busts! Everybody wins!");
				// everybody wins!!!
			}
			else {
				for (Gambler gamblerLeft : under21Gamblers) {
					if (dealerHand.getHandValue() == gamblerLeft.getHand().getHandValue()) {
						System.out.println(gamblerLeft + ", you push");
					}
					else if (dealerHand.getHandValue() > gamblerLeft.getHand().getHandValue()) {
						System.out.println(dealer + " wins against " + gamblerLeft);
					}
					else if (dealerHand.getHandValue() < gamblerLeft.getHand().getHandValue()) {
						System.out.println(gamblerLeft + ", you win!!!");
					}
				}
			}

		}
	}
}
