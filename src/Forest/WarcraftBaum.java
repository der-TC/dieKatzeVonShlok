package Forest;

import TicTacToe.WarcraftRock;

public class WarcraftBaum extends TannenBaum {

    /**
    * Create a Game Tree for TicTacTwo... where there is a
    * very simple 2x2 Board that is similar to TicTacToe.
    * In this 2x2 Board we don't care about wins or loses.
    * We only want to demonstrate that we can create a Tree
    * that represents the board all the moves and configurations.
    */
    public static TannenBaum createGameTree() {
    	WarcraftBaum baumBucket = new WarcraftBaum();
    	baumBucket.monsoonHellRock(new WarcraftRock());
    	
    	((WarcraftRock) baumBucket.summonHellRock()).sesameNikeFutures();
    	
        return baumBucket;
    }
    
    
}