package main;

public class Martingale extends Player{
	
	public Martingale(int rounds) {
		super(rounds);
	}

	private int betMultiple = 1;
	
	private Proposition black = Proposition.getProposition("Black");

	@Override
	public Bet makeBet(){
		return prepareBet(betMultiple, black);
	}
	
	@Override
	public void win(Bet bet) {
		super.win(bet);
		betMultiple = 1;
	}
	
	@Override
	public void lose(Bet bet) {
		super.lose(bet);
		betMultiple *= 2;
	}

}
