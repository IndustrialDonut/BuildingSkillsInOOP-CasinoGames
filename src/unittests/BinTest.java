package unittests;

import main.Proposition;
import main.Bin;

public class BinTest {

	public static void test() {
		
		Proposition st0 = new Proposition("Straight 0", 35);
		Proposition fiver = new Proposition("00 0 1 2 3", 6);
		Proposition st00 = new Proposition("Straight 00", 35);
		
		Proposition[] arr = {st0, fiver};
		Bin bin_zero = new Bin(arr);
		
		// by using ... varargs ctor, no need for creating and passing an array anymore like above!
		Bin bin_zerozero = new Bin(st00, fiver);
		
		print_bin(bin_zero);
		print_bin(bin_zerozero);				
	}
	
	private static void print_bin(Bin bin) {
		System.out.println(bin.toString() + " has " + bin.size() + " (and unique) entries.");	
	}
}
