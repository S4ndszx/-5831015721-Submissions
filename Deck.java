package slave;

import java.util.Random;

public class Deck {
	private int deckCount;
	private Card[] cards = new Card[52];
	
	public Deck() {
		deckCount = 52;
		for (int i = 1 ;i <= 4 ;i++) {
			for (int x = 1; x < 14 ; x++ ) {
				cards[(i-1) * 13 + (x-1)] = new Card(x,i);
			}
			}
		}
		
	public void shuffle() {
		for(int i = 0 ; i < 500 ; i++) {
			int a = Utility.random(0,deckCount-1);
			int b = Utility.random(0,deckCount-1);
			Card next = cards[a];
			cards[a] = cards[b];
			cards[b] = next;
		}
	}
	
	public Card deal() {
		return cards[--deckCount];
	}
	public int getDeckSize() {
		return deckCount;
	}
}