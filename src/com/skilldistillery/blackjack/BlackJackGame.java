package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.gameapp.common.Game;
import com.skilldistillery.gameparticipants.common.Dealer;
import com.skilldistillery.gameparticipants.common.Gambler;

public class BlackJackGame extends Game {

	public static void main(String[] args) {
		getPlayers(); 
		
	}

	public void getPlayers() {
		List<Gambler> gamblers = new ArrayList<>(); 
		Dealer dealer = new Dealer(); 
	}
}
