package random;

public class MockRandom implements Randomlike{
	
	private int count = 0;

	@Override
	public int nextInt(int exclusiveTopBound) {
		
		if(count > 38)
			count = 0;
		
		return count++;
	}

}