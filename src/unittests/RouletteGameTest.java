package unittests;

import main.Martingale;
import main.Passenger57;
import main.Player;
import main.RouletteGame;
import main.Table;
import main.Wheel;

public class RouletteGameTest {
	
	public static void test() {
		
		// AS IT IS THIS MUST BE CONSTRUCTED FIRST BEFORE THE PLAYER!
		// because the bins and props are constructed with the wheel or something
		// with the binbuilder class.
		RouletteGame game = new RouletteGame(new Wheel(), new Table());
		
		//Player player = new Passenger57();
		Player player = new Passenger57(10);
		
		while(player.isPlaying()) {
			game.cycle(player);
			System.out.println(player.getMoney());
		}
	}

}
