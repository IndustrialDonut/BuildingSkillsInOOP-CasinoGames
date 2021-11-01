package random;

public class ConstRandom implements Randomlike {
	
	int val = 0;
	
	public ConstRandom(int value) {
		this.val = value;
	}

	@Override
	public int nextInt(int exclusiveTopBound) {
		return val;
	}

}
