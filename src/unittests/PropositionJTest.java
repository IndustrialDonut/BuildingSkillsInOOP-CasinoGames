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
		// only duplicate for test purposes, never should actually be a duplicate
		// proposition object in the program though
		array[2] = new Proposition("Straight 5", 35);
	}

	@Test
	public void testWinnings_from_bet() {
		Proposition a = new Proposition("test", 100);
		assertEquals(a.winnings_from_bet(50), 50 * 100);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(array[0], array[2]);
		assertTrue(! array[1].equals( array[0] ));
		assertTrue(! array[2].equals(array[1]));
		
		assertEquals(array[0].hashCode(), array[2].hashCode());
		assertTrue(! (array[0].hashCode() == array[1].hashCode()));
	}

	@Test
	public void testToString() {
		Proposition a = new Proposition("test", 12);
		assertEquals("test (12:1)", a.toString());
	}
}