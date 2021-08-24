
public class GamblingSimulator {
	static final int GAMBLER_STAKE_EVERYDAY = 100;
	static final int GAMBLER_BET_FOR_EACH_GAME = 1;
	static final int GAMBLER_50_PERCENT_STAKE=(GAMBLER_STAKE_EVERYDAY*50)/100;

	public static void main(String[] args) {
		int totalAmountForDay = GAMBLER_STAKE_EVERYDAY;
		while(totalAmountForDay!=GAMBLER_50_PERCENT_STAKE+GAMBLER_STAKE_EVERYDAY && totalAmountForDay!=GAMBLER_STAKE_EVERYDAY-GAMBLER_50_PERCENT_STAKE) {
		int outcome = gamblerGame();
		if (outcome == 1) {
			totalAmountForDay++;
		} else {
			totalAmountForDay--;
		}
		}
		System.out.println("Resigning for the day with money "+totalAmountForDay);
	}

	static int gamblerGame() {
		int outcomeOfGame = (int) (Math.random() * 2);
		return outcomeOfGame;

	}
}
