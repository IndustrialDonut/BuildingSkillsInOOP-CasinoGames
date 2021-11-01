package main;

import exceptions.InvalidBet;

/**
 * The combination of an amount/wager and WHAT Proposition it is wagered on winning.
 * @author DONUT
 *
 */
public class Bet {
	
	private int wager;
	private Proposition prop;
	//private Player player;
	
	public Bet(int wager, Proposition prop) throws InvalidBet{
		if( wager <= 0) { 
			throw new InvalidBet();
		}
		if(prop == null) {
			throw new InvalidBet();
		}
		this.wager = wager;
		this.prop = prop;
	}
	
	// this was my idea of how to handle wins/losses, but I will follow book for now.
	
	//public int wagerReturn(Bin winning_bin) {
	//	if(winning_bin.contains(prop)) {
	//		return prop.winnings_from_bet(wager);
	//	}
	//	else {
	//		return -wager;
	//	}
	//}
	
	public Proposition getProposition() {
		return prop;
	}
	
	public int getWager() {
		return wager;
	}
	
	public int getWinReturn() {
		return prop.winnings_from_bet(wager) + wager;
	}
	
	@Override
	public String toString() {
		return wager + " " + prop.toString();
	}

}
