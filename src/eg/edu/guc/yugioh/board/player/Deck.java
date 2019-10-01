package eg.edu.guc.yugioh.board.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Deck {
	private ArrayList<Card> monsters;
	private ArrayList<Card> spells;
	private ArrayList<Card> deck;
	private static Random randomGenerator;

	public Deck() throws IOException{
		monsters = loadCardsFromFile("Database-Monsters.csv");
		spells = loadCardsFromFile("Database-Spells.csv");
		buildDeck(monsters,spells);
		shuffleDeck();
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public ArrayList<Card> loadCardsFromFile(String path) throws IOException{
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		ArrayList<Card> temp = new ArrayList<Card>();
		while ((currentLine = br.readLine()) != null) {
			String [] str = currentLine.split(",");
			if(str[0].equals("Monster"))
				temp.add(new MonsterCard(str[1], str[2], Integer.parseInt(str[5]), Integer.parseInt(str[3]), Integer.parseInt(str[4])));
			else
				temp.add(new SpellCard(str[1], str[2]));
		}
		br.close();
		return temp;
	}

	private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells) throws IOException{
		this.monsters = monsters;
		this.spells = spells;
		ArrayList<Card> newdeck = new ArrayList<Card>();
		for(int i = 0; i<15; i++){
			int index = randomGenerator.nextInt(monsters.size());
			MonsterCard clone = ((MonsterCard) monsters.get(index)).clone();
			newdeck.add(clone);
		}
		for(int j = 0; j<5; j++){
			int index = randomGenerator.nextInt(spells.size());
			SpellCard clone = ((SpellCard) spells.get(index)).clone();
			newdeck.add(clone);
		}
		this.deck = newdeck;
	}

	private void shuffleDeck (){
		Collections.shuffle(deck);
	}

	public ArrayList<Card> drawNCards(int n){
		ArrayList<Card> cardsList = new ArrayList<Card>();
		for(int i = 0; i<n; i++){
			if(!deck.isEmpty())
				cardsList.add(deck.remove(0));
		}
		return cardsList;
	}

	public Card drawOneCard(){
		Card card = null;
		if(!deck.isEmpty())
			card = deck.remove(0);
		return card;
	}
}
