/*
* Software Quality Assignment 1
 * Raphaiel Halim; 100700318
 * Main program for executing
 */
package Game;
import javax.swing.SwingUtilities;

public class MainGui {
	public static void main (String args[]) {
		//making sure to call swing when starting the program
		//This is done otherwise swing doesn't generate the appropriate UI 
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TicTacToeGui(); //calling the TicTacToe game
			}
		});
	}
}
