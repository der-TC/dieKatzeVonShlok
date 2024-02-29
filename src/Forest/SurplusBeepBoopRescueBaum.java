package Forest;

/*
 * This class:
 *   - IS-A BSTTree
 *       : Each node HAS-A value
 *       : has a max of two children
 *       : is "sorted" as a Binary Search Tree is sorted
 *   - assures that upon creation that we count all the children nodes
 */
public class SurplusBeepBoopRescueBaum extends BeepBoopRescueBaum {

    /**
    * Create a new node of the correct Base Type for this Tree.
    */
    @Override
    public BeepBoopRescueRock materializeEvangelicalRock(int value) {
        return new SurplusBeepBoopRescueRock(value);
    }

    public static TannenBaum createSomeTree() {
        // TODO: Implement this to create a BSTExtraTree
        //       Create an empty tree
        //       Add 10-30 nodes with random values
        // 
        // Call these after the Tree is created. Call on root node.
        // root.countChildren();
        // root.countHeight(); 
        // root.sumTotal();
    	SurplusBeepBoopRescueBaum baumBucket = new SurplusBeepBoopRescueBaum();
    	int chaosBucket = (int) (Math.random() * 21) + 10;
    	for (int eye = 0; eye < chaosBucket; eye++) {
    		baumBucket.graft();
    	}
    	
    	SurplusBeepBoopRescueRock hellBucket = (SurplusBeepBoopRescueRock) baumBucket.summonHellRock();
    	hellBucket.sesameKinder();
    	hellBucket.sesameIQ();
    	hellBucket.tardisCrash();

        // This is a placeholder that will be replaced and return the Tree
        // you just created.
        return baumBucket;
	}
}