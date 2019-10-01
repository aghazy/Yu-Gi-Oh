package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Field {
	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea;
	private ArrayList<Card> hand;
	private ArrayList<Card> graveyard;
	private Deck deck;
	private boolean monsterAdded = false;

	public void setMonsterAdded(boolean monsterAdded) {
		this.monsterAdded = monsterAdded;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}

	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public Deck getDeck() {
		return deck;
	}

	public Field() throws IOException{
		monstersArea = new ArrayList<MonsterCard>();
		spellArea = new ArrayList<SpellCard>();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		deck = new Deck();
	}

	public void addMonsterToField(MonsterCard monster, Mode m, boolean isHidden){
		if(monstersArea.size() < 5)
			if(hand.remove(monster))
				monstersArea.add(monster);
	}

	public void addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices){
		int level = monster.getLevel();
		if(!monsterAdded){
			if(level <= 4)
				if(mode == Mode.DEFENSE)
					addMonsterToField(monster, mode,true);
				else
					addMonsterToField(monster, mode,false);
			else if(level<=6)
				if(sacrifices.size() == 1){
					removeMonsterToGraveyard(sacrifices);
					if(mode == Mode.DEFENSE)
						addMonsterToField(monster, mode,true);
					else
						addMonsterToField(monster, mode,false);
				}
				else if(sacrifices.size() == 2){
					removeMonsterToGraveyard(sacrifices);
					if(mode == Mode.DEFENSE)
						addMonsterToField(monster, mode,true);
					else
						addMonsterToField(monster, mode,false);
				}
		}
	}

	public void removeMonsterToGraveyard(MonsterCard monster){
		if(monstersArea.remove(monster))
			graveyard.add(monster);
	}

	public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters){
		while(!monsters.isEmpty()){
			MonsterCard temp = monsters.remove(0);
			if(monstersArea.remove(temp))
				graveyard.add(temp);
		}
	}

	public void addSpellToField(SpellCard action,MonsterCard monster, boolean hidden){
		if(spellArea.size() < 5)
			if(hand.remove(action))
				spellArea.add(action);
		if(!hidden){
			activateTheSpellCard(action, monster);
		}
	}

	private void activateTheSpellCard(SpellCard action, MonsterCard monster){
		switch(action.getName()){
		case "Card Destruction": CardDestruction.action(null);break;
		case "Change Of Heart": ChangeOfHeart.action(null);break;
		case "Dark Hole": DarkHole.action(null);break;
		case "Graceful Dice": GracefulDice.action(monster);break;
		case "Harpie's Feather Duster": HarpieFeatherDuster.action(null);break;
		case "Heavy Storm": HeavyStorm.action(null);break;
		case "Mage Power": MagePower.action(monster);break;
		case "Monster Reborn": MonsterReborn.action(null);break;
		case "Pot Of Greed": PotOfGreed.action(null);break;
		case "Raigeki": Raigeki.action(null);break;
		}
		if(!(action.equals("Mage Storm")))
			if(!(action.equals("Graceful Dice")))
				removeSpellToGraveyard(action);
	}

	public void activateSetSpell(SpellCard action, MonsterCard monster){
		action.setIsHidden(false);
		activateTheSpellCard(action, monster);
	}

	public void removeSpellToGraveyard(SpellCard spell){
		if(spellArea.remove(spell))
			graveyard.add(spell);
	}

	public void removeSpellToGraveyard(ArrayList<SpellCard> spells){
		while(!spells.isEmpty()){
			SpellCard temp = spells.remove(0);
			if(spellArea.remove(temp))
				graveyard.add(temp);
		}
	}

	public void addCardToHand(){
		hand.add(deck.drawOneCard());
	}

	public void addNCardsToHand(int n){
		hand.addAll(deck.drawNCards(n));
	}
}
