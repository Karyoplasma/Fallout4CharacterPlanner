package core;

public class Attribute {
	
	private static final int MIN_LEVEL = 1;
	private static final int MAX_LEVEL = 10;
	private Stat stat;
	private int baseLevel, extraLevel;
	
	public Attribute(Stat stat, int level){
		this.stat = stat;
		this.baseLevel = level;
		this.extraLevel = 0;
	}
	
	public int getAttributeLevel(){
		return this.baseLevel + this.extraLevel;
	}
	
	public boolean skillAttribute(){
		if (this.baseLevel < MAX_LEVEL) {
			this.baseLevel++;
			return true;
		}
//		System.out.println(String.format("BaseLevel: %d, ExtraLevel: %d", this.baseLevel, this.extraLevel));
		return false;
	}
	
	public boolean unskillAttribute(){
		if (this.baseLevel > MIN_LEVEL) {
			this.baseLevel--;
			return true;
		}
//		System.out.println(String.format("BaseLevel: %d, ExtraLevel: %d", this.baseLevel, this.extraLevel));
		return false;
	}
	
	public void boostAttribute(int boost) {
		this.extraLevel += boost;
	}
		
	@Deprecated
	public int getMinLevel(){
		return 1;
	}
	
	@Deprecated
	public int getMaxLevel(){
		return 10;
	}
	
	@Deprecated
	public void addBobblehead(){
		this.extraLevel++;
	}
	
	@Deprecated
	public void removeBobblehead(){
		this.extraLevel--;
	}

	public Stat getStat() {
		return stat;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getAttributeLevel());
	}
}
