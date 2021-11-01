package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.InvalidBet;
import main.Bet;
import main.Proposition;
import main.Wheel;
import main.WheelBuilder;
import random.MockRandom;

public class BetJTest {
	
	Wheel wheel;
	
	public BetJTest() {
		
		// Needed to populate Proposition
		wheel = new Wheel(new MockRandom(), new WheelBuilder());
		
	}

	@Test
	public void test() {
		try {
			Bet bet = new Bet(15, Proposition.getProposition("Straight 5"));
			Bet bet2 = new Bet(33, Proposition.getProposition("Top 5"));
			Bet bet3 = new Bet(900, Proposition.getProposition("Street 1 2 3"));
		} catch (InvalidBet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Bet failed to contruct");
		}
	}

}
