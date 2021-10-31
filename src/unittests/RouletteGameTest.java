package unittests;

import main.Passenger57;
import main.Player;
import main.RouletteGame;
import main.Table;
import main.Wheel;

public class RouletteGameTest {
	
	public static void test() {
		
		Player player = new Passenger57();
		RouletteGame game = new RouletteGame(new Wheel(), new Table());
		
		for(int i = 0; i < 15; i++) {
			game.cycle(player);
			System.out.println(player.getMoneyLeft());
		}
	}

}
