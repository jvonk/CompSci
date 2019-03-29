/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card[] cs = new Card[] {new Card("9", "Diamonds", 9), new Card("Jack", "Spades", 10), new Card("King", "Clubs", 10)};
		for (Card c: cs) {
			System.out.println(c.suit());
			System.out.println(c.rank());
			System.out.println(c.pointValue());
			System.out.println(c.matches(new Card("Jack", "Spades", 10)));
			System.out.println(c+"\n");
		}
	}
}
