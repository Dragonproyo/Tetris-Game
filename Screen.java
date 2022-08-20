
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
	
	static String full = "|::::::::::::::::::::|";
	
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
			 {"-", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "-"},
			};
	
	static void displayScreen() {
		String read = "";
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				read = read + screen[i][j];
			}
			read = read + "\n";
		}
		System.out.println(read);
	}
	
	static void clearAndDrop() {
		for (int k = 0; k < 4; k++) {
			for (int i = 14; i > 0; i--) {
				if (clearable(i)) {
					clearRow(i);				
				}
			}
			dropRow();
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

}
