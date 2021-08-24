
public class GamblingSimulator {
	static final int GAMBLER_STAKE_EVERYDAY = 100;
	static final int GAMBLER_BET_FOR_EACH_GAME = 1;
	static final int GAMBLER_RESIGN_STAKE = (GAMBLER_STAKE_EVERYDAY * 50) / 100;
	static final int TOTAL_DAYS = 20;
	static final int MONTH = 30;

	public static void main(String[] args) {

		gambleForOneYear();

	}

	static int gamblerGame() {

		int outcomeOfGame = (int) (Math.random() * 2);
		return outcomeOfGame;

	}

	static void resignStakePerDay() {

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
		System.out.println("Resigning for the day with money " + totalAmountForDay);
	}

	static void resignStakeFor20Days() {

		int totalAmount = GAMBLER_STAKE_EVERYDAY;
		int totalLoss = 0, totalWin = 0;

		for (int i = 0; i < TOTAL_DAYS; i++) {

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
			if (totalAmountForDay < 100)
				totalLoss += GAMBLER_RESIGN_STAKE;
			else
				totalWin += GAMBLER_RESIGN_STAKE;
			totalAmount += totalAmountForDay;
			System.out.println("Resigning for the day with money " + totalAmountForDay);
		}

		System.out.println("Total win at the end of 20 days " + totalWin);
		System.out.println("Total loose at the end of 20 days " + totalLoss);
		System.out.println("Total amount at the end of 20 days " + totalAmount);
	}

	static void gambleForOneYear() {
		int totalAmount = 0;
		int luckiestMonth = -1, unLuckiestMonth = -1, maxProfit = 0, maxLoss = Integer.MAX_VALUE;
		for (int j = 0; j < 12; j++) {
			int totalLoss = 0, totalWin = 0, totalWinDays = 0, totalLossDays = 0;
			for (int i = 0; i < MONTH; i++) {

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
				if (totalAmountForDay < 100) {
					totalLoss += GAMBLER_RESIGN_STAKE;
					totalLossDays++;
				} else {
					totalWin += GAMBLER_RESIGN_STAKE;
					totalWinDays++;
				}
				totalAmount += totalAmountForDay;
			}
			luckiestMonth = maxProfit >= totalWin ? luckiestMonth : j + 1;
			unLuckiestMonth = maxLoss >= totalLoss ? j+1 : unLuckiestMonth;
			maxProfit = maxProfit >= totalWin ? maxProfit : totalWin;
			maxLoss = maxLoss >= totalLoss ? totalLoss : maxLoss;

			System.out.println("month*********  " + (j + 1));
			System.out.println("Total number of days won in one month  " + totalWinDays);
			System.out.println("Total number of days lost in one month  " + totalLossDays);
			System.out.println("Total win at the end month " + totalWin);
			System.out.println("Total loose at the month " + totalLoss);
			System.out.println("Total amount at the month " + totalAmount);
		}
		System.out.println("Luckiest Month is " + luckiestMonth + "  profit he earned was " + maxProfit);
		System.out.println("UnLuckiest Month is " + unLuckiestMonth + "  loss was " + maxLoss);
	}
}
