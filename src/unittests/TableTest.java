package unittests;

import exceptions.InvalidBet;
import main.Bet;
import main.BinBuilder;
import main.Proposition;
import main.Table;
import main.Wheel;

public class TableTest {
	public static void test(){
		Wheel wheel = new Wheel();
		BinBuilder builder = new BinBuilder();
		builder.buildWheelBins(wheel);
		
		Proposition prop1 = Proposition.getProposition("Straight 5");
		Proposition prop2 = Proposition.getProposition("Top 5");
		Proposition prop3 = Proposition.getProposition("Split 5-8");
		
		/*
		Bet bet1 = new Bet(5000, prop3);
		Bet bet2= new Bet(111, prop2);
		Bet bet3 = new Bet(1, prop1);
		
		Table table = new Table();
		try {
			table.placeBet(bet3);
			System.out.println(table.getBets());
		} catch (InvalidBet e) {
			System.out.println("Bet invalid! Amount outside of regulation on Bet " + bet3.toString());
			e.printStackTrace();
		}
		try {
			table.placeBet(bet2);
			System.out.println(table.getBets());
		} catch (InvalidBet e) {
			System.out.println("Bet invalid! Amount outside of regulation on Bet " + bet3.toString());
			e.printStackTrace();
		}
		try {
			table.placeBet(bet1);
			System.out.println(table.getBets());
		} catch (InvalidBet e) {
			System.out.println("Bet invalid! Amount outside of regulation on Bet " + bet3.toString());
			e.printStackTrace();
		}*/
	}
}
