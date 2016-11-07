public class Card {
	enum Suit { Club, Diamond, Heart, Spade} // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
	// Spades=4
	private Suit suit;
	private int rank; // 1~13

	public Card(Suit s, int r) {
		suit = s;
		rank = r;
	}

	public void printCard() {
		System.out.println(suit + " " + rank);
	}

	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}