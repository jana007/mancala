package mancala;

import javax.swing.JOptionPane;

public class Game {

	public static int turn;
	public static boolean anotherTurn;
	public static int validStartIndex; // default at zero
	
	public  Game() {
		
		turn = 0;
		//anotherTurn = true;
		validStartIndex = 0;
		
	}
	
	public static boolean playTurn ( int index, int stone ) {
		
		if ( Game.checkIndex( index )  && stone > 0 ) { // make sure pit has more than 0 stones
														// so user turn won't switch on empty pit
			int pitCounter;
			int nextIndex = index + 1;
			for ( pitCounter = 0; stone > 0; ++pitCounter, ++nextIndex, --stone ) {
				
				
				
				if (  nextIndex  >= 12 && validStartIndex == 6 ) {
					 
					PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( index );
					stone--;
					Game.anotherTurn = true;
					nextIndex = 0;
						
				} else if ( nextIndex  == 6 && validStartIndex == 0) {

					PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( index );
					stone--;
					Game.anotherTurn = true;
					
				}
				 
				if  (stone != 0) {
					System.out.println("i = " + pitCounter );
					System.out.println("nextIndex = " + nextIndex );
					System.out.println("stone = " + stone );
					PitsGraphicsPanel.playerPits[ nextIndex ].incrementStoneCount( index );
					Game.anotherTurn = false;

				}
			}
			MancalaFrame.stonePaintGlassPane.repaint();
			checkForBonus( ( index + pitCounter ) % 12 );
			MancalaFrame.stonePaintGlassPane.repaint();
			checkForWinner();
		}
		
		
		
		if ( anotherTurn == true ) 
			return true;
		
		else {
		
			turn = ( turn + 1 ) % 2; // turn is either 0 ( for 1 ) or 1 ( for 2 )
			validStartIndex = ( validStartIndex + 6 ) % 12 ; // valid start is either 0 or 6
			anotherTurn = false; // enable turn again
			return false; // player turn is over
		}

	}
	
	public static boolean checkIndex(int indexClicked ) {
		
		if ( indexClicked < validStartIndex  || ( validStartIndex == 0 && indexClicked > 5 ) ) {
			JOptionPane.showMessageDialog( null, " Wrong selection, please select from your side of the board");
			return false;
		}
		else if ( indexClicked <= 12 && indexClicked >= 0 ) {
			return true;
		}
		
		else 
			return false;
	}
	
	public static String getTurn() {
		String turnText = String.format( "Player %s %s",
				( ( turn == 0 ) ? "one" : "two" ) ,  // if turn is 0 print one, otherwise print two
				( ( anotherTurn == true ) ? "go again" : "turn" )); // if player has a second turn print go again
				
		return turnText;
	}
	
	public static void checkForBonus( int finalPitIndex ) {
		
		int i;
		int oppositeIndex = ( 12 - ( finalPitIndex + 1 ) );
		int bonusStones = PitsGraphicsPanel.playerPits[ oppositeIndex ].getStoneCount();

		if ( PitsGraphicsPanel.playerPits[ finalPitIndex ].getStoneCount() == 1) {
			
			PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( finalPitIndex );
			
			for ( i = 0; i < bonusStones;  ++i ) {
				System.out.println("i is : " +  i );
				System.out.println("opposite of finalpit index: " + oppositeIndex );
				System.out.println("opposite of finalpit stones: " + bonusStones );
				PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( 12 - ( finalPitIndex + 1 ) );

			}
			JOptionPane.showMessageDialog( null, "Empty pit bonus!\n" + 
					( i + 1 ) + " additional stones were added to your store" );
			
		}
	}
	public static boolean checkForWinner() {
		
		for (int i = 0, emptyPits = 0; i < 12; ++i ) {
			if ( i % 6 == 0 )
				emptyPits = 0;
			if (  PitsGraphicsPanel.playerPits[ i ].getStoneCount() == 0 ) {
				++emptyPits;
			}
			if ( emptyPits == 6 ) {
				
				
				
				JOptionPane.showMessageDialog( null, "Game Over!\nPlayer " +
						(( PitsGraphicsPanel.playerStore[ 0 ].getStoneCount() > PitsGraphicsPanel.playerStore[ 1 ].getStoneCount() ) ? "one" : "two" ) + " Wins!" );
				return true;
			}
		}
		return false;
	}
}
