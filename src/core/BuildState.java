package core;

import java.util.Map;

public class BuildState {

	public Attribute[] specialLevels;
	public Map<Perk, Integer> perkLevels;
	public Map<SPECIAL, Boolean> bobbleheads;
	public boolean survival, specialBook;
	public int remaining, pointsUsed;

}
