package slave;

public class Field {
	private CardPile topPile;

	public Field() {
		topPile = null;
	}

	public Field(CardPile topPile) {
		this.topPile = topPile;
	}

	public CardPile getTopPile() {
		return topPile;
	}

	public void setTopPile(CardPile topPile) {
		this.topPile = topPile;
	}

	public void clearField() {
		topPile = null;
	}
}
