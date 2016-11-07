import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ID:B0444144
 * Name:³\¶³µ¾
 */
public class HW {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("input N(deck of cards):");
		int nDeck = k.nextInt();
		Deck deck = new Deck(nDeck);

		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
		k.close();
	}

	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {

		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

class Deck {
	private ArrayList<Card> cards;

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		for (int n = 0; n < nDeck; n++) {
			for (int x = 1; x < 5; x++) {
				for (int y = 1; y < 14; y++) {
					Card card = new Card(x, y);
					cards.add(card);
				}
			}
		}

	}

	public void printDeck() {
		for(Card pCard:cards){
			pCard.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	public void printCard() {
		System.out.println(suit + "," + rank);
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
