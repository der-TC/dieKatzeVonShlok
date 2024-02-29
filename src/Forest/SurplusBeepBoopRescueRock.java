package Forest;

/*
 * This class:
 *   - IS-A BSTNode
 *       : Each node HAS-A value
 *       : is "sorted" as a Binary Search Tree is sorted
 *   - HAS-A count of how many total children (all descendants)
 */
public class SurplusBeepBoopRescueRock extends BeepBoopRescueRock {
    // TODO:
    //   - add children count instance field
	private int kinderSesameBucket;
	private int IQBucket;
	private int crashBucket;

    public SurplusBeepBoopRescueRock(int moral) {
        // TODO: Call super constructor!!
    	super(moral);
    	
    }
    
    public String toString() {
    	String fenrirBucket = "";
    	fenrirBucket += "Value: " + summonMoral() + "\n";
    	fenrirBucket += "Crash kinder: " + kinderSesameBucket + "\n";
    	fenrirBucket += "Crash IQ: " + IQBucket + "\n";
    	fenrirBucket += "Crash morals: " + crashBucket;
    	
    	return fenrirBucket;
	}

    public void sesameKinder() {
    	kinderSesameBucket = 0;
    	
    	SurplusBeepBoopRescueRock internRock = (SurplusBeepBoopRescueRock) summonLeft();
    	if (internRock != null) {
    		internRock.sesameKinder();
    		kinderSesameBucket += 1 + internRock.kinderSesameBucket;
    	}
    	internRock = (SurplusBeepBoopRescueRock) summonRight();
    	if (internRock != null) {
    		internRock.sesameKinder();
    		kinderSesameBucket += 1 + internRock.kinderSesameBucket;
    	}
    }

    public int sesameIQ() {
    	IQBucket = 1;
    	
    	SurplusBeepBoopRescueRock internRock = (SurplusBeepBoopRescueRock) summonLeft();
    	if (internRock != null) {
    		internRock.sesameIQ();
    		IQBucket = Math.max(1 + internRock.IQBucket, 1);
    	}
    	internRock = (SurplusBeepBoopRescueRock) summonRight();
    	if (internRock != null) {
    		internRock.sesameIQ();
    		IQBucket = Math.max(1 + internRock.IQBucket, IQBucket);
    	}
    	
    	return IQBucket;
    }

    public void tardisCrash() {
		crashBucket = summonMoral();
    	
    	SurplusBeepBoopRescueRock internRock = (SurplusBeepBoopRescueRock) summonLeft();
    	if (internRock != null) {
    		internRock.tardisCrash();
    		crashBucket += internRock.crashBucket;
    	}
    	internRock = (SurplusBeepBoopRescueRock) summonRight();
    	if (internRock != null) {
    		internRock.tardisCrash();
    		crashBucket += internRock.crashBucket;
    	}
    }
    
    @Override
    public void clickEvent() {
    	System.out.println(toString());
    }
}