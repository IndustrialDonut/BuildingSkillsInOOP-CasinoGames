package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Passenger57;
import main.Player;
import main.RouletteGame;
import main.Table;
import main.Wheel;
import main.WheelBuilder;
import random.ConstRandom;
import random.MockRandom;
import random.PseudoRandom;

public class RouletteGameJTest {

	@Test
	public void testRouletteGame() {
		
		RouletteGame game = makeGame();
		
		Player player = new Passenger57();
		
		int winsCount =  0;
		
		for(int i = 0; i < 38; i++) {
				
			int start = player.getMoney();
			
			game.cycle(player);
			
			if(player.getMoney() > start) {
				winsCount++;
			}
		}
		assertEquals(18, winsCount);
	}
	
	private RouletteGame makeGame() {
		return new RouletteGame(
				new Wheel(
						new MockRandom(),
						//new ConstRandom(x), 
						new WheelBuilder()), 
				new Table()
				);
	}

}
