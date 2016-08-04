package mancala;

import javax.swing.JOptionPane;

public class Game {

	private static int turn;
	private static boolean anotherTurn;
	private static int validStartIndex; // default at zero
	private static boolean aroundBoard;
	private static int pitCounter; // keeps track of how may pits have had stones placed. Used for finding adjacent pit for bonus
	private static int nextIndex;
	
	public  Game() {
		
		turn = 0;
		//anotherTurn = true;
		validStartIndex = 0;
		
	}
	
	public static boolean playTurn ( int index, int stone ) {
		
		// if user has pressed a valid pit on their side and stone count for that pit is > 0
		// play turn!
		if ( Game.checkIndex( index )  && stone > 0 ) { // make sure pit has more than 0 stones
														// so user turn won't switch on empty pit
			
			nextIndex = index + 1; // next index is one more than the current index
			aroundBoard = false; // initially false, used to track if user has left and returned to their side of board
			
			// while the pit at index has stones left, place stones in appropriate pit or store
			// increment pit counter by 1 and nextIndex
			// decrease stone by 1
			for ( pitCounter = 0; stone > 0; ++pitCounter, ++nextIndex, --stone ) {
				
				
				// if the nextIndex is 12 (larger than the pit array)
				if (  nextIndex  >= 12 ) {
					// check for user's validIndex
					// if this is their store, then drop a stone in and decrease stones
					if ( validStartIndex == 6 ) {
						PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( index );
						stone--;
						// if this is the last stone they place, they get another turn
						Game.anotherTurn = true;
				    // else if this is not player's store, they have returned to their side of the board
					// this enables the ability to steal stones if they land in an empty pit
					} else { 
						aroundBoard = true;
					}
					// either way, the next index is now 0 rather than 13
					nextIndex = 0;
				// if the nextIndex is 6, player is leaving top side of board
				} else if ( nextIndex  == 6 ) {
					// check if this is the current player's store
					// if it is, place a stone in their store, decrease amount of stones left
					if ( validStartIndex == 0 ) {
						PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( index );
						stone--;
						// if this is the last stone placed they get to go again
						Game.anotherTurn = true;
				   } else  // if this is not player's pit around board is true and bonus pit may be enabled
						aroundBoard = true;
				}
				// if the stone count is greater than 0, place a stone in the next pit
				// since they are placing in a pit, not a store, another turn is flagged as false
				if  (stone != 0) {
					PitsGraphicsPanel.playerPits[ nextIndex ].incrementStoneCount( index );
					anotherTurn = false;

				}
				MancalaTest.stonePaintGlassPane.repaint(); // repaint after each loop with a slight delay
			}// end regular playTurn loop
		}
		// if the player gets another turn, return true to continue game loop
		if ( anotherTurn == true ) 
			return true;
		// else 
		else if ( aroundBoard == true ) {
			// ( index + pitCounter ) % 12 will return the final Pit index in which a stone was placed
			int lastPitIndex = ( index + pitCounter ) % 12 ;
			// if that index is less than the current player's maximum pit index and greater than their minimum
			// also check if aroundBoard is true and if final pit has only 1 stone currently
			if ( lastPitIndex < ( validStartIndex + 6 ) && lastPitIndex > validStartIndex
					&& PitsGraphicsPanel.playerPits[ lastPitIndex ].getStoneCount() == 1) {
			
				checkForBonus( lastPitIndex );
			}
		}
		aroundBoard = false; // reflag as false
		anotherTurn = false;
		turn = ( turn + 1 ) % 2; // turn is either 0 ( for 1 ) or 1 ( for 2 )
		validStartIndex = ( validStartIndex + 6 ) % 12 ; // valid start is either 0 or 6
		checkForWinner();
		return false; // player turn is over
	}// end playTurn
	
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
		
		int oppositeIndex = ( 12 - ( finalPitIndex + 1 ) ); // player steals from opponent's pit next to theirs, this calculates index
		int bonusStones = PitsGraphicsPanel.playerPits[ oppositeIndex ].getStoneCount(); // get Stone count for bonus stones

		// increment player's store by the stone on their side
		PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( finalPitIndex );
		// take all stones from opponent's pit if there are any
		for ( int i = 0; i < bonusStones;  ++i ) {
			PitsGraphicsPanel.playerStore[ turn ].incrementStoneCount( oppositeIndex );

		}
		JOptionPane.showMessageDialog( null, "Empty pit bonus!\n" + 
				( bonusStones + 1 ) + " additional stones were added to your store" );
		
		MancalaTest.stonePaintGlassPane.repaint();

	}
	public static boolean checkForWinner() {
		
		for (int i = 0, emptyPits = 0; i < 12; ++i ) {
			if ( i % 6 == 0 )
				emptyPits = 0;
			if (  PitsGraphicsPanel.playerPits[ i ].getStoneCount() == 0 ) {
				++emptyPits;
			}
			if ( emptyPits == 6 ) {
				
				collectEndGameBonus( ( i == 5 ) ? 6 : 0 ); 
				
				JOptionPane.showMessageDialog( null, "Game Over!\nPlayer " +
						(( PitsGraphicsPanel.playerStore[ 0 ].getStoneCount() > PitsGraphicsPanel.playerStore[ 1 ].getStoneCount() ) ? "one" : "two" ) + " Wins!" );
				return true;
			}
		}
		return false;
	}
	
	public static void collectEndGameBonus( int bonusSideIndexStart ) {
		
		for (int i = bonusSideIndexStart; i < 6; ++i ) {
			while ( PitsGraphicsPanel.playerPits[ i ].getStoneCount() != 0) 
				PitsGraphicsPanel.playerStore[ ( bonusSideIndexStart % 5 ) ].incrementStoneCount( i );
		}
		MancalaTest.stonePaintGlassPane.repaint();
	}
}
