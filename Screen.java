
/*
 * Variables:
 * the actual screen
 * 
 * Functions:
 * check if the game is over
 * display screen
 * update screen
 * check if a line can be cleared
 * clear line
 * 
 */
public class Screen {
	
	static boolean gameOver = false;
	
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		Screen.gameOver = gameOver;
	}
	
	static String requirement = "|                    |";
	
	static int clearCount = 0;
	static int score = 0;
	
	static String full = "|::::::::::::::::::::|";
	
	static String[][] nextBlock = {
			{" ", "__", "__", "__", "__", "__", " "},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{"|", "  ", "  ", "  ", "  ", "  ", "|"},
			{" ", "‾‾", "‾‾", "‾‾", "‾‾", "‾‾", " "},
	};
	
	static String[][] screen = {
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {" ", "‾‾", "‾‾", "‾‾", "‾‾", "‾‾", "‾‾", "‾‾", "‾‾", "‾‾", "‾‾", " "},
			};
	
	public static void resetNext() {
		for (int i = 1; i < nextBlock.length - 1; i ++) {
			for (int j = 1; j < nextBlock[i].length - 1; j++) {
				nextBlock[i][j] = "  ";
			}
		}
	}
	
	static void displayScreen() {
		String read = "";
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				read = read + screen[i][j];
			}
			if (i < nextBlock.length) {
				for (int j = 1; j < nextBlock[i].length; j++) {
					read = read + nextBlock[i][j];
				}
			}
			read = read + "\n";
			
			
		}
		System.out.println(read);
	}
	
	static void displayNextBlocks() {
		displayNext();
		String read = "";
		for (int i = 0; i < nextBlock.length; i++) {
			for (int j = 0; j < nextBlock[0].length; j++) {
				read = read + nextBlock[i][j];
			}
			read = read + "\n";
		}
		//System.out.println(read);
	}
	
	static void clearAndDrop() {
		clearCount = 0;
		for (int k = 0; k < 4; k++) {
			for (int i = 14; i > 0; i--) {
				if (clearable(i)) {
					clearRow(i);
					clearCount++;
				}
			}
			dropRow();
		}
		switch (clearCount) {
			case 1:
				score = score + 40;
				break;
			case 2:
				score = score + 100;
				break;
			case 3:
				score = score + 300;
				break;
			case 4:
				score = score + 1200;
				break;
		}
	}
	
	static boolean clearable(int row) {
		boolean clear = false;
		String read = "";
		for (int j = 0; j < screen[row].length; j ++) {
			read = read + screen[row][j];
		}
		
		if (read.equals(full)) {
			clear = true;
		}
		return clear;
	}
	
	static void clearRow(int row) {
		for (int j = 1; j < screen[row].length - 1; j++) {
			screen[row][j] = "  ";
		}
	}
	
	static void dropRow() {
		String read;
		for (int i = 14; i > 0; i--) {
			read = "|";
			for (int j = 1; j < screen[i].length - 1; j++) {
				read = read + screen[i][j];
			}
			read = read + "|";

			if (read.equals(requirement)) {
				read = "|";
				if (i - 1 > 0) {
					for (int j = 1; j < screen[i].length - 1; j++) {
						read = read + screen[i - 1][j];
					}
					read = read + "|";
					if (!read.equals(requirement)) {
						for (int j = 1; j < screen[i].length - 1; j++) {
							screen[i][j] = screen[i - 1][j];
							screen[i - 1][j] = "  ";
						} 
					}
				}
			}
		}
	}
	
	static boolean checkGameOver() {
		String read = "";
		for (int i = 0; i < screen[0].length; i++) {
			read = read + screen[0][i];
		}
		if (read.contains("::")) {
			gameOver = true;
		}
		return gameOver;
	}
	
	public static void displayScore() {
		String read = " _______";
		//Top Score Box
		for (int i = 0; i < Integer.toString(score).length(); i++) {
			read = read + "_";
		}
		System.out.println(read);
		System.out.println("|Score: " + score + "|");
		
		read = read + "_";
		//Bottom score box
		read = " ‾‾‾‾‾‾‾";
		for (int i = 0; i < Integer.toString(score).length(); i++) {
			read = read + "‾";
		}
		System.out.println(read);

	}
	
	public static void displayNext() {
		resetNext();
		OOPGame.blocksList.get(1).getNextBlock(Screen.nextBlock, "::");

	}
	
}
