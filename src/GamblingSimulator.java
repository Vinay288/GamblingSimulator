
public class GamblingSimulator {
	static final int GAMBLER_STAKE_EVERYDAY = 100;
	static final int GAMBLER_BET_FOR_EACH_GAME = 1 ;
	public static void main(String[] args) {
		int outcome = gamblerGame();
		
		if(outcome==1)
			System.out.println("win");
		else
			System.out.println("loose");
	}
	static int gamblerGame() {
		int outcomeOfGame=(int)(Math.random()*2);
		System.out.println(outcomeOfGame);
		return outcomeOfGame;
		
	}
}
