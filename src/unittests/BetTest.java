package unittests;

import main.Bet;
import main.BinBuilder;
import main.Proposition;
import main.Wheel;

public class BetTest {
	public static void test(){
		
		Wheel wheel = new Wheel();
		BinBuilder builder = new BinBuilder();
		builder.buildWheelBins(wheel);
		
		/*
		Bet bet = new Bet(15, Proposition.getProposition("Straight 5"));
		Bet bet2 = new Bet(33, Proposition.getProposition("Top 5"));
		Bet bet3 = new Bet(900, Proposition.getProposition("Street 1 2 3"));
		*/
	}
	
}
