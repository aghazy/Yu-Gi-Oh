package eg.edu.guc.yugioh.board;
import eg.edu.guc.yugioh.board.player.Player;

public class Board {
	private Player activePlayer;
	private Player opponentPlayer;
	private Player winner;

	public Board(){
		
	}
	
	public void whoStarts(Player p1, Player p2){
		int PlayerToStart = (int) (2*Math.random()) +1;
		if(PlayerToStart == 1){
			activePlayer = p1;
			opponentPlayer = p2;
		}
		else{
			activePlayer = p2;
			opponentPlayer = p1;
		}
	}

	public void startGame(Player p1, Player p2){
			p1.getField().addNCardsToHand(5);
			p2.getField().addNCardsToHand(5);
		whoStarts(p1, p2);
		activePlayer.getField().addCardToHand();
	}

	public void nextPlayer(){
		Player temp = activePlayer;
		activePlayer = opponentPlayer;
		opponentPlayer = temp;
		activePlayer.getField().addCardToHand();
		activePlayer.getField().setMonsterAdded(false);
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public Player getOpponentPlayer() {
		return opponentPlayer;
	}

	public Player getWinner() {
		return winner;
	}
}
