
public class GamblingSimulator {
	static final int GAMBLER_STAKE_EVERYDAY = 100;
	static final int GAMBLER_BET_FOR_EACH_GAME = 1;

	public static void main(String[] args) {
		gamblerBet();
	}

	static int gamblerGame() {
		int outcomeOfGame = (int) (Math.random() * 2);
		return outcomeOfGame;

	}

	static void gamblerBet() {
		int totalAmountForDay = GAMBLER_STAKE_EVERYDAY;
		int outcome = gamblerGame();

		if (outcome == 1) {
			totalAmountForDay++;
			System.out.println("win");
		} else {
			totalAmountForDay--;
			System.out.println("loose");
		}
	}
}
