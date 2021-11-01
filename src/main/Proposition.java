package main;

import java.util.HashMap;

/**
 * Proposition is the "what" part of a Bet, not the "amount" part. A Bet is an amount bet on something, and
 * this is that thing. Alternative name was "Outcome," but that gave the wrong idea in my mind that when you 
 * spin the wheel, there's really just the outcome of the number that gets selected, but that corresponds to
 * multiple winning bets or *things*, those *things* in this program being called Propositions.
 * For example betting straight on the number 5, that is betting an amount on the Proposition of Straight 5.
 * <br>
 * <br>
 * This class has a static HashMap of all of the unique instances of possible propositions to be bet on in 
 * Roulette. This only has a getter and can be used by Player etc to associate a Proposition with a Bet,
 * or by the table or game to *compare* a winning bin's propositions with those belonging to the bets actually
 * placed on the table!
 * @author DONUT
 *
 */
public class Proposition {
	
	private String name;
	
	private int odds;
	
	private static HashMap<String, Proposition> map_of_props = new HashMap<String, Proposition>();
	
	public static Proposition getProposition(String name) {
		Proposition toReturn = map_of_props.get(name);
		if(toReturn == null) {
			System.out.println("Could not retrieve an instance of " + name);
			for(String key : map_of_props.keySet()) {
				System.out.println(key);
			}
			System.out.println("Proposition has " + map_of_props.size() + " props stored total");
		};
		return toReturn;
	}
	
	public Proposition(String name, int odds) {
		this.name = name;
		this.odds = odds;
		map_of_props.put(name, this);
		//System.out.println("Prop constructed, map size is " + map_of_props.size());
	}
	
	public int winnings_from_bet(int amount) {
		return amount * odds;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Proposition) {
			if (o.toString() == this.toString()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		return name + ' ' + '(' + odds + ":1)";
	}

}
