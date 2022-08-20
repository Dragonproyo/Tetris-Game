public class O_Block extends Blocks {
	
	public O_Block(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.blockType = BlockType.OBlock;
	}
	
	public O_Block(Orientation orientation) {
		this.orientation = orientation;
		this.blockType = BlockType.OBlock;
	}
	
	public O_Block() {
		this.orientation = Orientation.Down;
		this.blockType = BlockType.OBlock;
	}
	
	public void spawnBlock(String[][] screen, String fill) {
		switch (orientation) {	
			default:
				screen[y][x] = fill;
				screen[y][x + 1] = fill;
				screen[y + 1][x] = fill;
				screen[y + 1][x + 1] = fill;
				break;
		}
	}
	
	public boolean moveable(String direction) {
		boolean valid = true;
		switch (direction) {
			case "Down":
				if (Screen.screen[y + 2][x] != "  " || 
				Screen.screen[y + 2][x + 1] != "  ") {
					valid = false;
				}
				break;
					
			case "Left":
				if (Screen.screen[y][x - 1] != "  " || 
				Screen.screen[y + 1][x - 1] != "  ") {
					valid = false;
				}
				break;
					
			case "Right":
				if (Screen.screen[y][x + 2] != "  " || 
				Screen.screen[y + 1][x + 2] != "  ") {
					valid = false;
				}
				break;
			}
		return valid;
	}
	
	public boolean rotatable(String rotateDirection) {
		boolean value = true;
		return value;
	}
}
