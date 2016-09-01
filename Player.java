package slave;

import slave.Utility;
import java.util.ArrayList;

public class Player {
	private String name;
	private boolean pass = false;
	private ArrayList<Card> cardsInHand = new ArrayList<Card>();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public ArrayList<Card> getCardsInHand() {
		return this.cardsInHand;
	}

	public void addCardToHand(Card card) {
		this.cardsInHand.add(card);
	}

	public void play(Field field) {
		ArrayList<CardPile> POP = Utility.generatePossibleCardPile(cardsInHand);
		boolean playornot = false;
		int sizee = POP.size();
		Card[] cards = new Card[0];
		CardPile least = new CardPile(cards);
		for (int i = sizee - 1; i >= 0; i -= 1) {
			CardPile cardPile = POP.get(i);
			if (field.getTopPile() == null || cardPile.canBePlacedOnTopOf(field.getTopPile())) {
				playornot = true;
				least = cardPile;
				break;
			}
		}

		if (playornot) {
			System.out.println(this.name + " plays " + least.toString());
			field.setTopPile(least);
			Card[] minCards = least.getCards();
			for (int j = 0; j < cardsInHand.size(); j++) {
				Card card = cardsInHand.get(j);
				for (int i = 0; i < minCards.length; i++) {
					if (card.getRank() == minCards[i].getRank() && card.getSuit() == minCards[i].getSuit()) {
						cardsInHand.remove(j);
						break;
					}
				}
			}
		} else {
			if (cardsInHand.size() != 0)
				System.out.println(this.name + " passes");
			else
				System.out.println(this.name + " passes with empty hand");
			this.pass = true;
		}
	}

	public boolean win() {
		if (cardsInHand.size() == 0) {
			return true;
		}
		return false;
		}
	}
