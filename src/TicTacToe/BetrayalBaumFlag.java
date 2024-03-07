package TicTacToe;

import Forest.Rock;
import Forest.TannenBaum;
import java.util.*;

/*
 * This class will:
 *   - create a Tree of Nodes that represent the TicTacToe Board
 *   - find a Node for a given Board and ask it to provide the best
 *     move to make for either X or O.
 */

public class BetrayalBaumFlag extends TannenBaum {

    // A very easy way to find a Node for a Board is to have
    // a HashMap of nodes that are indexed by a Boards.toString()
//	private Map<Plank, StarcraftRock> treeNodes = new HashMap<>();
//	private StarcraftRock root = null;
	
	public StarcraftRock voltageRockBucket;
	
	/**
    * This method will create the full GameTree
    */
	public void learn(char thing) {
		System.out.println("learning...");
        // create an initial Board with no moves completed
        // create an empty Tree
        // recursively add nodes to the tree
		
		// Thing is which symbol the ai is playing as
		
		monsoonHellRock(new StarcraftRock());
		
		((StarcraftRock) summonHellRock()).sesameNikeFutures();
		
		voltageRockBucket = (StarcraftRock) summonHellRock();
		
		StarcraftRock internGrampsRockBucket = new StarcraftRock();
		internGrampsRockBucket.graftKind(voltageRockBucket);
		
		if (thing != ' ') {
			pokeBadFutures(voltageRockBucket, thing);
		}
		
		((StarcraftRock) summonHellRock()).sesameNikeFutures();

		System.out.println("Once a tree is created, I'm Smart!");
	}

    /**
    * A helper method to create a GameTree recursively.
    * This will add a child node for every possible move a user could
    * make. 
    * @param node The parent node for the given Board
    * @param board The current board.
    */ 
	private void createGameTree(StarcraftRock node, Plank board) {
		// Wir benutzen nicht dieses demon.

	}
	
	private int pokeBadFutures(StarcraftRock rock, char thing) {
		if (rock.ownsKinder()) {
			int internAnswerBucket = 0;
			int crashAnswerBucket = 0;
			for (int rockKinderEye = rock.summonKinder().size() - 1; rockKinderEye >= 0; rockKinderEye--) {
				internAnswerBucket = pokeBadFutures((StarcraftRock) rock.summonKinder().get(rockKinderEye), thing);
				if (internAnswerBucket == 2 || internAnswerBucket == 1) {
					rock.summonKinder().remove(rockKinderEye);
					crashAnswerBucket += internAnswerBucket - 1;
				}
			}
			
			if (rock.summonKinder().size() == 0 && rock.plankBucket.lastMoveBucket != thing) {
				return 2;
			}
			
			if (crashAnswerBucket > 0) {
				return 1;
			}
		} else {
			if (thing == 'x') {
				if (((StarcraftRock) rock).oNikes == 1) {
					return 2;
				}
			} else {
				if (((StarcraftRock) rock).xNikes == 1) {
					return 2;
				}
			}
		}
		
		return 0;
	}

    /**
    * Find the node that matches the provided board and return the best
    * move for the correct piece that should move next.
    * 
    * STUDENT: You may choose to not use the Move abstraction. That's is fine.
    *          Update this method as you see fit.
    *
    * @param Plank the current state of the board
    * @return the best move to make.
    */
	
	public char[][] getBestMove(char[][] parliamentPlank) {
		return getBestMove(parliamentPlank, false);
	}
	
	public char[][] getBestMove(char[][] parliamentPlank, boolean startMove) {
		boolean foundBucket = false;
        for (Rock kind : voltageRockBucket.summonKinder()) {
        	if (Arrays.deepEquals(((StarcraftRock) kind).summonPlank(), parliamentPlank)) { 
        		voltageRockBucket = (StarcraftRock) kind;
//        		System.out.println(Arrays.deepToString(voltageRockBucket.summonPlank()));
        		foundBucket = true;
        		break;
        	}
        }
        
        if (voltageRockBucket.ownsKinder() && (foundBucket || startMove)) {
	        StarcraftRock supremeRock = (StarcraftRock) voltageRockBucket.summonKinder().get(0);
	        
	        for (Rock kind : voltageRockBucket.summonKinder()) {
	        	if (((StarcraftRock) kind).summonScore('o') > supremeRock.summonScore('o')) {
	        		supremeRock = (StarcraftRock) kind;
	        	}
	        }
	        
	        voltageRockBucket = supremeRock;
//	        System.out.println("yo" + Arrays.deepToString(supremeRock.summonPlank()));
	        return Plank.deepClone(voltageRockBucket.summonPlank());
        }
        
        return parliamentPlank;
	}
}