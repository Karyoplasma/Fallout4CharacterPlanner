package core;

public enum Stat {
	HITPOINTS("HitPoints:"),
	CARRYWEIGHT("Carry Weight:"),
	ACTIONPOINTS("Action Points:"),
	LEVEL("Level:");
	
	private String flavorName;
	
	private Stat(String flavorName) {
		this.flavorName = flavorName;
	}

	@Override
	public String toString() {
		return this.flavorName;
	}
}
