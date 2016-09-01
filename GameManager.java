package slave;

public class GameManager {

	public static void main(String[] args) {

		Deck d = new Deck();
		d.shuffle();
		Field f = new Field();
		f.clearField();
		String lose = null;
		int no = 0;
		int pass = 0;
		int playable = 4;
		Player[] players = new Player[4];
		players[0] = new Player("Alice");
		players[1] = new Player("Bill");
		players[2] = new Player("Cain");
		players[3] = new Player("Doug");
		for (Player player : players) {
			int i = 1;
			while (true) {
				if (i == 14)
					break;
				player.addCardToHand(d.deal());
				i++;
			}
		}
		while (true) {
			playable = 4;
			pass = 0;
			if (players[no].isPass() == false)
				players[no].play(f);
			no++;
			if (no == 4)
				no -= 4;
			for (Player player : players) {
				if (player.win())
					playable--;
				if (player.isPass())
					pass++;
			}
			if (pass == 4) {
				System.out.println("All players declare" + " " + "PASS");
				pass -= 4;
				no = 0;
				f.clearField();
				for (Player player : players) {
					player.setPass(false);
				}
			}
			if (playable == 0) {
				System.out.println(lose + " is " + "a" + " SLAVE");
				break;
			}
			if (playable == 1) {
				for (Player player : players) {
					if (!player.win()) {
						lose = player.getName();
					}
				}
			}
		}
	}
}