package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import exceptions.InvalidBet;
import main.Bet;
import random.MockRandom;
import wheel.Wheel;
import wheel.WheelBuilder;
import main.Proposition;
import main.Table;

public class TableJTest {
	private Wheel wheel;
	private WheelBuilder builder;
	private Table table;
	
	Proposition[] array = new Proposition[3];
	Map<String, Bet> bets = new HashMap<String, Bet>();
	
	public TableJTest(){
		wheel = new Wheel(new MockRandom(), new WheelBuilder());
		
		table = new Table();
		
		array[0] = Proposition.getProposition("Straight 5");
		array[1] = Proposition.getProposition("Top 5");
		array[2] = Proposition.getProposition("Split 5-8");
		
		try {
			bets.put("invalid", new Bet(table.getTableLimit() + 1, array[0]));
			bets.put("valid", new Bet(table.getTableLimit(), array[0]));
			bets.put("valid2", new Bet(table.getTableMinimum(), array[0]));
		} catch (InvalidBet e) {
			System.out.println("Cannot construct bets to test with");
			e.printStackTrace();
		}
	}

	@Test
	public void testClearTableBets() {
		testPlaceBet();
		table.clearTableBets();
		assertEquals(0, table.getBetsCount());
	}

	@Test
	public void testIterator() {
		testPlaceBet();
		assertEquals(2, table.getBetsCount());
		for(Bet bet : table) {
			assertTrue(bets.values().contains(bet));
		}
	}

	@Test
	public void testPlaceBet() {
		try {
			table.placeBet(bets.get("valid"));
			table.placeBet(bets.get("valid2"));
		} catch (InvalidBet e) {
			e.printStackTrace();
			fail("Invalid bet exception");
		}
		
		try {
			table.placeBet(bets.get("invalid"));
			fail("SHOULD HAVE thrown InvalidBet exception");
		}catch(InvalidBet e) {
			//e.printStackTrace();
		}
	}
}
