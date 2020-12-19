
public class Snake {
	private int x;
	private int y;
	private Direction dir;
	private LinkedList tail;
	
	public Snake(int x, int y, Direction dir, Box[][] grid) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		
		LinkedList tail = new LinkedList();
		tail.addEnd(grid[0][0]);
		this.tail = tail;
		
		grid[x][y].setState(State.SNAKE);
	}
	
	public boolean move(Box[][] grid) {
		switch (dir) {
			case DOWN: 
				y++;
				break;
			case UP: 
				y--;
				break;
			case LEFT: 
				x--;
				break;
			default: 
				x++;
				break;
		}
		
		if (x < 0) {
			x = grid[0].length - 1;
		}
		else if (x == grid[0].length) {
			x = 0;
		}
		else if (y < 0) {
			y = grid.length - 1;
		}
		else if (y == grid.length) {
			y = 0;
		}
	
		Box end = tail.remove();
		end.setState(State.EMPTY);
		
		Box rec = grid[y][x];
		rec.setState(State.SNAKE);
		
		tail.addEnd(rec);
		
		return true;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public LinkedList getTail() {
		return tail;
	}
	
	public void setTail(LinkedList tail) {
		this.tail = tail;
	}
}
