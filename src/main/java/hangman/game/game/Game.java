package hangman.game.game;

import java.util.HashSet;
import java.util.Set;

import hangman.game.core.Config;
import hangman.game.core.Dictionary;
import hangman.game.core.InvalidCharacterException;
import hangman.game.core.Word;
import hangman.game.ui.UI;

public class Game {
	
	public void start(String[] args) {
		UI.print("--------------");
		UI.print(" HANGMAN GAME ");
		UI.print("--------------");
		UI.printNextLine();
		
		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();
		

		
		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
		if (args.length > 0) {
			Config.setMaxErrors(args[0]);
		}
		
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		UI.print("You have " + maxErrors + " Chances");
		
		UI.print("The word has " + word.size() + " letters");
		UI.printNextLine();
		
	while (true) {
		UI.print(word);
		UI.printNextLine();
		
		try {
			char c = UI.readChar("Insert a letter: ");
			
			if (usedChars.contains(c)) {
				throw new InvalidCharacterException("Word already used");
			}
			
			usedChars.add(c);
			
			if (word.hasChar(c)) {
				UI.print("Correct!");
			}
			else {
				errorCount++;
				if (errorCount < maxErrors) {
					UI.print("Wrong! You have " + (maxErrors - errorCount) + " more chances");
				}
				
			}
			
			UI.printNextLine();
			
			if (word.discovered()) {
				UI.print("CONGRATZ! You found the word: " + word.getOriginalWord());
				UI.print("Game Over");
				break;
			}
			
			if (maxErrors == errorCount) {
				UI.print("You Lose!");
				UI.print("The word was: " + word.getOriginalWord());
				UI.print("Game Over");
				break;
			}
			
			
		} catch (InvalidCharacterException e) {
			UI.print("Error: " + e.getMessage());
			UI.printNextLine();
			
		}
		
	}
		
		
		
		

		
	}

}
