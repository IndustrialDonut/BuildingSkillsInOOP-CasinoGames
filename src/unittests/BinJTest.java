package unittests;

import org.junit.Test;

import junit.framework.TestCase;
import main.Bin;
import main.Proposition;

public class BinJTest extends TestCase {

	Bin bin0;
	Bin bin1;
	
	public BinJTest() {
		Proposition st0 = new Proposition("Straight 0", 35);
		Proposition fiver = new Proposition("00 0 1 2 3", 6);
		Proposition st00 = new Proposition("Straight 00", 35);
		
		bin0 = new Bin(st0, fiver);
		
		// by using ... varargs ctor, no need for creating and passing an array.
		bin1 = new Bin(st00, fiver);				
	}

	@Test
	public void testContains() {
		
		assertTrue(bin0.contains(new Proposition("Straight 0", 35)));
		
		assertTrue(bin1.contains(new Proposition("Straight 00", 35)));
		
		assertFalse(bin0.contains(new Proposition("Straight 00", 35)));
		
	}
}
