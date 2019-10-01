package eg.edu.guc.yugioh.board.player;

import java.io.IOException;

public class Player {
	private String name;
	private int lifePoints;
	private Field field;
	
	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int diff) {
		this.lifePoints = lifePoints - diff;
	}

	public String getName() {
		return name;
	}

	public Field getField() {
		return field;
	}

	public Player(String name) throws IOException{
		this.name = name;
		lifePoints = 8000;
		field = new Field();
	}

}
