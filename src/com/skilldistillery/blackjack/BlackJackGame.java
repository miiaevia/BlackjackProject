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
		Gambler Ron = new Gambler();
		Ron.setName("Ron");
		gamblers.add(Ron);
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
		Deck deck = new Deck();
		// List<Player> players = new ArrayList<>();
		// for (int i = 0; i < newGamblers.size(); i++) {
		// players.add(newGamblers.get(i));
		// }
		// players.add(dealer);
		startRound(newGamblers, dealer, deck);
	}

	public void startRound(List<Gambler> gamblers, Dealer dealer, Deck deck) {
		for (int i = 0; i < gamblers.size(); i++) {
			Gambler gambler = gamblers.get(i);
			Card dealt = deck.dealCard();
			Card dealt2 = deck.dealCard();
			Hand playerHand = gambler.getHand();
			playerHand.addCard(dealt);
			playerHand.addCard(dealt2);
			String playerCards = "" + gambler.getName() + ", your cards are: \n\t1. " + dealt + "\n\t2. " + dealt2;
			System.out.println(playerCards);
			// Sysout to test that 2 cards were dealt
			// System.out.println(dealt);
		}
		Hand dealerHand = dealer.getHand();
		Card dealerCard1 = deck.dealCard();
		Card dealerCard2 = deck.dealCard();
		dealerHand.addCard(dealerCard1);
		dealerHand.addCard(dealerCard2);

		String dealerCardsInitial = "Dealer's cards are: \n\t1. Facedown\n\t2. " + dealerCard2.toString();
		System.out.println(dealerCardsInitial);

		// iterate over players so each can choose to hit or stand
		for (int i = 0; i < gamblers.size(); i++) {
			Gambler gambler = gamblers.get(i);
			// somehow I need to make loop that lets players hit as much as they want, up to
			// 22+
			// and then move onto either the dealer or the next player
			boolean hit = true;
			// do-while loop to draw card, show new player deck and same dealer cards, and
			// ask user to hit/stand again
			do {
				System.out.println("Would you like to hit or stand(1 or 2)? ");
				System.out.println("1. Hit");
				System.out.println("2. Stand");
				int nextMove = kb.nextInt();
				if (nextMove == 1) {
					Card dealt = deck.dealCard();
					gambler.getHand().addCard(dealt);
					System.out.println("" + gambler.getName() + ", your cards are now: ");
					gambler.getHand().showHand();
//					hit = false;
				}else if (nextMove == 2) {
					break;					
				}
			}while (hit = true);
			
		}
	}

}
