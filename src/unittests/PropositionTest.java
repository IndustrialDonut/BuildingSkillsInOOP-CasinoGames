package unittests;
import main.Proposition;

public class PropositionTest {

	
	public static void test() {
		Proposition one = new Proposition("Straight 5", 35);
		Proposition two = new Proposition("Split 3-6", 17);
		Proposition three = new Proposition("Straight 5", 35);
		
		assert(one.equals(three));
		assert(! one.equals(two));
		assert(! three.equals(two));
		
		assert(one.hashCode() == three.hashCode());
		assert(! (one.hashCode() == two.hashCode()));
		
		print_win(one, 100);
		print_win(one, 1259);
		print_win(two, 9812);
		print_win(three, 777);
		
		System.out.println("PropositionTest passed successfully if no errors, given that assertions are enabled with -ea !");
	}
	
	static private void print_win(Proposition prop, int bet) {
		int win = prop.winnings_from_bet(bet);
		System.out.println(prop.toString() + " betting " + bet + ", won " + win);
	}
}
