package core;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import listeners.AttributeChangeListener;
import listeners.PerkChangeListener;

public class Character {
	private final PerkChangeListener perkListener;
	private final AttributeChangeListener specialListener;
	private Attribute[] special = new Attribute[7];
	private final Map<Perk, Integer> perks = new EnumMap<>(Perk.class);

	public Character(CharacterCalc calc) {
		this.special[0] = new Attribute(SPECIAL.Strength, 1);
		this.special[1] = new Attribute(SPECIAL.Perception, 1);
		this.special[2] = new Attribute(SPECIAL.Endurance, 1);
		this.special[3] = new Attribute(SPECIAL.Charisma, 1);
		this.special[4] = new Attribute(SPECIAL.Intelligence, 1);
		this.special[5] = new Attribute(SPECIAL.Agility, 1);
		this.special[6] = new Attribute(SPECIAL.Luck, 1);
		this.perkListener = calc;
		this.specialListener = calc;
	}

	public void removeStalePerks() {
		for (Perk perk : perks.keySet()) {
			if (this.special[perk.getSpecialTypeIndex()].getAttributeLevel() < perk.getSpecialRequirement()) {
				this.removePerk(perk);
			}
		}
	}

	private void removePerk(Perk perk) {
		int currentLevel = perks.getOrDefault(perk, 0);
		perks.remove(perk);
		perkListener.perkChanged(perk, currentLevel, 0, true);
	}

	public void skillPerk(Perk perk) {
		if (perk.getSpecialRequirement() > this.special[perk.getSpecialTypeIndex()].getAttributeLevel()) {
			return;
		}
		int currentValue = perks.getOrDefault(perk, 0);
		if (currentValue >= perk.getMaximumRanks()) {
			return;
		}
		perks.put(perk, currentValue + 1);
		perkListener.perkChanged(perk, currentValue, currentValue + 1, false);
	}

	public void unskillPerk(Perk perk) {
		int currentValue = perks.getOrDefault(perk, 0);
		if (currentValue > 0) {
			if (currentValue > 1) {
				perks.put(perk, currentValue - 1);
				perkListener.perkChanged(perk, currentValue, currentValue - 1, false);
			} else {
				perks.remove(perk);
				perkListener.perkChanged(perk, currentValue, 0, false);
			}

		}
	}

	public void skillAttribute(SPECIAL special) {
		Attribute toChange = this.special[special.ordinal()];
		int oldValue = toChange.getAttributeLevel();
		if (toChange.skillAttribute()) {
			specialListener.attributeChanged(toChange, oldValue, oldValue + 1, false);
		}
	}

	public void unskillAttribute(SPECIAL special) {
		Attribute toChange = this.special[special.ordinal()];
		int oldValue = toChange.getAttributeLevel();
		if (toChange.unskillAttribute()) {
			specialListener.attributeChanged(toChange, oldValue, oldValue - 1, false);
		}
	}

	public void boostAttribute(SPECIAL special, int boost) {
		Attribute toChange = this.special[special.ordinal()];
		int oldValue = toChange.getAttributeLevel();
		toChange.boostAttribute(boost);
		specialListener.attributeChanged(toChange, oldValue, oldValue + boost, true);
	}

	public int getPerkLevel(Perk perk) {
		return this.perks.getOrDefault(perk, 0);
	}

	public int getAttributeLevel(SPECIAL special) {
		return this.special[special.ordinal()].getAttributeLevel();
	}

	public int getMaximumPerkLevelRequirement() {
		return perks.entrySet().stream().mapToInt(e -> e.getKey().getLevelReq(e.getValue())).max().orElse(1);
	}

	public void saveState(BuildState state) {
		state.specialLevels = Arrays.copyOf(this.special, 7);
		state.perkLevels = new EnumMap<Perk, Integer>(this.perks);
	}

	public void loadState(BuildState state) {
		this.special = state.specialLevels;
		this.perks.clear();
		for (Map.Entry<Perk, Integer> perkLevel : state.perkLevels.entrySet()) {
			this.perks.put(perkLevel.getKey(), perkLevel.getValue());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SPECIAL: ").append(Arrays.toString(this.special));
		builder.append(System.getProperty("line.separator"));
		builder.append("Perks:").append(System.getProperty("line.separator"));
		for (Map.Entry<Perk, Integer> entry : perks.entrySet()) {
			builder.append(entry.getKey().getName()).append(": ").append(entry.getValue()).append("\n");
		}
		return builder.toString();
	}
}
