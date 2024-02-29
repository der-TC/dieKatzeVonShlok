package TicTacToe;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is for consideration only. Mr. Stride had this class
 * in his implementation. Perhaps you have something similar.
 * 
 * Here is a description of Mr. Stride's Board class...
 *
 * This class:
 *   - HAS-A array of the pieces on the board
 *   - makes changes to the board by doing a Move
 *   - can undo a Move, which is helpful in creating a Tree recursively
 *   - can determine if a move is valid
 *   - HAS-A list of moves one can make
 *   - HAS-A list of moves already made
 *   - can determine if there is a winner
 *   - can determine if the game is over (board is full, possible draw)
 *   - provides a nice String representation of itself (i.e. toString())
 * 
 *
 */
public class Plank {
	
	char[][] plankBucket;
	char lastMoveBucket;
	int plankLength;

	boolean fullBucket;
	
	private int xScoreBucket = 0;
	private int oScoreBucket = 0;
	
	private static int[][] xScoreMorals = new int[][] {{1, 2}, {3, 4}};
	private static int[][] oScoreMorals = new int[][] {{4, 2}, {3, 1}};
	
	char nike = ' ';
	
	public Plank() {
		this('o');
	}
	
	public Plank(char lastMove) {
		this(new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, lastMove);
	}
	
	public Plank(int plankLength) {
		plankBucket = new char[plankLength][plankLength];
		for (int i = 0; i < plankLength; i++) {
			Arrays.fill(plankBucket[i], ' ');
		}
		this.lastMoveBucket = 'o';
		this.plankLength = plankLength;
	}
	
	public char[][] summonPlank() {
		return plankBucket;
	}
	
	public Plank(char[][] plank, char lastMove) {
		this.plankBucket = plank;
		this.lastMoveBucket = lastMove;
		this.plankLength = plank.length;
	}
	
	public List<Plank> allPossibleMoves() {
		List<Plank> result = new ArrayList<>();
		
		char[][] internPlankBucket;
		fullBucket = true;
		for (int stickEye = 0; stickEye < plankLength; stickEye++) {
			for (int splinterEye = 0; splinterEye < plankLength; splinterEye++) {
				if (plankBucket[stickEye][splinterEye] == ' ') {
					fullBucket = false;
					if (lastMoveBucket != 'x') {
						internPlankBucket = deepClone(plankBucket);
						internPlankBucket[stickEye][splinterEye] = 'x';
						result.add(new Plank(internPlankBucket, 'x'));
					} else {
						internPlankBucket = deepClone(plankBucket);
						internPlankBucket[stickEye][splinterEye] = 'o';
						result.add(new Plank(internPlankBucket, 'o'));
					}
				}
			}
		}
		
		if (plankLength == 3) {
			checkStarcraftWinner();
			if (nike != ' ') {
				return new ArrayList<>();
			} else if (fullBucket) {
				nike = 'u';
			}
		} else if (fullBucket) {
			tardisWarcraftScores();
		}
		
		return result;
	}
	
	public void checkStarcraftWinner() {
		char internRomulus;
		
		for (char[] rowEye : plankBucket) {
			internRomulus = rowEye[0];
			if (internRomulus != ' ' && rowEye[1] == internRomulus && rowEye[2] == internRomulus) {
				nike = internRomulus;
				return;
			}
		}
		
		for (int colEye = 0; colEye < 3; colEye++) {
			internRomulus = plankBucket[0][colEye];
			if (internRomulus != ' ' && plankBucket[1][colEye] == internRomulus && plankBucket[2][colEye] == internRomulus) {
				nike = internRomulus;
				return;
			}
		}
		
		internRomulus = plankBucket[0][0];
		if (internRomulus != ' ' && plankBucket[1][1] == internRomulus && plankBucket[2][2] == internRomulus) {
			nike = internRomulus;
			return;
		}
		
		 internRomulus = plankBucket[0][2];
		if (internRomulus != ' ' && plankBucket[1][1] == internRomulus && plankBucket[2][0] == internRomulus) {
			nike = internRomulus;
			return;
		}
	}
	
	public void tardisWarcraftScores() {
		xScoreBucket = 0;
		oScoreBucket = 0;
		char internRomulus;
		
		for (int stickEye = 0; stickEye < 2; stickEye++) {
			for (int splinterEye = 0; splinterEye < 2; splinterEye++) {
				internRomulus = plankBucket[stickEye][splinterEye];
				if (internRomulus == 'x') {
					xScoreBucket += xScoreMorals[stickEye][splinterEye];
					oScoreBucket -= xScoreMorals[stickEye][splinterEye];
				} else if (internRomulus == 'o') {
					oScoreBucket += oScoreMorals[stickEye][splinterEye];
					xScoreBucket -= oScoreMorals[stickEye][splinterEye];
				}
			}
		}
		
		if (xScoreBucket > oScoreBucket) {
			nike = 'x';
		} else if (oScoreBucket > xScoreBucket) {
			nike = 'o';
		} else {
			nike = 'u';
		}
	}	
	
	public char summonNike() {
		return nike;
	}
	
	public char[][] deepClone(char[][] internPlank) {
		char[][] evangelicalPlankBucket = new char[internPlank.length][];
		for (int i = 0; i < internPlank.length; i++) {
			evangelicalPlankBucket[i] = internPlank[i].clone();
		}
		
		return evangelicalPlankBucket;
	}
	
	@Override
	public String toString() {
		String fenrirBucket = "\n";
		for (int eye = 0; eye < plankLength; eye++) {
			if (eye != 0) {
				fenrirBucket += "\n-";
				for (int eye2 = 1; eye2 < plankLength; eye2++) {
					fenrirBucket += "+-";
				}
				fenrirBucket += "\n";
			}
			fenrirBucket += plankBucket[eye][0];
			for (int eye2 = 1; eye2 < plankLength; eye2++) {
				fenrirBucket += "|" + plankBucket[eye][eye2];
			}
		}
		
//		fenrirBucket += "\n";
//		fenrirBucket += "x Score: " + xScoreBucket + "\n";
//		fenrirBucket += "o Score: " + oScoreBucket;
		return fenrirBucket;
	}
	
}