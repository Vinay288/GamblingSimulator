
public class GamblingSimulator {
	static final int GAMBLER_STAKE_EVERYDAY = 100;
	static final int GAMBLER_BET_FOR_EACH_GAME = 1;
	static final int GAMBLER_RESIGN_STAKE = (GAMBLER_STAKE_EVERYDAY * 50) / 100;

	public static void main(String[] args) {
		resignStakeFor20Days();
	}

	static int gamblerGame() {
		int outcomeOfGame = (int) (Math.random() * 2);
		return outcomeOfGame;

	}

	static int resignStakePerDay() {
		int totalAmountForDay = GAMBLER_STAKE_EVERYDAY;
		while (totalAmountForDay != GAMBLER_RESIGN_STAKE + GAMBLER_STAKE_EVERYDAY
				&& totalAmountForDay != GAMBLER_STAKE_EVERYDAY - GAMBLER_RESIGN_STAKE) {
			int outcome = gamblerGame();
			if (outcome == 1) {
				totalAmountForDay++;
			} else {
				totalAmountForDay--;
			}
		}
		return totalAmountForDay;
	}

	static void resignStakeFor20Days() {
		int totalAmount = GAMBLER_STAKE_EVERYDAY;
		int totalLoss = 0, totalWin = 0;
		for (int i = 0; i < 20; i++) {
			int totalAmountForDay = resignStakePerDay();
			if (totalAmountForDay < 100)
				totalLoss += GAMBLER_RESIGN_STAKE;
			else
				totalWin += GAMBLER_RESIGN_STAKE;
			totalAmount += totalAmountForDay;
			System.out.println("Resigning for the day with money " + totalAmountForDay);
		}
		System.out.println("Total win at the end of 20 days" + totalWin);
		System.out.println("Total loose at the end of 20 days" + totalLoss);
		System.out.println("Total amount at the end of 20 days" + totalAmount);
	}
}
