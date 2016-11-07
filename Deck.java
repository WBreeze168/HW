import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	public int nUsed = 0;

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		usedCard = new ArrayList<Card>();
		for (int n = 0; n < nDeck; n++) {
			for (int x = 1; x < 5; x++) {
				for (int y = 1; y < 14; y++) {
					Card card;
					switch (x) {
					case 1:
						card = new Card(Card.Suit.Club, y);
						cards.add(card);
						break;
					case 2:
						card = new Card(Card.Suit.Diamond, y);
						cards.add(card);
						break;
					case 3:
						card = new Card(Card.Suit.Heart, y);
						cards.add(card);
						break;
					case 4:
						card = new Card(Card.Suit.Spade, y);
						cards.add(card);
						break;
					}
				}
			}
		}

	}

	public void printDeck() {
		for (Card pCard : cards) {
			pCard.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

	public void shuffle() {
		Random rnd = new Random();
		
		int last = cards.size();
		for(int i = 0; i < last; i++){
			Card tmp = cards.get(0);
			usedCard.add(tmp);
			cards.remove(tmp);
		}
		
		last = usedCard.size();
		for(int r,i = 0; i < last; i++){
			r = rnd.nextInt(usedCard.size());
			Card tmp = usedCard.get(r);
			cards.add(tmp);
			usedCard.remove(tmp);
		}
		
		nUsed = 0;
		

	}

	public Card getOneCard() {

		if (cards.isEmpty() == true) {
			shuffle();
		}
		Card tmp = cards.get(0);
		usedCard.add(tmp);
		cards.remove(tmp);
		nUsed++;
		return tmp;
	}
}