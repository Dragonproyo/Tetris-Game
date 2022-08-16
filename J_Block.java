public class J_Block extends Blocks {
	
	public J_Block(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.blockType = BlockType.ZBlock;
	}
	
	public J_Block(Orientation orientation) {
		this.orientation = orientation;
		this.blockType = BlockType.ZBlock;
	}
	
	public J_Block() {
		this.orientation = Orientation.Up;
		this.blockType = BlockType.ZBlock;
	}
	
	public void spawnBlock(String[][] screen, String fill) {
		switch (orientation) {
			case Left: 
				screen[y][x - 1] = fill;
				screen[y + 1][x - 1] = fill;
				screen[y + 1][x] = fill;
				screen[y + 1][x + 1] = fill;
				break;
				
			case Right:
				screen[y][x] = fill;
				screen[y + 1][x + 1] = fill;
				screen[y][x - 1] = fill;
				screen[y][x + 1] = fill;
				break;
				
			case Up:
				screen[y][x] = fill;
				screen[y][x + 1] = fill;
				screen[y + 1][x] = fill;
				screen[y + 2][x] = fill;
				break;
				
			case Down:
				screen[y][x] = fill;
				screen[y + 1][x] = fill;
				screen[y + 2][x] = fill;
				screen[y + 2][x - 1] = fill;
				break;
			default:
				System.out.println("J-Block Wrong!");
		}
		
	}
	
	public boolean moveable(String direction) {
		boolean valid = true;
		switch (direction) {
			case "Down":
				switch (orientation) {
					case Down:
						if (Screen.screen[y + 3][x] != "  " ||
						Screen.screen[y + 3][x - 1] != "  ") {
							valid = false;
						}
						break;
						
					case Up:
						if (Screen.screen[y + 1][x + 1] != "  " ||
						Screen.screen[y + 3][x] != "  ") {
							valid = false;
						}
						break;
					
					case Left:
						if (Screen.screen[y + 2][x - 1] != "  " ||
						Screen.screen[y + 2][x] != "  " ||
						Screen.screen[y + 2][x + 1] != "  ") {
							valid = false;
						}
						break;
						
					case Right:
						if (Screen.screen[y + 1][x] != "  " ||
						Screen.screen[y + 2][x + 1] != "  " ||
						Screen.screen[y + 1][x - 1] != "  ") {
							valid = false;
						}
						break;
				}
				break;
					
			case "Left":
				switch (orientation) {
					case Down:
						if (Screen.screen[y][x - 1] != "  " ||
						Screen.screen[y + 1][x - 1] != "  " ||
						Screen.screen[y + 2][x - 2] != "  ") {
							valid = false;
						}
						break;
						
					case Up:
						if (Screen.screen[y][x - 1] != "  " ||
						Screen.screen[y + 1][x - 1] != "  " ||
						Screen.screen[y + 2][x - 1] != "  ") {
							valid = false;
						}
						break;
					
					case Left:
						if (Screen.screen[y][x - 2] != "  " ||
						Screen.screen[y + 1][x - 2] != "  ") {
							valid = false;
						}
						break;
						
					case Right:
						if (Screen.screen[y][x - 2] != "  " ||
							Screen.screen[y + 1][x] != "  ") {
							valid = false;
						}
						break;
				}
				break;
					
			case "Right":
				switch (orientation) {
					case Down:
						if (Screen.screen[y][x + 1] != "  " ||
						Screen.screen[y + 1][x + 1] != "  " ||
						Screen.screen[y + 2][x + 1] != "  ") {
							valid = false;
						}
						break;
						
					case Up:
						if (Screen.screen[y][x + 2] != "  " ||
						Screen.screen[y + 1][x + 1] != "  " ||
						Screen.screen[y + 2][x + 1] != "  ") {
							valid = false;
						}
						break;
					
					case Left:
						if (Screen.screen[y][x] != "  " ||
						Screen.screen[y + 1][x + 2] != "  ") {
							valid = false;
						}
						break;
						
					case Right:
						if (Screen.screen[y][x + 2] != "  " ||
						Screen.screen[y + 1][x + 2] != "  ") {
						valid = false;
						}
						break;
				}
				break;
			}
		return valid;
	}

	public void rotateClockwise() {
		
	}
	
	public void rotateCounterClockwise() {
		
	}
	
	public boolean rotatable(String rotateDirection) {
		boolean value = true;
		return value;
	}
}
