package main;

import exceptions.InvalidBet;

public class Martingale extends Player{
	
	private int lossCount = 0;
	private int betMultiple = 1;
	
	private Proposition black = Proposition.getProposition("Black");

	@Override
	public Bet makeBet(){
		Bet bet = prepareBet(betMultiple, black);
		
		return bet;
	}
	
	@Override
	public void win(Bet bet) {
		super.win(bet);
		betMultiple = 1;
		lossCount = 0;
	}
	
	@Override
	public void lose(Bet bet) {
		super.lose(bet);
		lossCount++;
		betMultiple *= 2;
	}

}
