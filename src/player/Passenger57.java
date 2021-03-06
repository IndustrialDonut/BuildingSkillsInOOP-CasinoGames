package player;

import java.util.Objects;

import main.Bet;
import main.Proposition;

public class Passenger57 extends Player {

	//public Passenger57(int rounds) {
	//	super(rounds);
	//}

	@Override
	public Bet makeBet()  {
		Proposition black = Proposition.getProposition("Black");
		Objects.requireNonNull(black);
		return prepareBet(100, black);
	}
}
