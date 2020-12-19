import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
		
		grid[y][x].setState(State.SNAKE);
		
		Random r = new Random();
		int randX = r.nextInt(grid[0].length - 1) + 1;
		int randY = r.nextInt(grid.length - 1) + 1;
		grid[randY][randX].setState(State.FOOD);
		
	}
	
	public boolean move(Grid g) {
		Box[][] grid = g.getGrid();
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
		
		Box rec = grid[y][x];
		
		List<Box> empty = g.getEmpty();
		
		State curr = rec.getState();
		
		if (curr == State.SNAKE) {
			return false;
		}
		else if (curr == State.FOOD) {
			eat(rec, empty);
		}
		else {
			Box end = tail.remove();
			end.setState(State.EMPTY);
			empty.add(end);
			
			
			rec.setState(State.SNAKE);
			empty.remove(rec);
			
			tail.addEnd(rec);
		}
	
		
		
		return true;
	}
	
	public void eat(Box rec, List<Box> empty) {
		rec.setState(State.SNAKE);
		tail.addEnd(rec);
		
		Random r = new Random();
		int rand = r.nextInt(empty.size());
		Box b = empty.remove(rand);
		b.setState(State.FOOD);
		
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
		if (vertical(this.dir) == vertical(dir)) {
			return;
		}
		
		this.dir = dir;
	}
	
	public boolean vertical(Direction d) {
		return d == Direction.DOWN || d == Direction.UP;
	}
	
	public LinkedList getTail() {
		return tail;
	}
	
	public void setTail(LinkedList tail) {
		this.tail = tail;
	}
}
