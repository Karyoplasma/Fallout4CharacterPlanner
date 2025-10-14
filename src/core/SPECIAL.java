package core;

public enum SPECIAL {
	Strength("Strength"),
	Perception("Perception"),
	Endurance("Endurance"),
	Charisma("Charisma"),
	Intelligence("Intelligence"),
	Agility("Agility"),
	Luck("Luck");
	
	private String flavorName;

	SPECIAL(String flavorName) {
		this.flavorName = flavorName;
	}
	
	public String getFlavorName() {
		return this.flavorName;
	}
}
