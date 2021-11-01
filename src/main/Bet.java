package main;

import java.util.Objects;

import exceptions.InvalidBet;

/**
 * The combination of an amount/wager and WHAT Proposition it is wagered on winning.
 * @author DONUT
 *
 */
public class Bet {
	
	private int wager;
	private Proposition prop;
	
	public Bet(int wager, Proposition prop) throws InvalidBet{
		if( wager <= 0) { 
			throw new InvalidBet();
		}
		this.wager = wager;
		this.prop = Objects.requireNonNull(prop, "Proposition cannot be null in Bet construction!");
	}
	
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
