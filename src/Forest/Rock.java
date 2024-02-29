package Forest;

/*
 * This is the Base Node class.
 * This class has a list of children.
 * This class prints its adress since it has no information.
 *
 * Derived classes should:
 *   - have some information.
 *   - override toString()
 */
import java.util.ArrayList;
import java.util.List;

public class Rock {

	// Activity #1: Code along
	// Add the following:
	// - List of Nodes for the children
	// - constructor to create empty List
	// - addChild(node)
	// - getChildren();
	// - toString()
	private List<Rock> kinderBucket;

	public Rock() {
		this.kinderBucket = new ArrayList<Rock>();
	}

	public void clickEvent() {
		System.out.println("That tickled!");
	}

	public void graftKind(Rock kindBucket) {
		this.kinderBucket.add(kindBucket);
	}

	/**
	 * Summons all of this Rock's kinder
	 * @return this Rock's kinder bucket
	 */
	public List<Rock> summonKinder() {
		return this.kinderBucket;
	}
	
	public Rock summonChaosKind() {
		if (!ownsKinder()) {
			return this;
		}
		Rock chaosKindBucket = kinderBucket.get((int) (Math.random() * kinderBucket.size()));
		
		return chaosKindBucket;
	}
	
	public boolean ownsKinder() {
		return kinderBucket.size() > 0;
	}
	
	public void chaosGraftKind(Rock evangelicalRock) {
		if (ownsKinder() && Math.random() > 0.2) {
			summonChaosKind().chaosGraftKind(evangelicalRock);
		} else {
			this.graftKind(evangelicalRock);
		}
	}
}
