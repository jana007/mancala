package mancala;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// create the menu and menuItems for the frame
public class MenuBar extends JMenuBar {
	
	private JMenu options; // display game options
	private JMenu quit; // quit the app
	private JMenuItem history; // display current game history
	private JMenuItem quitItem; // quit game
	private JMenuItem highScores; // list high scores
	private JMenuItem rules; // display rules
	protected static HighScoreHandler highScoreList = new HighScoreHandler(); // handler for high score list
	
	// create menu bar and menu items
	public MenuBar() {
		super();
		options = new JMenu("Options");
		quit = new JMenu("quit");
		
	//	add(file);
		add(options);
		add(quit);
		
		history =  new JMenuItem("Turn History");
		
		JTextArea textArea = new JTextArea( "No current History");
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);  
 	   // textArea.setWrapStyleWord(true); 
 	    scrollPane.setPreferredSize( new Dimension( 250, 500 ) );
		
		
		options.add(history);
		
		
		history.addActionListener(
				new ActionListener() {// anonymous inner class
			           // display new internal window
			           public void actionPerformed( ActionEvent event ) {
			              // create internal frame
			        	   textArea.setText( Game.getHistory() );
			        	   System.out.println(Game.getHistory());
			        	   JOptionPane.showMessageDialog(null, scrollPane, "Turn History",  
			        	                                          JOptionPane.PLAIN_MESSAGE);
			           } // end method actionPerformed
			        } // end anonymous inner class
		); // end call to addActionListener
		
		
		quitItem = new JMenuItem ("Quit" );
		
		quit.add(quitItem);
				
			    // set up listener for Picture Menu
		quitItem.addActionListener(
			       new ActionListener() {// anonymous inner class
			          // display new internal window
			          public void actionPerformed( ActionEvent event ) {
			             System.exit(0);
			          } // end method actionPerformed
			       } // end anonymous inner class
			     ); // end call to addActionListener
		
		highScores = new JMenuItem ("High Scores");
		options.add(highScores);
		
		highScores.addActionListener(
				new ActionListener() {// anonymous inner class
			           // display new internal window
			           public void actionPerformed( ActionEvent event ) {
			              // create internal frame
			        	   JTextArea scoreTextArea = new JTextArea( );
			        	   scoreTextArea.setEditable(false);
			       		   JScrollPane scorePane = new JScrollPane(scoreTextArea);  
			        	   // textArea.setWrapStyleWord(true); 
			       		   scorePane.setPreferredSize( new Dimension( 310, 500 ) );
			       		   MenuBar.highScoreList.sortScores();
						   MenuBar.highScoreList.saveHighScores();
			        	   scoreTextArea.setText( highScoreList.toString() );
			        	   JOptionPane.showMessageDialog(null, scorePane, "High Scores",  
			        	                                          JOptionPane.PLAIN_MESSAGE);
			        	   
			        	   
			           } // end method actionPerformed
			        } // end anonymous inner class
		); // end call to addActionListener
		
		rules = new JMenuItem ("Game Rules");

		
		rules.addActionListener(
				new ActionListener() {// anonymous inner class
			           // display new internal window
			           public void actionPerformed( ActionEvent event ) {
			              // create internal frame
			        	   JTextArea rulesText = new JTextArea();
			       		JScrollPane rulesPane = new JScrollPane(rulesText);  
			        	    textArea.setWrapStyleWord(true); 
			        	    scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			        	   String gameRules = 
								"\nThe Mancala 'board' is made up of two rows of six holes, or pits, each.\n" + 
								"\nFour pieces -- marbles or stones -- are placed in each of the 12 holes. The color of the pieces is irrelevant.\n"+
								"\nEach player has a 'store'. Player one's store is on the right, player two's store is on the left\n"+
								"\nPlayer one may only interact with the pits on the top of the board\n"+
								"\nPlayer two may only interact with the pits on the bottom of the board\n"+
								"\nThe game begins with one player picking up all of the pieces in any one of the holes on his side.\n"+
								"\nMoving clockwise, the player deposits one of the stones in each hole until the stones run out.\n"+
								"\nIf you run into your own store, deposit one piece in it. If you run into your opponent's store, skip it.\n"+
								"\nIf the last piece you drop is in your own store, you get a free turn.\n"+
								"\nThe game ends when all six spaces on one side of the Mancala board are empty.\n"+
								"\nThe player who still has pieces on their side of the board when the game ends captures all of those pieces.\n";
			        	   rulesText.setText( gameRules );
			        	   rulesText.setEditable(false);
			        	   System.out.println(gameRules);
			        	   JOptionPane.showMessageDialog(null, rulesPane, "Game Rules",  
			        	                                          JOptionPane.PLAIN_MESSAGE);
			        	   
			        	   
			           } // end method actionPerformed
			        } // end anonymous inner class
		); // end call to addActionListener
		
		options.add(rules);
		
	}
		
}

