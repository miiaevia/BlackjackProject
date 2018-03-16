package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.gameapp.common.Game;
import com.skilldistillery.gameparticipants.common.Dealer;
import com.skilldistillery.gameparticipants.common.Gambler;

public class BlackJackGame extends Game {
	static Scanner kb = new Scanner(System.in); 

	public static void main(String[] args) {
		
		//start new blackjack game
		BlackJackGame bjg = new BlackJackGame();
		// create a new dealer
		Dealer dealer = new Dealer();
		// get a list of gamblers
		// hardcoded but can be expanded for user to enter a list
		List<Gambler> newPlayers = bjg.getGamblers(); 
		// start game passes dealers and players to game method
		bjg.startGame(dealer, newPlayers);
	}

	public List<Gambler> getGamblers() {
		List<Gambler> gamblers = new ArrayList<>(); 
//		System.out.print("How many players are there? ");
//		int numPlayers = kb.nextInt(); 
		Gambler Ron = new Gambler();
		gamblers.add(Ron); 
		return gamblers; 
	}

	public void startGame(Dealer dealer, List<Gambler> newPlayers) {
		//future: wrap in do-while loop to give option to deal more decks once
		// deck is empty
		// for now: loop to deal initial hands to all players (including dealer)
		// initial hand needs 2 rounds to deal 1 card at a time, 
		// first to gamblers, then to dealer
		// first dealer card should be face down
		Deck deck = new Deck(); 
	}

}