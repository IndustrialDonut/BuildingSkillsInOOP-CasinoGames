package main;

import exceptions.InvalidBet;

public abstract class Player {
	private int roundsToGo;
	
	protected Table table;
	protected int money = 2000;
	
	public abstract Bet makeBet();
	
	protected Bet prepareBet(int amount, Proposition prop) {
		assert(money - amount > 0);
		money -= amount;
		Bet bet = new Bet(amount, prop);
		return bet;
	}
	
	public int getMoneyLeft() {
		return money;
	}
	
	public boolean playing() {
		if(roundsToGo > 0 && money > 0)
			return true;
		else
			return false;
	}
	
	public void win(Bet bet) {
		// this bet by this player won, do logic to add money
		money += bet.winAmount();
		money += bet.getWager(); // if you lose, you simply don't get the wager back, which you invested in makeBets()
	}
	
	public void lose(Bet bet) {
		// this bet by this player lost, do logic to update betting strategy (money already deducted in placing bet)
	}
	
}
