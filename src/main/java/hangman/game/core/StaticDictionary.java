package hangman.game.core;

import java.util.List;

public class StaticDictionary extends Dictionary {
	
	private List<String> words = List.of("house", "computer", "pen", "car");
	private int currentIndex = -1;

	@Override
	public Word nextWord() {
		currentIndex = (currentIndex + 1) %words.size();
		return new Word(words.get(currentIndex));
	}

	@Override
	public String getGame() {
		return "Static";
	}

}
