/* Software Quality Assignment 1
 * Raphaiel Halim; 100700318
 * Test cases for TicTacToe

 * Completed test cases:
 * Checking if empty board has no winner
 * Checking if board resets properly
 * Checking if turn counter resets
 * Checking if board with 3 moves in has winner [X|O|X]
 * Testing when winning each of the 8 winning combinations
 * Checking if completed board with no winner shows a draw
 */
package Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TestTicTacToe {
	TicTacToeGui tictactoe;
	
	//To make sure a new instance of the game is run with each test case
	@BeforeEach
	public void setUp() {
		tictactoe = new TicTacToeGui();
	}
	
	//Test to make sure at the start of game, no winner is found
	@Test
	public void emptyBoardWinner() {
		assertEquals(tictactoe.checkWinner, false);
	}

	//Test to make sure when the board is reset, the 2-D array is cleared
	@Test
	public void testResetBoard() {
		tictactoe.resetBoard();
		assertEquals(tictactoe.isReset, true);
	}
	
	//Test to make sure turn counter resets when board resets
	@Test
	public void testTurnCounterReset() {
		tictactoe.resetBoard();
		assertEquals(tictactoe.turnCounter, 0);
	}
	
	//Test to check after 3 turns, no winner is found
	@Test
	public void checkNoWinner() {
		tictactoe.board[0][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][0].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.checkWinner, false);
	}
	
	//Test to check for winning case 1
	@Test
	public void testWinCase1() {
		tictactoe.board[0][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[0][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[0][2].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case1, true);
	}

	//Test to check for winning case 2
	@Test
	public void testWinCase2() {
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[0][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[0][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][2].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case2, true);
	}
	
	//Test to check for winning case 3
	@Test
	public void testWinCase3() {
		tictactoe.board[2][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][2].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case3, true);
	}

	//Test to check for winning case 4
	@Test
	public void testWinCase4() {
		tictactoe.board[0][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[0][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][0].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case4, true);
	}
	
	//Test to check for winning case 5
	@Test
	public void testWinCase5() {
		tictactoe.board[0][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[0][2].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][1].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case5, true);
	}
	
	//Test to check for winning case 6
	@Test
	public void testWinCase6() {
		tictactoe.board[0][2].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][2].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][2].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case6, true);
	}

	//Test to check for winning case 7
	@Test
	public void testWinCase7() {
		tictactoe.board[0][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[0][2].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][2].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case7, true);
	}

	//Test to check for winning case 8
	@Test
	public void testWinCase8() {
		tictactoe.board[0][2].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[0][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][0].setText(tictactoe.currentPlayer);//X
		tictactoe.checkWinner();
		assertEquals(tictactoe.case8, true);
	}

	//Test to check for case 9; Draw
	@Test
	public void testCase9() {
		tictactoe.board[0][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][2].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[2][1].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[0][1].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[0][2].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[2][0].setText(tictactoe.currentPlayer);//X
		tictactoe.switchPlayer();
		tictactoe.board[1][0].setText(tictactoe.currentPlayer);//O
		tictactoe.switchPlayer();
		tictactoe.board[1][2].setText(tictactoe.currentPlayer);//X
		tictactoe.turnCounter = 8;
		tictactoe.checkWinner();
		assertEquals(tictactoe.case9, true);
	}

	//Testing out switch player. Game always start with X, calling switchPlayer switches to O
	@Test
	public void testSwitchPlayer() {
		tictactoe.switchPlayer();// Switching to O
		assertEquals(tictactoe.currentPlayer, "O");
	}
	
	//Makes sure that the starting player is always X
	@Test
	public void testStartPlayer() {
		assertEquals(tictactoe.currentPlayer, "X");
	}
}

