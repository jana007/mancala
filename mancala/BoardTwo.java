package mancala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardTwo extends JPanel {
		
   private BoardGraphicsLabel boardGraphicsLabel = new BoardGraphicsLabel();
   protected static Dimension boardDimension = new Dimension(800, 500);
   
    public BoardTwo() {
    	super(new BorderLayout());
    	this.setSize(boardDimension);
    	
    	Box box = new Box(BoxLayout.Y_AXIS);
    			
        box.setSize((int)(boardDimension.getWidth() * 0.9),
    			(int)(boardDimension.getWidth() * 0.5)); 
        
        box.add(new JButton("hello"));
        
        add(box); // add background board label
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.GREEN);
        g.drawRect(500, 350, 20, 20);
    }

}