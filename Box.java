
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Box extends JPanel {
   private final int RECT_WIDTH = 40;
   private final int RECT_HEIGHT = RECT_WIDTH;
   private State state;
  
   
   public Box() {
	   this.state = State.EMPTY;
	   color(Color.LIGHT_GRAY);
	   super.setPreferredSize(new Dimension(RECT_WIDTH, RECT_HEIGHT));
	   super.setBorder(BorderFactory.createLineBorder(Color.black));
   }
   
   public void setState(State s) {
	   this.state = s;
	   Color col = null;
	   
	   if (s == State.FOOD) {
		   col = Color.YELLOW;
	   }
	   else if (s == State.SNAKE) {
		   col = Color.GREEN;
	   }
	   else {
		   col = Color.LIGHT_GRAY;
	   }
	   
	   color(col);
   }
   
   public State getState() {
	   return this.state;
   }
   
   public void color(Color col) {
	   super.setBackground(col);
   }
   
}
