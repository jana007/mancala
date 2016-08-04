package mancala;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HighScoreHandler {
	
	private ArrayList<HighScore> highScores;
	private static final String file = "highscores.txt";
	
	public HighScoreHandler() {
		highScores = new ArrayList< HighScore >();
		loadHighScores();
	}
     public void saveHighScores( ) {

	    // try to print to file, throws IOException
	    try {
	        //make stream
	        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
	        //loop through each object
	        for ( HighScore scores : highScores )
	            output.writeObject( scores );
	        //close stream
	        output.close();
	
	    } catch (IOException io) {
	        System.err.print("IOException");
	        io.printStackTrace();
	    }
	}
     public void loadHighScores( ) {

         // create a read in object
         HighScore highScore = null;
         try {
             //make stream
             ObjectInputStream input = new ObjectInputStream( new FileInputStream( file ) );
             try {

                 // run until EOF exception
                 while ( true ) {
                	 highScore = ( HighScore ) input.readObject();
                	  addScore( ( highScore ) );
                 }
             // end of file
             } catch ( EOFException eof ) {
                 input.close();
             } catch ( FileNotFoundException fnf ) {
                 System.err.print("FileNotFoundException");

             }
         // catch IOException
         } catch ( IOException io ) {
             System.err.print( "IOException" );
             io.printStackTrace();

         // catch class not found
         } catch ( ClassNotFoundException cn ) {
 	         System.err.print( "ClassNotFoundException" );
 	    }
     }
     public void addScore( HighScore hs ) {
    	 
    	 highScores.add( hs );
    	 saveHighScores( );
     }
     public String toString() {
    	 String scoreList = "";
    	 
    	 scoreList += String.format("Rank\tPlayer Name\tTurns Played\tScore\n" );
    	 scoreList += "---------------------------------------------------------------------------\n";
    	 
    	 int i = 0;
    	 for ( HighScore score : highScores )
    		 scoreList += String.format("%d\t%s\n", ++i, score.toString() );
    	 
    	 return scoreList;
     }
     
     public void sortScores() {
    	 
    	 
    	 
     }
     
}