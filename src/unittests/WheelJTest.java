package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import random.MockRandom;
import wheel.Wheel;
import wheel.WheelBuilder;
import main.Bin;

public class WheelJTest {
	
	private Wheel wheel;
	
	public WheelJTest() {
		wheel = new Wheel(new MockRandom(), new WheelBuilder());
	}

	@Test
	public void testSpin() {
		
		for(int i = 0; i < 38; i++) {
			Bin winning = wheel.spin();
			assertTrue(winning == wheel.getBin(i));
		}
		
	}

}
