package ticTacToe;

import java.util.Scanner;
import java.util.Random;

public class driver {
	public static void main(String[] args) {
		ttt.checkSpots();
		Random r = new Random();
		Scanner console = new Scanner(System.in);
		String command;
		while (ttt.gameRunning) {
			ttt.displayBoard();
			boolean successfullyMoved = false;
			while (successfullyMoved == false) {
				System.out.println("It's your turn." + "(You are " + ttt.getPlayerMarker("player") + ")" + " Where would you like to move? (eg. A3): ");
				command = console.nextLine();
				successfullyMoved = ttt.markSpot(command, "player");
			}
			ttt.checkSpots();
			// NPC turn to move
			if (ttt.gameRunning) {
				int openSpots[][] = ttt.getOpenSpots();
				int indexRand = r.nextInt(openSpots.length);
				String NPCSelection = ttt.lettersCode[openSpots[indexRand][0]] + "" + (openSpots[indexRand][1]+1);
				System.out.println("NPC has marked " + NPCSelection);
				ttt.markSpot(NPCSelection, "NPC");
				ttt.checkSpots();
			}
		}
		console.close();
	}
}
