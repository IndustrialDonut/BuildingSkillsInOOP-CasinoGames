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
public class Table {
	
	private int limit = 1200;
	private int minimum = 1;
	
	private ArrayList<Bet> bets = new ArrayList<Bet>();
	
	public void clearTableBets() {
		bets.clear();
	}
	
	public Iterator<Bet> getIterator(){
		return bets.iterator();
	}
	
	/**
	 * @deprecated
	 * @return
	 */
	public ArrayList<Bet> getBets(){
		return bets;
	}
	
	public void placeBet(Bet bet)  throws InvalidBet{
		if(bet.getWager() > limit || bet.getWager() < minimum) {
			throw new InvalidBet();
		}
		else {
			bets.add(bet);
		}
	}
	
	// this method is useless if an exception is just thrown upon an 
	// invalid bet being placed anyway.
	public boolean isValid() {
		for(Bet bet : bets) {
			if(bet.getWager() > limit || bet.getWager() < minimum)
				return false;
		}
		return true; 
	}

}
