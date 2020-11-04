package hangman.game.ui;

import java.util.Scanner;

import hangman.game.core.InvalidCharacterException;

public class UI {

 public static void print(Object object) {
	 System.out.println(object);
	}

 	public static void printNextLine() {
 		System.out.println();
 	}
 	
 	public static char readChar(String text) throws InvalidCharacterException {
 		
 		System.out.println(text + " ");
 		
 		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
 		String line = scanner.nextLine();
 		
 		if (line.trim().isEmpty()) {
 			throw new InvalidCharacterException("it's empty!");
 		}
 		
 		if (line.length() > 1) {
 			throw new InvalidCharacterException("Only one letter at a time!");
 		}
 		
 		char c = line.charAt(0);
 		
 		if (!Character.isLetter(c)) {
 			throw new InvalidCharacterException("Only letters are allowed!");
 		}
 		
 		return c;
 		
 	}
}
