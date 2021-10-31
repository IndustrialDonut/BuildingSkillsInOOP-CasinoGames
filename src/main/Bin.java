package main;

import java.util.HashSet;
import java.util.Arrays;

/**
 * A Bin is used by the Wheel to represent each of the 38 possible slots the ball can fall into in Roulette.
 * These contain Propositions which would win if that Bin caught the ball from the spin of the wheel.
 * @author DONUT
 *
 */
public class Bin extends HashSet<Proposition>{ // perhaps could be inner class of Wheel
	
	
	public Bin() {
		super();
	}
	
	public Bin(Proposition ... prop) {
		super(Arrays.asList(prop));
	}
}
