package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard{
	public MonsterReborn(String name,String description){
		super(name,description);
	}
	public void action(MonsterCard monster){
		MonsterCard s = HighestAttackingPower(getBoard().getActivePlayer().getField().getGraveyard());
		MonsterCard m= HighestAttackingPower(getBoard().getOpponentPlayer().getField().getGraveyard());
		if(s.getAttackPoints()>m.getAttackPoints())
			getBoard().getActivePlayer().getField().getMonstersArea().add(s);
		else
			getBoard().getActivePlayer().getField().getMonstersArea().add(m);
	}
	public MonsterCard HighestAttackingPower(ArrayList <Card> m){
		int j=0;
		ArrayList <MonsterCard> s = new ArrayList();
		for(int a=0;a < m.size();a++){
			if(m.get(a) instanceof MonsterCard){
				s.add(j,(MonsterCard)m.get(a));
				j++;
			}
		}
		int largestsofar= 0;
		int tempindex=0;
		for(int i=0;i<s.size();i++){
				if(s.get(i).getAttackPoints()>largestsofar)
				largestsofar=s.get(i).getAttackPoints();
			    tempindex=i;
		 }
		return s.get(tempindex);
	}

}
