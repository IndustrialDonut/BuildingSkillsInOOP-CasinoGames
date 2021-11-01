package main;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.InvalidBet;

/**
 * Table holds Bet objects placed by Player(s).
 * Table regulates betting minimums and maximums when a bet is placed.
 * Is the interface of Player to playing Roulette.
 * @author DONUT
 *
 */
public class Table implements Iterable<Bet>{
	
	private int limit = 1200;
	private int minimum = 1;
	
	private ArrayList<Bet> bets = new ArrayList<Bet>();
	
	public void clearTableBets() {
		bets.clear();
	}
	
	public void placeBet(Bet bet)  throws InvalidBet{
		if(bet.getWager() > limit || bet.getWager() < minimum) {
			throw new InvalidBet();
		}
		else {
			bets.add(bet);
		}
	}
	
	public int getTableLimit() {
		return limit;
	}
	
	public int getTableMinimum() {
		return minimum;
	}

	@Override
	public Iterator<Bet> iterator() {
		return bets.iterator();
	}
	
	public int getBetsCount() {
		return bets.size();
	}

}
