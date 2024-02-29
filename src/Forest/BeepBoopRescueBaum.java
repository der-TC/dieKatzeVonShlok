package Forest;

/*
 * This class implements a BST (Binary Search Tree)
 * All children on the Left are < self.
 * All children on the Right are >= self.
 *
 * The contents of each node is a simple primitive integer.
 *
 * This class:
 *   - provides the ability to add a value to the tree.
 *   - encapsulates the root node of the tree
 */ 

public class BeepBoopRescueBaum extends TannenBaum {

	public BeepBoopRescueBaum() {
		super();
		monsoonHellRock(materializeEvangelicalRock((int) (Math.random() * 100)));
	}
    // Our parent adds a node randomly to the tree.
    // This class creates a random number and adds it
    // to the tree to the right location for that number.
    @Override
    public void graft() {
        int romanBucket = (int) (Math.random()*100) + 1;
        graft(romanBucket);
    }

    /**
    * Create a new node of the correct Base Type for this Tree.
    * Derived classes should override.
    * This allows us to reuse the add(value) method.
    */
    public BeepBoopRescueRock materializeEvangelicalRock(int evangelicalMoral) {
        return new BeepBoopRescueRock(evangelicalMoral);
    }
    
    /**
    * This adds a value to the BST Tree so that we preserve the properties
    * of a Binary Search Tree.
    *
    * We create a Node and either:
    *   a) Make it our root because this is the first node
    *   b) Add it to our root node by calling our helper method
    *
    * @param value The integer value to add to the tree
    */
	public void graft(int evangelicalMoral) {
        // Not yet implemented
        // Tip: use createNewNode() instead of "new BSTNode(value)"
		BeepBoopRescueRock rockBucket = materializeEvangelicalRock(evangelicalMoral);
		((BeepBoopRescueRock) summonHellRock()).graftBBRR(rockBucket);
	}

    /*
    * Create a private helper method will add a Node to the Tree starting
    * at some parent node.
    * This method uses recursion to add the node to the correct child. 
    */
    // TODO: Create a private helper method to add a node via recursion


    /*
    * This static method creates a tree for graphing & inspection.
    */
    public static TannenBaum createSomeTree() {
		// TODO: update this with code to generate a more interesting Tree
        // that is of type BSTTree with BSTNodes.
    	BeepBoopRescueBaum baumBucket = new BeepBoopRescueBaum();
    	
    	int chaosBucket = (int) (Math.random() * 20) + 5;
    	for (int eye = 0; eye < chaosBucket; eye++) {
    		baumBucket.graft();
    	}
    	
        return baumBucket;
	}

    public void printTreeInOrder() {
        // Not Yet Implemented
    }

}

