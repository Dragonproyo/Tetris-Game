public class I_Block extends Blocks /*implements nextBlock */{
	
	public I_Block(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.blockType = BlockType.IBlock;
	}
	
	public I_Block(Orientation orientation) {
		this.orientation = orientation;
		this.blockType = BlockType.IBlock;
	}
	
	public I_Block() {
		this.orientation = Orientation.Down;
		this.blockType = BlockType.IBlock;
	}
	
	public void spawnBlock(String[][] screen, String fill) {
		switch (orientation) {	
			case Left: 
				screen[y][x] = fill;
				screen[y][x - 1] = fill;
				screen[y][x + 1] = fill;
				screen[y][x + 2] = fill;
				break;
				
			case Right:
				screen[y][x] = fill;
				screen[y][x - 1] = fill;
				screen[y][x + 1] = fill;
				screen[y][x + 2] = fill;
				break;
				
			case Down:
				screen[y][x] = fill;
				screen[y + 1][x] = fill;
				screen[y + 2][x] = fill;
				screen[y + 3][x] = fill;
				break;
		
			case Up:
				screen[y][x] = fill;
				screen[y + 1][x] = fill;
				screen[y + 2][x] = fill;
				screen[y + 3][x] = fill;
				break;
			
			default:
				System.out.println("I-Block Wrong!");
		}
	}
	
	public boolean moveable(String direction) {
		boolean valid = true;
		switch (direction) {
			case "Down":
				switch (orientation) {
					case Down:
					case Up:
						if (Screen.screen[y + 4][x] != "  ") {
							valid = false;
						}
						break;
					case Left:
					case Right:
						if (Screen.screen[y + 1][x] != "  " ||
						Screen.screen[y + 1][x - 1] != "  " ||
						Screen.screen[y + 1][x + 1] != "  " ||
						Screen.screen[y + 1][x + 2] != "  ") {
							valid = false;
						}
				}
				break;
					
			case "Right":
				switch (orientation) {
					case Down:
					case Up:
						if (Screen.screen[y][x + 1] != "  " ||
						Screen.screen[y + 1][x + 1] != "  " ||
						Screen.screen[y + 2][x + 1] != "  " ||
						Screen.screen[y + 3][x + 1] != "  ") {
							valid = false;
						}
						break;
					case Left:
					case Right:
						if (Screen.screen[y][x + 3] != "  ") {
							valid = false;
						}
						break;
				}
				break;
					
			case "Left":
				switch (orientation) {
				case Down:
				case Up:
					if (Screen.screen[y][x - 1] != "  " ||
					Screen.screen[y + 1][x - 1] != "  " ||
					Screen.screen[y + 2][x - 1] != "  " ||
					Screen.screen[y + 3][x - 1] != "  ") {
						valid = false;
					}
					break;
				case Left:
				case Right:
					if (Screen.screen[y][x - 2] != "  ") {
						valid = false;
					}
					break;
				}
				break;
			}
		return valid;
	}
	
	public boolean rotatable(String rotateDirection) {
		boolean value = true;
		
		switch (orientation) {
			case Down:					
			case Up:
				if (Screen.screen[y][x - 1] != "  " ||
					Screen.screen[y][x + 1] != "  " ||
					Screen.screen[y][x + 2] != "  ") {
					value = false;
				}
				break;
			
			case Left:				
			case Right:
				if (Screen.screen[y + 1][x] != "  " ||
				Screen.screen[y + 2][x] != "  " ||
				Screen.screen[y + 3][x] != "  ") {
					value = false;
				}
				break;
		}
		return value;
	}
	
	public void getNextBlock(String[][] screen, String fill) {
		screen[nextY][nextX] = fill;
		screen[nextY + 1][nextX] = fill;
		screen[nextY + 2][nextX] = fill;
		screen[nextY + 3][nextX] = fill;
	}
}
