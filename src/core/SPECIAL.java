package core;

public enum SPECIAL {
	Strength("Strength"),
	Perception("Perception"),
	Endurance("Endurance"),
	Charisma("Charisma"),
	Intelligence("Intelligence"),
	Agility("Agility"),
	Luck("Luck");

	private String stat;

	SPECIAL(String stat) {
		this.stat = stat;
	}

	public String getStat() {
		return this.stat;
	}
}
