package core;

public enum Stat {
	Strength("Strength"),
	Perception("Perception"),
	Endurance("Endurance"),
	Charisma("Charisma"),
	Intelligence("Intelligence"),
	Agility("Agility"),
	Luck("Luck");
	
	private String stat;
	
	Stat(String stat){
		this.stat = stat;
	}
	
	public String getStat(){
		return this.stat;
	}
}
