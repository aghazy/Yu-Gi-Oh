package eg.edu.guc.yugioh.cards;
import eg.edu.guc.yugioh.board.Board;

public class Card {
private String name;
private String description;
private boolean isHidden;
private Location location;
private enum Location{DECK, HAND, FIELD, GRAVEYARD
  }
private static Board board;	
public Card(String name,String description){
	this.name=name;
	this.description=description;
	isHidden=false;
	location=Location.DECK;
	}
public void action(MonsterCard monster){
	}
public String getDescription() {
	return description; 
  }

public boolean getIsHidden() {
	return isHidden;
}
public void setIsHidden(boolean isHidden) {
	this.isHidden = isHidden;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
}
public Board getBoard() {
	return board;
}
public void setBoard(Board board) {
	this.board = board;
}
public String getName() {
	return name;
 }
}

