package main;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.InvalidBet;

// page 79/83 now PLAYER CLASS

public class RouletteGame {
	
	private Table table;
	private Wheel wheel;
	
	public RouletteGame(Wheel wheel, Table table) {
		this.wheel = wheel;
		this.table = table;
	}
	
	public void cycle(Player player) {
		if(player.isPlaying()) {
			table.clearTableBets();
			
			playerPlaceBet(player);
			
			matchBets(wheel.spin(), player);
		}
		else
			System.out.println("Player is not playing anymore.");
	}
	
	private void playerPlaceBet(Player player) {
		Bet bet = player.makeBet();
		
		try {
			table.placeBet(bet);
		} catch (InvalidBet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void matchBets(Bin winning_bin, Player player) {
		
		System.out.println(winning_bin.toString());
		
		for(Bet player_bet : table) {
			
			if(winning_bin.contains(player_bet.getProposition())) {
				player.win(player_bet);
				System.out.println(player.toString() + " won");
			}
			else {
				System.out.println(player.toString() + " lost");
				player.lose(player_bet);
			}
		}
	}
}
