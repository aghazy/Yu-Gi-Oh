package eg.edu.guc.yugioh.cards;

public class MonsterCard  extends Card implements Cloneable{
private int level;
private int defensePoints;
private int attackPoints;
private Mode mode;
public int getLevel() {
	return level;
}

public int getDefensePoints() {
	return defensePoints;
}
public void setDefensePoints(int defensePoints) {
	this.defensePoints = defensePoints;
}
public int getAttackPoints() {
	return attackPoints;
}
public void setAttackPoints(int attackPoints) {
	this.attackPoints = attackPoints;
}
public Mode getMode() {
	return mode;
}
public void setMode(Mode mode) {
	this.mode = mode;
}
public MonsterCard(String name,String description,int level,int attack,int defence){
	super(name,description);
	this.level=level;
	this.attackPoints=attack;
	this.defensePoints=defence;
	mode=Mode.DEFENSE;
	}
public MonsterCard clone(){
	MonsterCard x = new MonsterCard(getName(),getDescription(),level,attackPoints,defensePoints);
	return x;
}

}
