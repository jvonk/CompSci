/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		Deck[] cs = new Deck[3];
		cs[0] = new Deck(new String[] {"9", "1"}, new String[] {"Diamonds", "Clubs"}, new int[] {9, 1});
		cs[1] = new Deck(new String[] {"Jack"}, new String[] {"Spades"}, new int[] {10});
		cs[2] = new Deck(new String[] {"King"}, new String[] {"Clubs"}, new int[] {10});
		for (Deck c: cs) {
			System.out.println(c.deal());
			System.out.println(c.isEmpty());
			System.out.println(c+"\n");
		}
	}
}
