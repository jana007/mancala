package mancala;

import javax.swing.JOptionPane;

public class Game {

	public static int turn;
	public static boolean anotherTurn;
	public static int validStartIndex; // default at zero
	
	public  Game() {
		
		turn = 0;
		anotherTurn = true;
		validStartIndex = 0;
		
	}
	
	// This 
	public static boolean playTurn ( int index, int stone ) {
		
		if ( Game.checkIndex( index )  && stone > 0 ) { // make sure pit has more than 0 stones
														// so user turn won't switch on empty pit
				
			for ( int i = 1, nextIndex = index + 1; stone > 0; ++i, ++nextIndex, --stone ) {
				System.out.println(" i = " + i + " nextIndex = " + nextIndex);
				
				
				 if (  nextIndex  >= 12 ) {

					if ( validStartIndex == 6 ) {
						PitsGraphicsPanel.playerPitTwo.incrementStoneCount();
						stone--;
						Game.anotherTurn = true;
					}
					
					nextIndex =  0 ;
					
				 } else if ( nextIndex  == 6 ) {

						if ( validStartIndex == 0 ) {
							PitsGraphicsPanel.playerPitOne.incrementStoneCount();
							stone--;
							Game.anotherTurn = true;
						}
						
				 }
						
				if  (stone != 0) {
					PitsGraphicsPanel.playerPits[ nextIndex ].incrementStoneCount( );
					System.out.println("3 index is: " + index );
					System.out.println("3 nextIndex is: " + nextIndex );
					System.out.println("stonecount is: " + stone );
					Game.anotherTurn = false;

				}
			}
		
			PitsGraphicsPanel.playerPits[ index ].clearStones( );
			
			MancalaFrame.stonePaintGlassPane.repaint();
		}
		
		
		
		if ( anotherTurn == true ) 
			return true;
		
		else {
			System.out.println("Testing play game \nplayer turn = " + turn + "\nanotherTurn = " + anotherTurn);
		
			turn = ( turn + 1 ) % 2; // turn is either 0 ( for 1 ) or 1 ( for 2 )
			validStartIndex = ( validStartIndex + 6 ) % 12 ; // valid start is either 0 or 6
			anotherTurn = true; // enable turn again
			return false; // player turn is over
		}

	}
	
	public static boolean checkIndex(int indexClicked ) {
		
		if ( indexClicked < validStartIndex  || ( validStartIndex == 0 && indexClicked > 5 ) ) {
			JOptionPane.showMessageDialog( null, " Wrong selection, please try again ");
			return false;
		}
		else if ( indexClicked <= 12 && indexClicked >= 0 ) {
			return true;
		}
		
		else 
			return false;
	}
	
	public static String getTurn() {														 // print two if turn > 0
		String turnText = String.format( "Player %s turn",  ( turn == 0 ) ? "one" : "two" ); // print one for player one
		return turnText;
	}

}
