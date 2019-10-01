package eg.edu.guc.yugioh.cards.spells;

public class SpellCard extends eg.edu.guc.yugioh.cards.Card implements Cloneable{
	
	public SpellCard(String name,String description){
		super(name,description);
	}
	public SpellCard clone(){
		SpellCard x = new SpellCard(getName(),getDescription());
		return x;
		
	}

}
