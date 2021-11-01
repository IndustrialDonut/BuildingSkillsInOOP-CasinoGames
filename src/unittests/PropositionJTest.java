package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Proposition;
import main.Wheel;
import main.WheelBuilder;
import random.MockRandom;

public class PropositionJTest {
	
	Wheel wheel;
	Proposition[] array = new Proposition[3];
	
	public PropositionJTest() {
		
		wheel = new Wheel(new MockRandom(), new WheelBuilder());
		
		array[0] = new Proposition("Straight 5", 35);
		array[1] = new Proposition("Split 3-6", 17);
		array[2] = new Proposition("Straight 5", 35);	
	}

	@Test
	public void testWinnings_from_bet() {
		
	}

	@Test
	public void testEqualsObject() {
		assertEquals(array[0], array[2]);
		assertTrue(array[1] != array[0]);
		assertTrue(array[2] != array[1]);
		
		assertEquals(array[0].hashCode(), array[2].hashCode());
		assertTrue(! (array[0].hashCode() == array[1].hashCode()));
	}

	/*
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}
	*/
}




print_win(one, 100);
print_win(one, 1259);
print_win(two, 9812);
print_win(three, 777);

static private void print_win(Proposition prop, int bet) {
	int win = prop.winnings_from_bet(bet);
	System.out.println(prop.toString() + " betting " + bet + ", won " + win);
}
