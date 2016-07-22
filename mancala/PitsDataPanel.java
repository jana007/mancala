package mancala;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PitsDataPanel extends JPanel {
	
   protected static Dimension boardDimension = new Dimension(830, 300);
   private static JLabel [] playerOneStoneCount;
   private static JLabel [] playerTwoStoneCount;
   
    public PitsDataPanel() {
    	super(new GridBagLayout());
    	
    	setOpaque(false);
    	this.setPreferredSize(boardDimension);
    	this.setMinimumSize(boardDimension);
    	
    	GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        
        playerOneStoneCount = new JLabel[6];
        playerTwoStoneCount = new JLabel[6];
    	
    	for ( int i = 0; i < 6; ++i ) {
    		playerOneStoneCount[i] = new JLabel("3", SwingConstants.CENTER);
    		playerTwoStoneCount[i] = new JLabel("3", SwingConstants.CENTER);
    		
    		c.gridy = 0;
    		add(playerOneStoneCount[i]);
    		c.gridy = 1;
    		add(playerTwoStoneCount[i]);
    		
    		c.gridx+=2;
	    		
	    }
    }
}