package unittests;

import java.util.Random;

import main.WheelBuilder;
import main.Proposition;
import main.Wheel;

public class WheelTest {
	
	public static void test() {
		
		Random rng = new Random(1);
		Wheel wheel = new Wheel();
		wheel.setControlledRandom(1);
		
		System.out.print("Controlled random number sequence as follows: ");
		for(int i = 0; i < 10; i++) {
			System.out.print(rng.nextInt(38) + " ");
		}
		System.out.println();
		
		Proposition st0 = new Proposition("Straight 0", 35);
		Proposition fiver = new Proposition("00 0 1 2 3", 6);
		Proposition st00 = new Proposition("Straight 00", 35);
		
		wheel.addBinProp(0, st0, fiver);
		wheel.addBinProp(37, st00, fiver);
		
		for(int i = 0; i < 10; i++) {
			System.out.print(wheel.spin());
		}
		System.out.println(wheel.getBin(37));
		
	}
	
	public static void test_with_BinBuilder() {
		Random rng = new Random(1);
		Wheel wheel = new Wheel();
		wheel.setControlledRandom(1);
		System.out.print("Controlled random number sequence as follows: ");
		for(int i = 0; i < 10; i++) {
			System.out.print(rng.nextInt(38) + " ");
		}
		System.out.println();
		
		WheelBuilder builder = new WheelBuilder();
		builder.buildWheelBins(wheel);
		
		System.out.println(wheel.getBin(0));
		
		for(int i = 0; i < 10; i++) {
			System.out.println(wheel.spin());
		}
		System.out.println(wheel.getBin(37));
	}

}
