package wheel;

import main.Bin;
import main.Proposition;

/**
 * Wheel has a collection of Bins, of which one will be randomly selected and returned with spin().
 * Constructed effectively with BinBuilder and used by the game.
 * @author DONUT
 *
 */
public class Wheel {
	
	private Bin[] bins = new Bin[38]; // 1-36 , 0, and 00, so 38 total
	
	private Randomlike rng;
	
	public Wheel(Randomlike rng, WheelBuilder builder) {
		
		this.rng = rng;
		
		for(int i = 0; i < bins.length; i++) {
			bins[i] = new Bin();
		}
		
		builder.buildWheelBins(this);
	}

	public void setNewRandom(Randomlike rng) {
		this.rng = rng;
	}
	
	/**
	 * BinBuilder uses this method to effectively construct the wheel object with all of the 
	 * Propositions it needs in all of its bins.
	 * @param index the number of the Bin on the roulette wheel, '00' is 37 though
	 * @param prop the Proposition reference to add to the Bin
	 */
	public void addBinProp(int index, Proposition ...prop) {
		for(Proposition p : prop) {
			bins[index].add(p);
		}
	}
	
	/**
	 * THE functionality method of Wheel, this returns the randomly selected Bin as if you spun a roulette wheel.
	 * @return
	 */
	public Bin spin() {
		return bins[rng.nextInt(38)];
	}
	
	public Bin getBin(int index) {
		assert(index >= 0 && index < 38);
		return bins[index];
	}

}
