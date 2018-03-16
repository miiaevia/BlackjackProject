package come.skilldistillery.blackjack.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.blackjack.BlackJackGame;
import com.skilldistillery.gameparticipants.common.Dealer;
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
	
}
