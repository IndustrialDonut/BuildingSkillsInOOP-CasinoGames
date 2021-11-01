package main;

public class Passenger57 extends Player {
	
	private Proposition black;

	public Passenger57(int rounds) {
		super(rounds);
		black = Proposition.getProposition("Black"); // is this returning null?
		if (black == null) {
			System.out.println("Passenger57 cannot get Black prop!!");
		}
	}

	@Override
	public Bet makeBet()  {
		return prepareBet(100, black);
	}
}
