package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class ChangeOfHeart extends SpellCard{
	public ChangeOfHeart(String name,String description){
		super(name,description);
	}	
	public void action(MonsterCard monster){
		if((getBoard().getActivePlayer().getField().getMonstersArea().size())<5 && (getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty())!=true){
			removeFromOpponentPlayer(monster);
			addToActivePlayer(monster);
		}
			
		
	}
	public void removeFromOpponentPlayer(MonsterCard monster){
		getBoard().getOpponentPlayer().getField().getMonstersArea().remove(monster);
	}
	public void addToActivePlayer(MonsterCard monster){
		getBoard().getActivePlayer().getField().getMonstersArea().add(monster);
	}

}
