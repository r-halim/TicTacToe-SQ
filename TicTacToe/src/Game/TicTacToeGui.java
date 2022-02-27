/*
 * Software Quality Assignment 1
 * Raphaiel Halim; 100700318
 * TicTacToe GUI game
 * Contains all the methods for running the game
 */

package Game;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui extends JFrame{

	private static final long serialVersionUID = 1L; // serial auto added to stop warnings
	private Container pane;
	public String currentPlayer; //keeping track of current turn/player
	public JButton [] [] board; //2-D array for the board
	public boolean checkWinner; //boolean for checking the winner; if true, a winner is found
	private JMenuBar menuBar; //for the menu bar
	public JMenu menu; // for the drop-down menu
	public JMenuItem quit; // the quitting option for the game
	public JMenuItem newGame; // the new game option
	int turnCounter = 0; //turn counter to keep track of the number of turns played
	
	//Below are all the variables/booleans used for JUnit testing 
	boolean isReset = false; //to check board is reset; Mainly for testing
	boolean case1 = false; //used to check if case1 occurs
	boolean case2 = false; //used to check if case2 occurs
	boolean case3 = false; //used to check if case3 occurs
	boolean case4 = false; //used to check if case4 occurs
	boolean case5 = false; //used to check if case5 occurs
	boolean case6 = false; //used to check if case6 occurs
	boolean case7 = false; //used to check if case7 occurs
	boolean case8 = false; //used to check if case8 occurs
	boolean case9 = false; //used to check if case9 occurs
	
	public TicTacToeGui() {
		super(); // for referencing the parent class
		pane = getContentPane();
		pane.setLayout(new GridLayout(3,3));//setting up the layout of the board
		setTitle("TicTacToe");//Title of GUI window
		setSize(400,400);//Size of window
		setResizable(false);//turning off the option to resize window
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//making sure window closes when exiting
		setVisible(true);//making sure window is visible
		currentPlayer= "X";//always setting the starting player as "X"
		board = new JButton [3][3]; //setting board as 3x3 
		checkWinner = false; // making sure by default, the winner check is false by default since its an empty board
		setMenuBar();//calling the menu bar 
		setupBoard();// calling the board
	}
	
	//setting up the menu bar with the main option being "File" with two options underneath it;
	//Starting a "New game" and the option to "Quit" the game
	public void setMenuBar() {
		
		menuBar = new JMenuBar(); //creating the menu bar
		menu = new JMenu("File"); //creating first option in the menu bar

		//setting up the "New Game" option in menu bar
		//makes sure to reset the board every time the option is selected.
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		
		//setting up the "Quit" option in menu bar
		//makes sure to exit the program when option is selected
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//adding all the different options to the menu bar
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	//option to make sure to reset the board
	public void resetBoard() {
		//reseting the 3x3 array back to blank
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");
				isReset = true;
				turnCounter = 0;
				currentPlayer = "X";
				checkWinner = false;
			}
		}
	}
	
	//setting up the 3x3 board based on a 2-D array
	//adjusts font of the "X" and "O"'s 
	public void setupBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton button = new JButton();
				button.setFont(new Font(Font.SERIF, Font.BOLD, 75));
				board[i][j] = button;
				button.addActionListener(new ActionListener() {
					//keeping track of current action and switching players
					@Override
					public void actionPerformed(ActionEvent e) {
						//checking for valid move
						if(((JButton)e.getSource()).getText().equals("") && checkWinner == false){
							button.setText(currentPlayer); //putting the current player symbol in the board
							checkWinner(); //makes sure to run the check to see if the winner is found 
							switchPlayer(); //makes sure to switch player after each turn
							turnCounter++; //increments the turn counter after each play
						}
					}
				});
				pane.add(button);
			}
		}
	}
	
	//responsible for switching the players depending on who has current turn.
	public void switchPlayer() {
		if(currentPlayer.equals("X")) {
			currentPlayer = "O";
		}
		else {
			currentPlayer = "X";
		}
	}
	
	/*
	The method for checking the possible winning combinations
	method checks by going through the possible board possibilities by checking the 8 different combinations
	This is done by getting the symbol and checking if they match any of the combinations
	if 9 turns pass without a winner is found, a draw is reached
	*/
	public void checkWinner() {
		
		 	//Case 1; Top row horizontal win
		 	if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
	            checkWinner = true;
	            case1 = true;
	        }
	        
	        //Case 2; Middle row horizontal win
	        else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
	            checkWinner = true;
	            case2 = true;
	        }
	        
	        //Case 3; Bottom row horizontal win
	        else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            checkWinner = true;
	            case3 = true;
	        }
	        
	        //Case 4; Left vertical win
	        else if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
	            checkWinner = true;
	        	case4 = true;
	        }
	        
	        //Case 5; Middle vertical win
	        else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
	            checkWinner = true;
	            case5 = true;
	        }
	        
	        //Case 6; Right vertical win
	        else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            checkWinner = true;
	            case6 = true;
	        }
	        
	        //Case 7; Diagonal win top left to bottom right
	        else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
	            checkWinner = true;
	            case7 = true;
	        }
	        
	        //Case 8; Diagonal win top right to bottom left
	        else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
	            checkWinner = true;
	            case8 = true;
	        }
		 	
		 	//Case 9; Checks if after 8 turns have passed with no winner, thus meaning its a draw
	        else if(turnCounter == 8 && checkWinner == false) {
	        	JOptionPane.showMessageDialog(null, "Draw; No Winner :(");
	        	case9 = true;
	        }
		 	
		 	if (checkWinner == true) {
		 		JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won! :)");
		 	}
	}
}
