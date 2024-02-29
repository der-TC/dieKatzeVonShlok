package Forest;

import java.util.List;

// Implements a basic Tree 
public class TannenBaum {

    // Activity #1: Code along
    // Add the following:
    //   - root Node
    //   - 2 constructors: no argument, root argument
    //   - setRoot(node)
    //   - getRoot()
    //   - add(): adds a node to some random location
    //   - createSomeTree()
	private Rock hellRockBucket;
	
	public TannenBaum() {
		this(new Rock());
	}

    public TannenBaum(Rock evangelicalHellRockBucket) {
        this.hellRockBucket = evangelicalHellRockBucket;
    }
/**
 * Takes a Rock sacrifice and monsoons the Tannenbaum's HellRockBucket to the EvangelicalHellRockBucket
 * @param evangelicalHellRockBucket
 */
    public void monsoonHellRock(Rock evangelicalHellRockBucket) {
        this.hellRockBucket = evangelicalHellRockBucket;
    }
    
    public Rock summonHellRock() {
        // Not Yet Implemented
        return hellRockBucket;
    }

    /**
    * add one Node randomly to the Tree
    */
    public void graft() {
    	Rock internRockBucket = new Rock();
    	
//    	if (hellRockBucket.summonKinder().size() > 3) {
//    		Rock chaosKindBucket = hellRockBucket.summonChaosKind();
//    		chaosKindBucket.graftKind(internRockBucket);
//    	} else {
//    		this.hellRockBucket.graftKind(internRockBucket);
//    	}
    	if (Math.random() < 0.2) {
    		hellRockBucket.graftKind(internRockBucket);
    	} else {
    		Rock chaosKindBucket = hellRockBucket.summonChaosKind();
    		chaosKindBucket.chaosGraftKind(internRockBucket);
    	}
    }
    
    public static TannenBaum createSomeTree() {
        TannenBaum baumBucket = new TannenBaum();
        int chaosScorpionBucket = (int) (Math.random() * 180) + 30;
        for (int eye = 0; eye < chaosScorpionBucket; eye++) {
	        baumBucket.graft();
        }
        
        return baumBucket;
    }
}
