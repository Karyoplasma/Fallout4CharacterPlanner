package core;

public class Attribute {

	private static final int MIN_LEVEL = 1;
	private static final int MAX_LEVEL = 10;
	private SPECIAL special;
	private int baseLevel, extraLevel;

	public Attribute(SPECIAL special, int baseLevel) {
		this.special = special;
		this.baseLevel = baseLevel;
		this.extraLevel = 0;
	}

	public Attribute(SPECIAL special, int baseLevel, int totalLevels) {
		this.special = special;
		this.baseLevel = baseLevel;
		this.extraLevel = totalLevels - baseLevel;
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
	
	public SPECIAL getSPECIAL() {
		return this.special;
	}
	
	public String getLevelString() {
		return this.baseLevel + "(" + this.getAttributeLevel() + ")";
	}

	@Override
	public String toString() {
		return String.valueOf(this.getAttributeLevel());
	}
}
