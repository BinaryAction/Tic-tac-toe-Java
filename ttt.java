package ticTacToe;

// coordinate system?
//   1 2 3
//
//A  # # #
//B  # # #
//C  # # #

public class ttt {
	public static char board[][] = {
			{'#', '#', '#'},
			{'#', '#', '#'}, 
			{'#', '#', '#'}
		};
	public static boolean gameRunning = true;
	public static char[] lettersCode = {'A', 'B', 'C'};
	public static int[] getCoordOfCode(String s) {
		char xChar = s.charAt(0);
		char yChar = s.charAt(1);
		int[] coords = new int[2];
		for (int i = 0; i < lettersCode.length; i++) {
			if (lettersCode[i] == xChar) {
				coords[0] = i;
				break;
			}
		}
		coords[1] = Character.getNumericValue(yChar)-1;
		return coords;
	}
	public static boolean checkSpotOpen(int coords[]) {
		return board[coords[0]][coords[1]] == '#';
	}
	// getAvailableSpots
	public static int[][] getOpenSpots(){
		int openSpots[][] = null;
		int openSpotsCount = 0;
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				// can i not pass a raw array in as a argument? :(
				//boolean open = checkSpotOpen({x, y});
				// oh i see why...
				if (checkSpotOpen(new int[]{x, y})) {
					openSpotsCount++;
				}
			}
		}
		openSpots = new int[openSpotsCount][2];
		int tracker = 0;
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (checkSpotOpen(new int[]{x, y})) {
					openSpots[tracker][0] = x;
					openSpots[tracker][1] = y;
					tracker++;
				}
			}
		}
		return openSpots;
	}
	public static char getPlayerMarker(String playerName) {
		if (playerName.equals("player")) {
			return 'X';
		}
		return 'O';
	}
	public static boolean markSpot(String s, String player) {
		int[] coords = getCoordOfCode(s);
		if (checkSpotOpen(coords)) {
			board[coords[0]][coords[1]] = getPlayerMarker(player);
			return true;
		}
		return false;
	}
	public static void checkSpots() {
		// check if its a draw first
		int spotsOpen = ttt.getOpenSpots().length;
		if (spotsOpen <= 0) {
			// draw
			System.out.println("Draw! No one wins.");
			gameRunning = false;
			return;
		}
		// player check
		// loop thru win tables, if it gets 3 trues from a single table then win
		for (boolean[][] scenario : winTables.scenarios) {
			// enhanced for loop :)
			int truthCountPlayer = 0;
			int truthCountNPC = 0;
			for (int row = 0; row < scenario.length; row++) {
				for (int c = 0; c < scenario[row].length; c++) {
					if (scenario[row][c] == true && board[row][c] == getPlayerMarker("player")) {
						truthCountPlayer++;
					} else if (scenario[row][c] == true && board[row][c] == getPlayerMarker("NPC")) {
						truthCountNPC++;
					}
				}
			}
			if (truthCountPlayer == 3) {
				System.out.println("Player Wins!!");
				gameRunning = false;
				System.out.println("Here is the resulting board!");
				displayBoard();
				return;
			} else if (truthCountNPC >= 3) {
				System.out.println("NPC Wins!!");
				gameRunning = false;
				System.out.println("Here is the resulting board!");
				displayBoard();
				return;
			}
		}
	}
	public static void displayBoard() {
		System.out.println("Showing board:");
		System.out.println("  1 2 3");
		for (int x = 0; x < board[0].length; x++) {
			System.out.print(lettersCode[x] + " ");
			for (int y = 0; y < board[1].length; y++) {
				System.out.print(board[x][y] + " ");
			}
			System.out.print('\n');
		}
	}
}
