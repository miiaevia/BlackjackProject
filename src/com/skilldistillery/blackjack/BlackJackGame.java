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
		do {
			for (Gambler gambler: newGamblers) {
				gambler.getHand().removeCards(); 
			}
			dealer.getHand().removeCards();
			startRound(newGamblers, dealer);		
			System.out.println("\nDo you want to continue(y/n)?");
			String response = kb.next();
			if(response.toLowerCase().startsWith("n")) {
				return;
			}
		} while (true); 
	}

	public void startRound(List<Gambler> gamblers, Dealer dealer) {
		Deck deck = new Deck();
		deck.shuffleDeck();
		List<Gambler> noBlackJackGamblers = new ArrayList<>();
		List<Gambler> blackJackGamblers = new ArrayList<>();
		for (Gambler gambler : gamblers) {
			Card dealt = deck.dealCard();
			Card dealt2 = deck.dealCard();
			Hand playerHand = gambler.getHand();
			playerHand.addCard(dealt);
			playerHand.addCard(dealt2);
			System.out.println(gambler + ", your cards are: \n" + "\t1. " + dealt + "\n" + "\t2. " + dealt2);
			// this line is to debug by looking at player hand value
			System.out.println("Player hand value is " + playerHand.getHandValue());
			if (playerHand.getHandValue() != 21) {
				noBlackJackGamblers.add(gambler);
			}
			else {
				blackJackGamblers.add(gambler);
			}
			// Sysout to test that 2 cards were dealt
			// System.out.println(dealt);
		}
		Hand dealerHand = dealer.getHand();
		Card dealerCard1 = deck.dealCard();
		Card dealerCard2 = deck.dealCard();
		dealerHand.addCard(dealerCard1);
		dealerHand.addCard(dealerCard2);

		String dealerCardsInitial = "Dealer's cards are: \n\t1. Facedown\n\t2. " + dealerCard2.toString();
		if (dealerHand.getHandValue() == 21) {
			System.out.println(dealer + " got a BlackJack.");
			System.out.println("Dealer's cards are: \n\t1 " + dealerCard1 + "\n\t2. " + dealerCard2.toString());
			for (Gambler gambler : blackJackGamblers) {
				System.out.println(gambler + ", you and " + dealer + " both got a BlackJack, you push.");
			}
			for (Gambler gambler : noBlackJackGamblers) {
				System.out.println(gambler + ", the dealer got a BlackJack. You lose.");
			}
			return;
		}
		else {
			for (Gambler gambler : blackJackGamblers) {
				System.out.println(gambler + ", you got a BlackJack. You win!!!");
			}
		}

		// else if (dealer.getHand().getHandValue() != 21){
		// System.out.println( gambler + ", you got a BlackJack! You win!!!");
		// }
		// else {
		// System.out.println(gambler + ", you and the dealer both push.");
		// }
		// show both cards to debug
		// String dealerCardsInitial = "Dealer's cards are: \n\t1. Facedown (" +
		// dealerCard1.toString() + ")\n\t2. "
		// + dealerCard2.toString();
		System.out.println(dealerCardsInitial);

		// iterate over players so each can choose to hit or stand
		List<Gambler> gamblersStanding = new ArrayList<>();
		for (Gambler gambler : noBlackJackGamblers) {
			// somehow I need to make loop that lets players hit as much as they want, up to
			// 22+
			// and then move onto either the dealer or the next player
			// do-while loop to draw card, show new player deck and same dealer cards, and
			// ask user to hit/stand again
			while (true) {
				// break if already 21
				if (gambler.getHand().getHandValue() == 21) {
					gamblersStanding.add(gambler); 
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
					System.out.println("Player's card value is " + gambler.getHand().getHandValue());
					if (gambler.getHand().getHandValue() > 21) {
						System.out.println(gambler + ", you bust");
						// break if bust
						break;
					}

				}
				else if (nextMove == 2) {
					gamblersStanding.add(gambler);
					break;
				}
			}
		}

		// All players with 21 or bust, stop
		// Any players under 21, dealer continues
		if (gamblersStanding.size() == 0) {
			return;
		}

		System.out.println(
				dealer + "'s hand is: " + "\n\t1." + dealerCard1.toString() + "\n\t2." + dealerCard2.toString());
		System.out.println("Dealer's hand value is " + dealer.getHand().getHandValue());
		while (dealerHand.getHandValue() < 17) {
			Card dealerCard = deck.dealCard();
			dealerHand.addCard(dealerCard);
			System.out.println(dealer + " drew a " + dealerCard.toString());
			System.out.println("Dealer's hand value is " + dealer.getHand().getHandValue());
		}
		if (dealerHand.getHandValue() > 21) {
			System.out.println("Dealer busts! Everybody wins!");
			// everybody wins!!!
		}
		else {
			for (Gambler gamblerLeft : noBlackJackGamblers) {
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
