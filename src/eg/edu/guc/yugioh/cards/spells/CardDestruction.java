package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class CardDestruction extends SpellCard {
	public CardDestruction(String name,String description){
		super(name,description);
	}
   public void action(MonsterCard monster){
	   int x= getBoard().getActivePlayer().getField().getHand().size();
	   int y= getBoard().getOpponentPlayer().getField().getHand().size();
	   getBoard().getActivePlayer().getField().getHand().clear();
	   getBoard().getOpponentPlayer().getField().getHand().clear();
	   getBoard().getActivePlayer().getField().addNCardsToHand(x);
	   getBoard().getOpponentPlayer().getField().addNCardsToHand(y);
	   
	}
  
}
