package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.WheelBuilder;
import random.MockRandom;
import main.Bin;
import main.Wheel;

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
