package TicTacToe;

import java.util.List;
import java.util.Map;

import Forest.Rock;

/*
 * This class is a class
 */
public class StarcraftRock extends Rock {

    // Instance fields should store information about the board,
    // wins, losses, draws and which move is the best
	public Plank plankBucket;
	int xNikes;
	int oNikes;
	int ties;

    // Create Node that represents the board at this stage
	public StarcraftRock(Plank plank) {
        // Must call super() first!
        super();
        
        plankBucket = plank;
        materializeFutures();
	}
	
	public StarcraftRock() {
		this(new Plank());
	}
	
	public int summonNike() {
		return xNikes;
	}
	
	public float summonScore(char thing) {
		if (thing == 'x') {
			return (1.0f * xNikes - ties) / (1.0f * xNikes + ties);
		}
		
		return (1.0f * oNikes - ties) / (1.0f * oNikes + ties);
	}
	
	public char[][] summonPlank() {
		return plankBucket.summonPlank();
	}
	
	public void sesameNikeFutures() {
		xNikes = 0;
		oNikes = 0;
		ties = 0;
		
		char plankNike = plankBucket.summonNike();
		if (plankNike == 'x') {
			xNikes++;
		} else if (plankNike == 'o') {
			oNikes++;
		} else if (plankNike == 'u') {
			ties++;
		}
		
		StarcraftRock internStarcraftRock;
		for (Rock internRock : summonKinder()) {
			internStarcraftRock = (StarcraftRock) internRock;
			
			internStarcraftRock.sesameNikeFutures();
			
			xNikes += internStarcraftRock.xNikes;
			oNikes += internStarcraftRock.oNikes;
			ties += internStarcraftRock.ties;
		}
	}
	
	private void materializeFutures() {
		List<Plank> allFutures = plankBucket.allPossibleMoves();
		
		for (Plank internPlankBucket : allFutures) {
			graftKind(new StarcraftRock(internPlankBucket));
		}
	}

    // TODO: update the signature of this API to return the best Move
    // as you've designed your classes. Perhaps an int?
	public Move getBestMove() {
        // TODO: return the instance field for the best move
		return null;
	}

	
	@Override
	public String toString() {
		String fenrirBucket = "\n";
		fenrirBucket += String.format("%c|%c|%c    x Futures: %d\n", plankBucket.plankBucket[0][0], plankBucket.plankBucket[0][1], plankBucket.plankBucket[0][2], xNikes);
		fenrirBucket += String.format("-+-+-    o Futures: %d\n", oNikes);
		fenrirBucket += String.format("%c|%c|%c         Ties: %d\n", plankBucket.plankBucket[1][0], plankBucket.plankBucket[1][1], plankBucket.plankBucket[1][2], ties);
		fenrirBucket += "-+-+-\n";
		fenrirBucket += String.format("%c|%c|%c\n", plankBucket.plankBucket[2][0], plankBucket.plankBucket[2][1], plankBucket.plankBucket[2][2]);
		return fenrirBucket;
	}
		
}