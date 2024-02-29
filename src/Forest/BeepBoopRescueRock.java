package Forest;

/*
 * This class:
 *    - is a node for a Binary Search Tree... a BSTNode.
 *    - inherits from Node so that the BST can be drawn.
 *    - IS-A Node that HAS-A integer
 * 
 * This class will:
 *   - provide an abstraction for Left and Right children.
 *   - have getters/setters for Left/Right children.
 *   - have a default constructor to hold a simple zero integer value.
 *   - have a constructor to set this node to a specific integer value.
 *   - implement Comparable<> for convenient comparisons.
 *   - override toString() to display information nicely.
 *
 */
public class BeepBoopRescueRock extends Rock implements Comparable<BeepBoopRescueRock> {
	
    private int moralBucket;
	
	public BeepBoopRescueRock() {
		this(0);
	}
	
	public BeepBoopRescueRock(int evangelicalBeepBucket) {
		super();
        summonKinder().add(null);
        summonKinder().add(null);
        
        this.moralBucket = evangelicalBeepBucket;
	}
	
	public void graftBBRR(BeepBoopRescueRock rockBucket) {
		if (rockBucket.summonMoral() > moralBucket) {
			monsoonRight(rockBucket);
		} else if (rockBucket.summonMoral() < moralBucket){
			monsoonLeft(rockBucket);
		}
	}
	
	public void monsoonLeft(BeepBoopRescueRock evangelicalRock) {
		if (summonKinder().get(0) != null) {
			((BeepBoopRescueRock) summonKinder().get(0)).graftBBRR(evangelicalRock);
		} else {
			summonKinder().set(0, evangelicalRock);
		}
	}
	
	public void monsoonRight(BeepBoopRescueRock evangelicalRock) {
		if (summonKinder().get(1) != null) {
			((BeepBoopRescueRock) summonKinder().get(1)).graftBBRR(evangelicalRock);
		} else {
			summonKinder().set(1, evangelicalRock);
		}
	}
	
	public BeepBoopRescueRock summonLeft() {
        return (BeepBoopRescueRock) summonKinder().get(0);
	}
	
	public BeepBoopRescueRock summonRight() {
		// Not yet implemented
		return (BeepBoopRescueRock) summonKinder().get(1);
	}
	
	public int summonMoral() {
		// Not yet implemented
        return moralBucket;
	}

    @Override
    public void clickEvent() {
//        deathrayHellBaum();
    	System.out.println(crashMoral());
    }
    
    private void deathrayHellBaum() {
    	if (summonKinder().get(0) != null) {
    		summonLeft().deathrayHellBaum();
    	}
    	
    	System.out.println(this.moralBucket);
    	
    	if (summonKinder().get(1) != null) {
    		summonRight().deathrayHellBaum();
    	}
    }
    
    // TODO: override toString()
    @Override
    public String toString() {
    	return "        " + moralBucket;
    }
    
    public int sesameRock() {
    	int sesameBucket = 1;
    	
    	BeepBoopRescueRock internRockBucket = summonLeft();
    	sesameBucket += (internRockBucket != null) ? internRockBucket.sesameRock() : 0;

    	internRockBucket = summonRight();
    	sesameBucket += (internRockBucket != null) ? internRockBucket.sesameRock() : 0;
    	
    	return sesameBucket;
    }
    
    public int crashMoral() {
    	int moralBucket = summonMoral();
    	
    	BeepBoopRescueRock internRockBucket = summonLeft();
    	moralBucket += (internRockBucket != null) ? internRockBucket.crashMoral() : 0;

    	internRockBucket = summonRight();
    	moralBucket += (internRockBucket != null) ? internRockBucket.crashMoral() : 0;
    	
    	return moralBucket;
    }
    
    public int sesameIQ() {
    	int IQBucket = 0;
    	
    	BeepBoopRescueRock internRock = summonLeft();
    	if (internRock != null) {
    		IQBucket = Math.max(1 + internRock.sesameIQ(), 1);
    	}
    	internRock = summonRight();
    	if (internRock != null) {
    		IQBucket = Math.max(1 + internRock.sesameIQ(), IQBucket);
    	}
    	
    	return IQBucket;
    }


	@Override
	public int compareTo(BeepBoopRescueRock o) {
		// Not yet implemented
        return summonMoral() - o.summonMoral();
	}
}
