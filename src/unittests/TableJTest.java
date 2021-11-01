package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.InvalidBet;
import main.Bet;
import main.BinBuilder;
import main.Proposition;
import main.Table;
import main.Wheel;

public class TableJTest {
	private Wheel wheel;
	private BinBuilder builder;
	private Table table;
	
	Proposition[] array = new Proposition[3];
	Bet invalidBet;
	Bet validBet;
	Bet validBet2;
	//Bet invalidBet2;
	
	public TableJTest() throws InvalidBet {
		wheel = new Wheel();
		builder = new BinBuilder();
		builder.buildWheelBins(wheel);
		
		table = new Table();
		
		array[0] = Proposition.getProposition("Straight 5");
		array[1] = Proposition.getProposition("Top 5");
		array[2] = Proposition.getProposition("Split 5-8");
		
		invalidBet = new Bet(table.getTableLimit() + 1, array[0]);
		validBet = new Bet(table.getTableLimit(), array[0]);
		validBet2 = new Bet(table.getTableMinimum(), array[0]);
		//invalidBet2 = new Bet(table.getTableMinimum() - 1, array[0]);
	}

	@Test
	public void testClearTableBets() {
		table.clearTableBets();
		assertEquals(0, table.getBetsCount());
	}

	@Test
	public void testIterator() {
		testPlaceBet();
		assertEquals(2, table.getBetsCount());
	}

	@Test
	public void testPlaceBet() {
		try {
			table.placeBet(validBet);
			table.placeBet(validBet2);
		} catch (InvalidBet e) {
			e.printStackTrace();
			fail("Invalid bet exception");
		}
		
		try {
			table.placeBet(invalidBet);
			//table.placeBet(invalidBet2);
			fail("SHOULD HAVE thrown InvalidBet exception");
		}catch(InvalidBet e) {
			e.printStackTrace();
		}
		
	}

}
