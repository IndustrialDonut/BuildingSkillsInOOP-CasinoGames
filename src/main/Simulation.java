package main;

import random.PseudoRandom;

public class Simulation {
	
	public static void test() {
		
		// AS IT IS THIS MUST BE CONSTRUCTED FIRST BEFORE THE PLAYER!
		// because the bins and props are constructed with the wheel or something
		// with the binbuilder class.
		RouletteGame game = new RouletteGame(new Wheel(new PseudoRandom(), new WheelBuilder()), new Table());
		
		Player player = new Passenger57();
		
		while(player.isPlaying()) {
			game.cycle(player);
		}
	}

}
