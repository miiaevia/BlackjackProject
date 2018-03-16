package come.skilldistillery.blackjack.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.blackjack.BlackJackGame;
import com.skilldistillery.gameparticipants.common.Gambler;

public class BlackJackGameTests {
	
	BlackJackGame bjg; 
	@Before
	public void setUp() throws Exception {
		bjg = new BlackJackGame();
	}

	@After
	public void tearDown() throws Exception {
		bjg = null; 
	}
	@Test 
	public void test_bjg_List_Gamblers_not_null() {
		List<Gambler> unexpected = null;
		List<Gambler> actual = bjg.getGamblers(); 
		assertNotSame(unexpected, actual);
	}
	@Test
	public void test_BlackJackGame_instantiates_new_dealer() {
		fail("Not yet implemented");
	}
	@Test
	public void test_startGame_instantiates_new_deck() {
		fail("Not yet implemented");
	}
	@Test 
	public void test_startRound_deals_2_cards_to_each_player() {
		fail("Not yet implemented"); 
	}
	
}
