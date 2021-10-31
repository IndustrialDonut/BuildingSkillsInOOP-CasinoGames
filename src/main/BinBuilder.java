package main;

import java.util.Arrays;

/**
 * Helper class to build the Wheel properly, filling in all 38 bins with the proper selection of Propositions
 * that contain the number on the bin. It is just made separate since there is a lot of logic in here and it
 * is very particular to just building the bins. It keeps the Wheel cleaner and more focused on what it *does*,
 * vs how it is constructed.
 * @author DONUT
 *
 */
public class BinBuilder {

	//this array not used, it was just an idea
	//int[][] table1_36 = new int[12][3];
	
	public BinBuilder() {
		//for(int i = 0; i < table1_36.length; i++) {
			//for(int j = 0; j < table1_36[0].length; j++) {
			//	table1_36[i][j] = i * table1_36[0].length + j + 1;
			//}
		//}
	}
	
	public void buildWheelBins(Wheel wheel) {
		genTop5(wheel);
		genStraightBets(wheel);
		genLRSplits(wheel);
		genUDSplits(wheel);
		genStreets(wheel);
		genCorners(wheel);
		genLines(wheel);
		genDozens(wheel);
		genColumns(wheel);
		genEvenMoneys(wheel);
	}
	
	private void genTop5(Wheel wheel) {
		// this is the most 'special' single bet on numbers 0, 00, 1, 2, and 3
		// doesn't fit into the other algorithms
		Proposition temp = new Proposition("Top 5", 5);
		wheel.addBinProp(0, temp);
		wheel.addBinProp(37, temp);
	}
	
	private void genStraightBets(Wheel wheel) {
		for(int i = 0; i < 37; i++) {
			Proposition temp = new Proposition("Straight " + i, 35);
			wheel.addBinProp(i, temp);
		}
		Proposition zerozero = new Proposition("Straight 00", 35);
		wheel.addBinProp(37, zerozero);
	}
	
	private void genLRSplits(Wheel wheel) {
		// loop over the 'left two columns' and generate the left/right split bets for the whole table
		for(int i = 1; i < 37; i += 3) {
			Proposition temp = new Proposition("Split " + i + "-" + (i+1), 17);
			wheel.addBinProp(i, temp);
			wheel.addBinProp(i + 1, temp);
		}
		
		for(int i = 2; i < 37; i += 3) {
			Proposition temp = new Proposition("Split " + i + "-" + (i+1), 17);
			wheel.addBinProp(i, temp);
			wheel.addBinProp(i + 1, temp);
		}
	}
	
	private void genUDSplits(Wheel wheel) {
		for(int i = 1; i < 4; i++) {
			for(int j = 0; j < 11; j++) {
				Proposition temp = new Proposition("Split " + (3*j+i) + "-" + (3*j+i+3), 17);
				wheel.addBinProp(3*j+i, temp);
				wheel.addBinProp(3*j+i+3, temp);
			}
		}
	}
	
	private void genStreets(Wheel wheel) {
		for(int i = 1; i < 13; i++) {
			int first_in_row = 3*i - 2;
			Proposition temp = new Proposition("Street " + first_in_row 
					+ " " + (first_in_row + 1) 
					+ " " + (first_in_row + 2),
					11);
			wheel.addBinProp(first_in_row, temp);
			wheel.addBinProp(first_in_row + 1, temp);
			wheel.addBinProp(first_in_row + 2, temp);
		}
	}
	
	private void genCorners(Wheel wheel) {
		for(int j = 0; j < 2; j++) {
			for(int i = 1; i < 12; i++) {
				int first_in_row = 3*i - 2 + j;
				Proposition temp = new Proposition("Corner " 
						+ first_in_row
						+ " " + (first_in_row + 1)
						+ " " + (first_in_row + 3)
						+ " " + (first_in_row + 4),
						8);
				wheel.addBinProp(first_in_row, temp);
				wheel.addBinProp(first_in_row + 1, temp);
				wheel.addBinProp(first_in_row + 3, temp);
				wheel.addBinProp(first_in_row + 4, temp);
			}
		}
	}
	
	private void genLines(Wheel wheel) {
		for(int i = 0; i < 11; i++) {
			int first = i * 3 + 1;
			String str = "Line ";
			for(int j = 0; j < 6; j++) {
				str += first + j + " ";
			}
			Proposition temp = new Proposition(str, 5);
			for(int j = 0; j < 6; j++) {
				wheel.addBinProp(first + j, temp);
			}
		}
	}
	
	private void genDozens(Wheel wheel) {
		String str = "1st 12";
		Proposition first = new Proposition(str, 2);
		for(int j = 1; j < 13; j++) {
			wheel.addBinProp(j, first);
		}
		
		String str2 = "2nd 12";
		Proposition sec = new Proposition(str2, 2);
		for(int j = 13; j < 25; j++) {
			wheel.addBinProp(j, sec);
		}
		
		String str3 = "3rd 12";
		Proposition thr = new Proposition(str3, 2);
		for(int j = 25; j < 37; j++) {
			wheel.addBinProp(j, thr);
		}
	}
	
	private void genColumns(Wheel wheel) {
		for(int i = 0; i < 3; i++) {
			String str = "Column " + (i + 1);
			Proposition temp = new Proposition(str, 2);
			for(int j = 0; j < 12; j++) {
				wheel.addBinProp(1 + i + j*3, temp);
			}
		}
	}
	
	private void genEvenMoneys(Wheel wheel) {
		Proposition red = new Proposition("Red", 1);
		Proposition black = new Proposition("Black", 1);
		Proposition even = new Proposition("Even", 1);
		Proposition odd = new Proposition("Odd", 1);
		Proposition high = new Proposition("High", 1);
		Proposition low = new Proposition("Low", 1);
		
		int[] red_numbers = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
		for(int i = 1; i < 37; i++) {
			if(i < 19) {
				wheel.addBinProp(i, low);
			}
			else {
				wheel.addBinProp(i, high);
			}
			
			if(i % 2 == 0) {
				wheel.addBinProp(i, even);
			}
			else {
				wheel.addBinProp(i, odd);
			}
			
			if(Arrays.binarySearch(red_numbers, i) >= 0) {
				wheel.addBinProp(i, red);
			}
			else {
				wheel.addBinProp(i, black);
			}
		}
	}
	
}
