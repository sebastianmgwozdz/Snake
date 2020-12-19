import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Grid extends JPanel {
	private Box[][] grid;
	
	public Grid(int width, int height) {
		super();
		GridBagLayout layout = new GridBagLayout();
		super.setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		this.grid = new Box[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				c.gridx = j;
				c.gridy = i;
				Box b = new Box();
				super.add(b, c);
				grid[i][j] = b;
			}
		}
	}
	
	public Box[][] getGrid() {
		return this.grid;
	}
	
	
	
	
	
}
