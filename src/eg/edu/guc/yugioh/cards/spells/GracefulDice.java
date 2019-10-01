package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard {
	public GracefulDice(String name,String description){
		super(name,description);
	}
	public void action(MonsterCard monster){
		int x = (int)(Math.random()*10+1)*100;
		if(getBoard().getActivePlayer().getField().getMonstersArea().isEmpty()!=true){
		ArrayList<MonsterCard> m = getBoard().getActivePlayer().getField().getMonstersArea();
		for(int i=0;i<m.size();i++){
			m.get(i).setAttackPoints(m.get(i).getAttackPoints()+x);
			m.get(i).setDefensePoints(m.get(i).getDefensePoints()+x);
		}
	}
  }
}
