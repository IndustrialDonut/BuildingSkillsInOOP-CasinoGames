package main;

public class Passenger57 extends Player {
	
	private Proposition black;

	public Passenger57(int rounds) {
		super(rounds);
		black = Proposition.getProposition("Black");
	}

	@Override
	public Bet makeBet()  {
		
		Bet black_bet = prepareBet(100, black);
		
		return black_bet;
		
	}
}
