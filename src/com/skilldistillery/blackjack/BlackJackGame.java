package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.gameapp.common.Game;
import com.skilldistillery.gameparticipants.common.Dealer;
import com.skilldistillery.gameparticipants.common.Gambler;

public class BlackJackGame extends Game {
	static Scanner kb = new Scanner(System.in); 

	public static void main(String[] args) {
		
		BlackJackGame bjg = new BlackJackGame();
		Dealer dealer = new Dealer();
		List<Gambler> newPlayers = bjg.getGamblers(); 
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
		
	}

}