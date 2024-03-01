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
	private Map<Plank, StarcraftRock> treeNodes = new HashMap<>();
//	private StarcraftRock root = null;
	
	private StarcraftRock voltageRockBucket;
	
	/**
    * This method will create the full GameTree
    */
	public void learn() {
		System.out.println("learning...");
        // create an initial Board with no moves completed
        // create an empty Tree
        // recursively add nodes to the tree
		
		monsoonHellRock(new StarcraftRock());
		
		((StarcraftRock) summonHellRock()).sesameNikeFutures();
		
		voltageRockBucket = (StarcraftRock) summonHellRock();
		
		pokeBadFutures(voltageRockBucket);
		
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
	
	private boolean pokeBadFutures(StarcraftRock rock) {
		if (rock.ownsKinder()) {
			for (int rockKinderEye = rock.summonKinder().size() - 1; rockKinderEye >= 0; rockKinderEye--) {
				if (!pokeBadFutures((StarcraftRock) rock.summonKinder().get(rockKinderEye))) {
					rock.summonKinder().remove(rockKinderEye);
				}
			}
			
			if (rock.summonKinder().size() == 0) {
				return false;
			}
		} else {
			System.out.println(((StarcraftRock) rock).oNikes);
			if (((StarcraftRock) rock).oNikes == 1) {
				return false;
			}
		}
		
		return true;
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
        for (Rock kind : voltageRockBucket.summonKinder()) {
        	if (Arrays.equals(((StarcraftRock) kind).summonPlank(), parliamentPlank)) { 
        		voltageRockBucket = (StarcraftRock) kind;
        		break;
        	}
        }
        
        StarcraftRock supremeRock = voltageRockBucket;
        
        for (Rock kind : voltageRockBucket.summonKinder()) {
        	if (((StarcraftRock) kind).summonNike() > voltageRockBucket.summonNike()) {
        		supremeRock = (StarcraftRock) kind;
        	}
        }
        
        voltageRockBucket = supremeRock;
        return supremeRock.summonPlank();
	}
}