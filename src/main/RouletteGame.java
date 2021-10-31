package main;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.InvalidBet;
import unittests.BetTest;
import unittests.BinTest;
import unittests.PropositionTest;
import unittests.RouletteGameTest;
import unittests.TableTest;
import unittests.WheelTest;

// page 79/83 now PLAYER CLASS

public class RouletteGame {
	
	private Table table;
	private Wheel wheel;
	
	public RouletteGame(Wheel wheel, Table table) {
		this.wheel = wheel;
		this.table = table;
	}
	

	public static void main(String[] args) throws InvalidBet {
		//PropositionTest.test();
		//BinTest.test();
		//WheelTest.test();
		//WheelTest.test_with_BinBuilder();
		//System.out.println(Proposition.getProposition("Straight 00"));
		//BetTest.test();
		//TableTest.test();
		RouletteGameTest.test();
	}
	
	public void cycle(Player player) {
		if(player.playing()) {
			table.clearTableBets();
			
			Bet bet = player.makeBet();
			
			try {
				table.placeBet(bet);
			} catch (InvalidBet e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			matchBets(wheel.spin(), player);
		}
		else
			System.out.println("Player is not playing anymore.");
		
	}
	
	private void matchBets(Bin winning_bin, Player player) {
		Iterator<Bet> iter = table.getIterator();
		
		while(iter.hasNext()) {
			
			Bet player_bet = iter.next();
			
			if(winning_bin.contains(player_bet.getProposition())) {
				player.win(player_bet);
			}
			else {
				player.lose(player_bet);
			}
		}
	}
}
