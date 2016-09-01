package slave;

public class CardPile {

	private Card[] cards;

	public CardPile(Card[] cards) {
		this.cards = cards;
	}

	public Card[] getCards() {
		return cards;
	}

	public boolean canBePlacedOnTopOf(CardPile otherPile) {
		boolean result = false;
		if (this.cards.length - otherPile.cards.length == 2)
			result = true;
		else {
			if ((this.cards.length == otherPile.cards.length) && (this.getBiggestCardInThisPile().isBiggerThan(otherPile.getBiggestCardInThisPile())))
				result = true;
		}
		return result;
		}
	
	public Card getBiggestCardInThisPile() {
		Card biggest = cards[0];
		for (int i = 1; i < cards.length; i++) {
			int Ra = biggest.getRank();
			int Rb = cards[i].getRank();
			int Sa = biggest.getSuit();
			int Sb = cards[i].getSuit();
			if (Ra == Rb && Sb > Sa)
				biggest = cards[i];
			else if (Rb > Ra) {
				biggest = cards[i];
			}
		}
		return biggest;
	}

	public String toString() {
		String t = "";
		int tt = this.cards.length;
		for (int i = 0; i < tt; i++) {
			t = t + this.cards[i].toString();
			if(tt - 1 != i) 
				t = t + ", ";
		}
		return "[" + t + "]";
	}
}
