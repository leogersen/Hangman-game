package hangman.game.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hangman.game.game.GameException;
import hangman.game.utils.RandomUtils;

public class FileDictionary extends Dictionary {

	private static String FILE_NAME = "dictionary.txt";
	
	private List<String> words = new ArrayList<>();

	
	
	public FileDictionary() {
		load();
	}
	
	
	
		private void load() {
		
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
			
			while(scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();	
				words.add(word);
				
			}
			
			if(words.size() == 0) {
				throw new GameException("The word list cannot be empty");
				
			}
			
		}
		
	}
	@Override
	public Word nextWord() {
		int pos = RandomUtils.newRandomNumber(0, words.size());
		return new Word(words.get(pos));
	}



	@Override
	public String getGame() {
		return "Arquivo:  " + FILE_NAME;
	}
	

	
}
