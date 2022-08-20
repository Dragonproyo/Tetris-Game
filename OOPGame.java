import java.util.Random;
import java.util.Scanner;


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
	

	public static void main(String[] args) {
						
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		
		I_Block iBlock = new I_Block();
		L_Block lBlock = new L_Block();
		J_Block jBlock = new J_Block();
		O_Block oBlock = new O_Block();
		S_Block sBlock = new S_Block();
		Z_Block zBlock = new Z_Block();
		T_Block tBlock = new T_Block();
		

		Blocks[] blocks = {iBlock, lBlock, jBlock, oBlock, sBlock, zBlock, tBlock};
		//Blocks block = blocks[rand.nextInt(blocks.length)];
		Blocks 	block = blocks[rand.nextInt(blocks.length)];
		String input;

		while (Screen.gameOver == false) {
			block = blocks[rand.nextInt(blocks.length)];
			//block = iBlock;
			block.spawnBlock(Screen.screen, "::");
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
				
				Screen.displayScreen();
				input = "";
				
				System.out.println(block.orientation);
			}
			block.reset();
			Screen.clearAndDrop();
			Screen.checkGameOver();
		}
		scanner.close();
		
	}
}
