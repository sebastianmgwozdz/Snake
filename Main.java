
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;  
public class Main {  
	public static void main(String[] args) {   
		JFrame f = new JFrame();
		Grid grid = new Grid(17, 17);
		
		f.add(grid);
		f.setSize(1000,1000);//400 width and 500 height  
		f.setVisible(true);//making the frame visible 
				
		Snake s = new Snake(0, 0, Direction.DOWN, grid.getGrid());
		
		f.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_DOWN) {
					s.setDir(Direction.DOWN);
				}
				else if (code == KeyEvent.VK_UP) {
					s.setDir(Direction.UP);
				}
				else if (code == KeyEvent.VK_LEFT) {
					s.setDir(Direction.LEFT);
				}
				else if (code == KeyEvent.VK_RIGHT) {
					s.setDir(Direction.RIGHT);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
		
		
		while (s.move(grid)) {
						
			try {
				Thread.sleep(65);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}  
	
	
	
	
}  