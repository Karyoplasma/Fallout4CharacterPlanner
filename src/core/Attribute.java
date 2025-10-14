package core;

public class Attribute {

	private static final int MIN_LEVEL = 1;
	private static final int MAX_LEVEL = 10;
	private SPECIAL stat;
	private int baseLevel, extraLevel;

	public Attribute(SPECIAL stat, int level) {
		this.stat = stat;
		this.baseLevel = level;
		this.extraLevel = 0;
	}

	public int getAttributeLevel() {
		return this.baseLevel + this.extraLevel;
	}

	public boolean skillAttribute() {
		if (this.baseLevel < MAX_LEVEL) {
			this.baseLevel++;
			return true;
		}
		return false;
	}

	public boolean unskillAttribute() {
		if (this.baseLevel > MIN_LEVEL) {
			this.baseLevel--;
			return true;
		}
		return false;
	}

	public void boostAttribute(int boost) {
		this.extraLevel += boost;
	}

	public SPECIAL getStat() {
		return stat;
	}

	@Override
	public String toString() {
		return String.valueOf(this.getAttributeLevel());
	}
}
