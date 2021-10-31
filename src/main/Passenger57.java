package main;

import exceptions.InvalidBet;

public class Passenger57 extends Player {
	
	private Proposition black;

	public Passenger57() {
		black = Proposition.getProposition("Black");
	}

	@Override
	public Bet makeBet()  {
		
		Bet black_bet = prepareBet(100, black);
		
		return black_bet;
		
	}

}
