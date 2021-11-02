package player;

import exceptions.InvalidBet;
import main.Bet;
import main.Proposition;
import main.Table;

public abstract class Player {
	//private int roundsToGo;
	
	protected Table table;
	protected int money = 2000;
	
	//public Player(int rounds) {
	//	this.roundsToGo = rounds;
	//}
	
	public abstract Bet makeBet();
	
	protected Bet prepareBet(int amount, Proposition prop) {
		assert(money - amount > 0);
		money -= amount;
		try {
			Bet bet = new Bet(amount, prop);
			return bet;
		} catch (InvalidBet e) {
			System.out.println("Bet could not even be CREATED!");
			e.printStackTrace();
		}
		return null;
	}
	
	public int getMoney() {
		return money;
	}
	
	public boolean isPlaying() {
		//if(roundsToGo > 0 && money > 0)
		if(money > 0)
			return true;
		else
			return false;
	}
	
	public void win(Bet bet) {
		// this bet by this player won, do logic to add money
		// WinReturn is inclusive of your bet + the profit on the bet
		money += bet.getWinReturn();// if you lose, you simply don't get the wager back
		//money += bet.getWager();
	}
	
	public void lose(Bet bet) {
		// this bet by this player lost, do logic to update betting strategy (money already deducted in placing bet)
	}
	
}
