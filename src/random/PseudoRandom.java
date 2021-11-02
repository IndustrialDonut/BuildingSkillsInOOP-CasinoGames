package random;

import java.util.Random;

import wheel.Randomlike;

public class PseudoRandom implements Randomlike{
	
	private Random rng = new Random();

	@Override
	public int nextInt(int exclusiveTopBound) {
		// TODO Auto-generated method stub
		return rng.nextInt(exclusiveTopBound);
	}

}
