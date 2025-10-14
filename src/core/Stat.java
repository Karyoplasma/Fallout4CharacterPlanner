package core;

public enum Stat {
	HITPOINTS("HitPoints:"),
	CARRYWEIGHT("Carry Weight:"),
	ACTIONPOINTS("Action Points:"),
	LEVEL("Level:");

	private String name;

	private Stat(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
