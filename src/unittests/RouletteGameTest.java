package unittests;

import main.Martingale;
import main.Passenger57;
import main.Player;
import main.RouletteGame;
import main.Table;
import main.Wheel;

public class RouletteGameTest {
	
	public static void test() {
		
		//Player player = new Passenger57();
		Player player = new Passenger57(10);
		RouletteGame game = new RouletteGame(new Wheel(), new Table());
		
		while(player.isPlaying()) {
			game.cycle(player);
			System.out.println(player.getMoneyLeft());
		}
	}

}
