package slave;

import java.util.Arrays;

public class Card {
	private int rank;
	private int suit;

	String[] point = { "0","A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	String[] kind = { "0","Club", "Diamond", "Heart", "Spade" };

	public Card(int rank, int suit) {
		if (rank >= 1 && rank <= 13) 
			this.rank = rank;
		else {
			this.rank = 1;
		}if (1 <= suit && suit <= 4)
				this.suit = suit;
		else {
			this.suit = 1;
		}
	}

	public int getSuit() {
		return this.suit;
	}

	public void setSuit(int suit) {
		if (suit > 4 || suit < 1)
			this.suit = 1;
		else {
			this.suit = suit;
		}
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		if (rank < 1 || rank > 13) {
			this.rank = 1;
		} else {
			this.rank = rank;
		}
	}

	public boolean isBiggerThan(Card card) {
		boolean result = false;
		if (this.rank == card.rank)
			result = true;
		else if (card.rank <= 2 && this.rank <= 2 && this.rank > card.rank)
			result = true;
		else if (card.rank >= 3 && (this.rank == 1 || this.rank == 2 || this.rank > card.rank))
			result = true;
		return result;
	}

	public String toString() {
		return "" + kind[this.getSuit()] + " " + point[this.getRank()];
	}
}
