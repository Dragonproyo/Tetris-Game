import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class OOPGame {
	
	/*
	 * How the game will work:
	 * 1. Display a clear screen
	 * 2. Generate a random block and put it on the top of the screen.
	 * 3. Constantly move it down until it hits something (the bottom of the screen / another block)
	 * 4. Constantly check for user inputs for moving and rotating the block left and right.
	 * 5. Repeat until a block cannot spawn anymore.
	 * 
	 */
	static Random rand = new Random();
	static Scanner scanner = new Scanner(System.in);
	
	static I_Block iBlock = new I_Block();
	static L_Block lBlock = new L_Block();
	static J_Block jBlock = new J_Block();
	static O_Block oBlock = new O_Block();
	static S_Block sBlock = new S_Block();
	static Z_Block zBlock = new Z_Block();
	static T_Block tBlock = new T_Block();
	static ArrayList<Blocks> blocksList = new ArrayList<Blocks>();

	static Blocks[] blocks = {iBlock, lBlock, jBlock, oBlock, sBlock, zBlock, tBlock};
	static Blocks block;
	
	static void nextBlock() {
		blocksList.set(0, blocksList.get(1));
		blocksList.set(1, blocksList.get(2));
		blocksList.set(2, blocksList.get(3));
		blocksList.set(3, blocks[rand.nextInt(blocks.length)]);
	}
	
	/*
	 * static void displayNext() {
		System.out.println(blocksList.get(0));
		System.out.println(blocksList.get(1));
		System.out.println(blocksList.get(2));
	}
	 */
	

	public static void main(String[] args) {
		
		String input;
		Screen.displayScore();
		for (int i = 0; i < 4; i++) {
			blocksList.add(blocks[rand.nextInt(blocks.length)]);
		}

		while (Screen.gameOver == false) {
			block = blocksList.get(0);
			block.spawnBlock(Screen.screen, "::");
			Screen.displayNextBlocks();
			Screen.displayScreen();
			
			while (block.moveable("Down")) {
				input = scanner.nextLine();
				
				block.move("Down");

				if (input.equals("a") && block.moveable("Left")) {
					block.move("Left");
				}
				
				if (input.equals("d") && block.moveable("Right")) {
					block.move("Right");
				}
				
				if (input.equals("x") && block.rotatable("Counter Clockwise")) {
					block.rotateCounterClockwise();

				}
				
				if (input.equals("c") && block.rotatable("Clockwise")) {
					block.rotateClockwise();
				}
				
				Screen.displayScore();
				Screen.displayScreen();
				input = "";
			}
			nextBlock();
			block.reset();
			Screen.clearAndDrop();
			Screen.checkGameOver();
		}
		scanner.close();
		
		System.out.println("Game Over!");
		System.out.println("Final Score: " + Integer.toString(Screen.score));
		
		
	}
	
}
