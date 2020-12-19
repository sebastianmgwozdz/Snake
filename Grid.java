import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JPanel;

public class Grid extends JPanel {
	private Box[][] grid;
	private List<Box> empty;
	
	public Grid(int width, int height) {
		super();
		GridBagLayout layout = new GridBagLayout();
		super.setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		this.grid = new Box[height][width];
		this.empty = new ArrayList<>();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				c.gridx = j;
				c.gridy = i;
				Box b = new Box();
				super.add(b, c);
				grid[i][j] = b;
				empty.add(b);

			}
		}
	}
	
	public Box[][] getGrid() {
		return this.grid;
	}

	public List<Box> getEmpty() {
		return empty;
	}

	public void setEmpty(List<Box> empty) {
		this.empty = empty;
	}

}
