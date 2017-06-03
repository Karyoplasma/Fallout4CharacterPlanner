package core;

public class Attribute {
	
	private int minLevel, maxLevel;
	private Stat stat;
	private int level;
	
	public Attribute(Stat stat, int level){
		this.stat = stat;
		this.level = level;
		this.minLevel = 1;
		this.maxLevel = 10;
	}
	
	public int getAttributeLevel(){
		return this.level;
	}
	
	public boolean skillAttribute(){
		this.level++;
		return true;
	}
	
	public boolean unskillAttribute(){
		this.level--;
		return true;
	}
	
	public int getMinLevel(){
		return this.minLevel;
	}
	
	public int getMaxLevel(){
		return this.maxLevel;
	}
	
	public void addBobblehead(){
		this.maxLevel++;
		this.minLevel++;
		this.level++;
	}
	
	public void removeBobblehead(){
		this.minLevel--;
		this.maxLevel--;
		this.level--;
	}

	public Stat getStat() {
		return stat;
	}
}
